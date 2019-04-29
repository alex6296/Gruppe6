package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.entities.IMovable;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.ArrayList;
import java.util.List;


public class Tile implements ITile{
    
    private final Coordinate coord;
    private final int size;
    private ArrayList<IPlaceableEntity> entities = new ArrayList<>();
    
    
    public Tile(int x, int y, int size) {
        this.coord = new Coordinate(x, y);
        this.size = size;
    }
    
    
    public void add(IPlaceableEntity entity) {
        this.entities.add(entity);
    }
    
    public void remove(IPlaceableEntity entity) {
        this.entities.remove(entity);
    }

    @Override
    public Coordinate getCoordinate() {
        return this.coord;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public List<IPlaceableEntity> getEntities() {
        return this.entities;
    }

    @Override
    public boolean isOccupied() {
        for(IPlaceableEntity en : entities) {
            if (!(en instanceof IMovable)) {
                return true;
            }
        }
        return false;
    }
    
    
}
