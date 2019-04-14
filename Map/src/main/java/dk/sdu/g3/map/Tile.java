package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.entities.IMovable;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.ArrayList;
import java.util.List;


public class Tile implements ITile{
    
    private Coordinate coord;
    private int size = 5;
    private ArrayList<IPlaceableEntity> entities = new ArrayList<IPlaceableEntity>();
    
    
    public Tile(int x, int y) {
        this.coord = new Coordinate(x, y);
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
