package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;


@ServiceProviders(value = { @ServiceProvider(service = IMap.class),})
public class Map implements IMap {

    private ArrayList<ITile> tiles = new ArrayList<ITile>();
    private int lengthX, lengthY;
    
    
    public Map() {
        
    }
    
    public Map(int lengthX, int lengthY) {
        this.lengthX = lengthX;
        this.lengthY = lengthY;
    }
    
    
    @Override
    public List<ITile> getTileList() {
        return this.tiles;
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
    public List<IPlaceableEntity> updatePositions() {       // remember to remove entities as soon as x coordinate is greater than screen length
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IPlaceableEntity> inspect(Coordinate coord) {
        return getTile(coord).getEntities();
    }
    
    private ITile getTile(Coordinate coord) {
        for (ITile tile : tiles) {
            if (tile.getCoordinate().getX() - tile.getSize() < coord.getX() && tile.getCoordinate().getX() + tile.getSize() > coord.getX()
                    && tile.getCoordinate().getY() - tile.getSize() < coord.getY() && tile.getCoordinate().getY() + tile.getSize() > coord.getY()) {
                return tile;
            }
        }
        return null;
    }
}
