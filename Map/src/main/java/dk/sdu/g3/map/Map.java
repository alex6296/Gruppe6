package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.entities.IMovable;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;


@ServiceProviders(value = { @ServiceProvider(service = IMap.class),})
public class Map implements IMap {

    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private int lengthX, lengthY;
    
    
    public Map() {
    }
    
    public Map(int lengthX, int lengthY) {
        this.lengthX = lengthX;
        this.lengthY = lengthY;
    }
    
    
    @Override
    public List<ITile> getTileList() {
        ArrayList<ITile> returnTiles = new ArrayList<ITile>();
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
        ArrayList<IPlaceableEntity> toBeRemoved = new ArrayList<IPlaceableEntity>();
        
        for (Tile tile : tiles) {
            for (IPlaceableEntity entity : tile.getEntities()) {
                if (entity instanceof IMovable) {
                    
                    tile.remove(entity);            // remove entity from the tile it is currently on
                    Coordinate currentPos = entity.getCurrentPosition();
                    Coordinate newPos = ((IMovable) entity).getNextStep(currentPos);
                    
                    if (newPos == null) {               // if entity has reached the end of its path, it should be despawned.
                        toBeRemoved.add(entity);
                        Coordinate endPos = new Coordinate(this.lengthX, currentPos.getY());    // unit is at the end of its path - it is put at the end of the map until a controller removes it.
                        entity.setCurrentPosition(endPos);
                        getTile(endPos).add(entity);        // place entity on end tile
                        continue;
                    }
                    
                    entity.setCurrentPosition(newPos);
                    getTile(newPos).add(entity);        // place entity on new tile
                    
                }
            }
        }
        
        return toBeRemoved;     // returns list of the units that made it to the endzone
    }

    @Override
    public void updateActions() {
        throw new UnsupportedOperationException("Not supported yet.");
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
