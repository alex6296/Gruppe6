package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;
import java.util.List;

public interface IUnit extends IPlaceableEntity {

//    public Coordinate getNextStep(Coordinate position);
//    public void attack(List<IPlaceableEntity> targetList);
    public void setPath(List<Coordinate> cord);
//    public List<Coordinate> getPath();

}
