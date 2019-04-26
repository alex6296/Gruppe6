package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.entities.IAction;
import dk.sdu.g3.common.entities.IMovable;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;


@ServiceProviders(value = { @ServiceProvider(service = IMap.class),})
public class Map implements IMap {

    private ArrayList<Tile> tiles;
    private int lengthX, lengthY;
    private int scaler = 50; // how large should tiles be in comparison to map? e.g. scaler = 100 means tileSize is 1% of mapsize.
    
    
    public Map() {      // this needs mutator methods for x and y lengths as well as a public generateMap method to work
    }
    
//    public Map(int lengthX, int lengthY) {
//        this.lengthX = lengthX;
//        this.lengthY = lengthY;
//        generateMap();
//    }
    
    
    @Override
    public void generateMap() {    // probably called right after constructor, generates list of tiles based on map size.
        
        tiles  = new ArrayList<>();
        
        int tileSize = lengthX / scaler;
        int x = 0;
        int y = 0;
        
        while (y < this.lengthY) {
            for (x = 0; x < this.lengthX; x += 2*tileSize) {
                tiles.add(new Tile(x+tileSize, y+tileSize, tileSize));
            }
            y += 2*tileSize;
        }
            
    }
    
    @Override
    public void addEntity(IPlaceableEntity entity) {
        Coordinate pos = entity.getCurrentPosition();
        getTile(pos).add(entity);
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
    public void setLengthX(int x) {
        this.lengthX = x;
    }
    
    @Override
    public void setLengthY(int y) {
        this.lengthY = y;
    }

    @Override
    public List<IPlaceableEntity> updatePositions() {
        ArrayList<IPlaceableEntity> toBeRemoved = new ArrayList<>();
        
        for (Tile tile : tiles) {
            for (IPlaceableEntity entity : tile.getEntities()) {
                if (entity instanceof IMovable) {
                    
                    tile.remove(entity);            // remove entity from the tile it is currently on
                    Coordinate currentPos = entity.getCurrentPosition();
                    Coordinate newPos = ((IMovable) entity).getNextStep(currentPos);
                    
                    if (newPos == null) {               // if entity has reached the end of its path, it should be despawned.
                        toBeRemoved.add(entity);
                        Coordinate endPos = new Coordinate(this.lengthX, currentPos.getY());    // unit is at the end of its path - it is put at the end of the map until a controller removes it.
                        entity.setPosition(endPos);
                        getTile(endPos).add(entity);        // place entity on end tile
                        continue;
                    }
                    
                    entity.setPosition(newPos);
                    getTile(newPos).add(entity);        // place entity on new tile
                    
                }
            }
        }
        
        return toBeRemoved;     // returns list of the units that made it to the endzone
    }

    @Override
    public void updateActions() {
        for (Tile tile : tiles) {
            for (IPlaceableEntity entity : tile.getEntities()) {
                if (entity instanceof IAction) {
                    ArrayList<IPlaceableEntity> targetList = findTargets((IAction) entity);     // find the possible targets for all entities that can do actions.
                    ((IAction) entity).action(targetList);                                      // execute actions on the possible targets. Entity picks a specific target on its own.
                }
            }
        }
    }
    
    private ArrayList<IPlaceableEntity> findTargets(IAction entity) {
        ArrayList<IPlaceableEntity> possibleTargets = new ArrayList<>();
        
        Coordinate pos = ((IPlaceableEntity) entity).getCurrentPosition();
        int range = entity.getRange();
        
        for (Tile tile : tiles) {
            if (Math.sqrt( Math.pow(tile.getCoordinate().getX() - pos.getX(), 2) + Math.pow(tile.getCoordinate().getY() - pos.getY(), 2) ) < range) {
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
            if (tile.getCoordinate().getX() - tile.getSize() < coord.getX() && tile.getCoordinate().getX() + tile.getSize() > coord.getX()
                    && tile.getCoordinate().getY() - tile.getSize() < coord.getY() && tile.getCoordinate().getY() + tile.getSize() > coord.getY()) {
                return tile;
            }
        }
        return null;
    }
}