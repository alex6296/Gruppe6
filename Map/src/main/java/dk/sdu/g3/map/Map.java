package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.entities.IAction;
import dk.sdu.g3.common.entities.IMovable;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.IRenderable;
import dk.sdu.g3.common.rendering.IRenderableSprite;
import dk.sdu.g3.common.serviceLoader.ServiceLoader;
import dk.sdu.g3.common.services.IPathfinding;

@ServiceProviders(value = {
    @ServiceProvider(service = IMap.class)
    ,
    @ServiceProvider(service = IStage.class),})
public class Map implements IMap, IStage {

    // renderable variables
    private float width = 0.58f;
    private float height = 0.79f;
    private float posX = 0.34f;
    private float posY = 0.58f;
    private Graphic background = Graphic.WALL;
    private float tileScaleX, tileScaleY;

    // functionality variables
    private ArrayList<Tile> tiles;
    private int lengthX, lengthY;
    private int scaler = 20;    // how large should tiles be in comparison to map? e.g. scaler = 100 means tileSize is 1% of mapsize.
    private ServiceLoader pathfs;

    
    public Map() {
        generateMap(600, 600);
        pathfs = new ServiceLoader(IPathfinding.class);
    }

    @Override
    public void generateMap(int lenX, int lenY) {

        this.lengthX = lenX;
        this.lengthY = lenY;

        tiles = new ArrayList<>();

        int tileSize = lengthX / scaler;
        tileScaleX = 2 * tileSize / (float) lengthX;
        tileScaleY = 2 * tileSize / (float) lengthY;

        int y = tileSize;
        while (y < this.lengthY) {
            for (int x = tileSize; x < this.lengthX; x += 2 * tileSize) {
                float tPosX = x / (float) lengthX;
                float tPosY = y / (float) lengthY;
                tiles.add(new Tile(x, y, tileSize, tPosX, tPosY, tileScaleX, tileScaleY, this));
            }
            y += 2 * tileSize;
        }

    }

    @Override
    public boolean addEntity(IPlaceableEntity entity) {
        Coordinate pos = entity.getCurrentPosition();

        if (!(entity instanceof IMovable) && (pos.getX() < getTileSize() * 2 || pos.getX() > lengthX - getTileSize() * 2)) {        // can't place towers in the first or last row
            return false;
        }

        getTile(pos).add(entity);

        if (!(entity instanceof IMovable)) {
            Coordinate startRow = new Coordinate(getTileSize(), getTileSize());
            Coordinate endRow = new Coordinate(lengthX - getTileSize(), lengthY - getTileSize());
            for (IPathfinding pathf : (List<IPathfinding>) pathfs.getServiceProviderList()) {             // checks if this blocks a viable path for units
                try {
                    pathf.generatePath(this, startRow, endRow);

                } catch (Exception ex) {
                    getTile(pos).remove(entity);            // if pathfinding can't find a valid path, the entity isn't allowed to be put on the map in that position
                    return false;
                }
            }
        }

        float scaleX = pos.getX() / (float) lengthX;
        float scaleY = pos.getY() / (float) lengthY;
        float widthScale = (float) tileScaleX * entity.getFootprint();
        float heightScale = (float) tileScaleY * entity.getFootprint();

        IRenderableSprite render = (IRenderableSprite) entity;
        render.setStage(this);
        render.setPosScaleX(scaleX);
        render.setPosScaleY(scaleY);
        render.setWithScale(widthScale);
        render.setHigthScale(heightScale);

        return true;
    }

    @Override
    public void removeEntity(IPlaceableEntity entity) {
        Coordinate pos = entity.getCurrentPosition();
        getTile(pos).remove(entity);
    }

    @Override
    public List<ITile> getTileList() {
        ArrayList<ITile> returnTiles = new ArrayList<>();
        for (Tile tile : tiles) {
            returnTiles.add(tile);
        }
        return returnTiles;
    }

    @Override
    public int getLengthX() {
        return this.lengthX;
    }

    @Override
    public int getLengthY() {
        return this.lengthY;
    }

    @Override
    public List<IPlaceableEntity> updatePositions() {
        ArrayList<IPlaceableEntity> toBeRemoved = new ArrayList<>();

        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);

            if (!tile.getEntities().isEmpty()) {
                for (int j = 0; j < tile.getEntities().size(); j++) {
                    IPlaceableEntity entity = tile.getEntities().get(j);
                    if (entity instanceof IMovable) {

                        tile.remove(entity);            // remove entity from the tile it is currently on
                        Coordinate currentPos = entity.getCurrentPosition();
                        Coordinate newPos = ((IMovable) entity).getNextStep(currentPos);

                        if (newPos == null) {               // if entity has reached the end of its path, it should be despawned.
                            toBeRemoved.add(entity);
                            Coordinate endPos = new Coordinate(this.lengthX - 1, currentPos.getY());    // unit is at the end of its path - it is put at the end of the map until a controller removes it.
                            entity.setPosition(endPos);
                            getTile(endPos).add(entity);        // place entity on end tile
                            
                            float scaleX = endPos.getX() / (float) lengthX;
                            float scaleY = endPos.getY() / (float) lengthY;
                            IRenderableSprite render = (IRenderableSprite) entity;
                            render.setPosScaleX(scaleX);
                            render.setPosScaleY(scaleY);
                            continue;
                        }

                        entity.setPosition(newPos);
                        getTile(newPos).add(entity);        // place entity on new tile

                        float scaleX = newPos.getX() / (float) lengthX;
                        float scaleY = newPos.getY() / (float) lengthY;
                        IRenderableSprite render = (IRenderableSprite) entity;
                        render.setPosScaleX(scaleX);
                        render.setPosScaleY(scaleY);

                    }
                }
            }
        }

        return toBeRemoved;     // returns list of the units that made it to the endzone
    }

    @Override
    public List<IPlaceableEntity> updateActions() {
        List<IPlaceableEntity> targetsAffected = new ArrayList<>();
        for (Tile tile : tiles) {
            for (IPlaceableEntity entity : tile.getEntities()) {
                if (entity instanceof IAction) {
                    ArrayList<IPlaceableEntity> targetList = findTargets((IAction) entity);     // find the possible targets for all entities that can do actions.
                    targetsAffected.addAll(((IAction) entity).action(targetList));      // execute actions on the possible targets. Entity picks a specific target on its own.
                }
            }
        }
        return targetsAffected;
    }

    private ArrayList<IPlaceableEntity> findTargets(IAction entity) {
        ArrayList<IPlaceableEntity> possibleTargets = new ArrayList<>();

        Coordinate pos = ((IPlaceableEntity) entity).getCurrentPosition();
        int range = entity.getRange();

        for (Tile tile : tiles) {
            if (Math.sqrt(Math.pow(tile.getCoordinate().getX() - pos.getX(), 2) + Math.pow(tile.getCoordinate().getY() - pos.getY(), 2)) < range) {
                possibleTargets.addAll(tile.getEntities());
            }
        }

        return possibleTargets;
    }

    @Override
    public List<IPlaceableEntity> inspect(Coordinate coord) {
        return getTile(coord).getEntities();
    }

    private Tile getTile(Coordinate coord) {
        for (Tile tile : tiles) {
            if (tile.getCoordinate().getX() - tile.getSize() <= coord.getX() && tile.getCoordinate().getX() + tile.getSize() > coord.getX()
                    && tile.getCoordinate().getY() - tile.getSize() <= coord.getY() && tile.getCoordinate().getY() + tile.getSize() > coord.getY()) {
                return tile;
            }
        }
        return null;
    }

    @Override
    public int getTileSize() {
        return tiles.get(0).getSize();
    }

    @Override
    public float getPosScaleX() {
        return this.posX;
    }

    @Override
    public float getPosScaleY() {
        return this.posY;
    }

    @Override
    public float getWithScale() {
        return this.width;
    }

    @Override
    public float getHigthScale() {
        return this.height;
    }

    @Override
    public Graphic getBackgroundFile() {
        return this.background;
    }

    @Override
    public List<IRenderable> getRenderables() {
        ArrayList<IRenderable> renderables = new ArrayList<>();
        for (Tile tile : tiles) {
            renderables.add(tile);
            for (IPlaceableEntity ren : tile.getEntities()) {
                renderables.add((IRenderable) ren);
            }
        }
        return renderables;
    }

    @Override
    public Object handleInput(float XScale, float YScale) {
        float x = lengthX * XScale;
        float y = lengthY * YScale;

        Coordinate coord = new Coordinate(Math.round(x), Math.round(y));

        return getTile(coord);
    }
}
