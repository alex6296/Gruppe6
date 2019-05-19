package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import java.util.List;

public interface IMap {
    
    List<ITile> getTileList();
    int getLengthX();
    int getLengthY();
    void generateMap(int lenX, int lenY);
    boolean addEntity(IPlaceableEntity entity);
    void removeEntity(IPlaceableEntity entity);
    int getTileSize();
    
    List<IPlaceableEntity> updatePositions();
    List<IPlaceableEntity> updateActions();
    List<IPlaceableEntity> inspect(Coordinate coord);

}
