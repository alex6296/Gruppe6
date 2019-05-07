package dk.sdu.g3.common.entities;

import dk.sdu.g3.common.data.Coordinate;
import java.util.List;

public interface IMovable {
    
    List<Coordinate> getPath();
//    Coordinate getStartPos();
//    Coordinate getGoalPos();
    int getMovespeed();
    Coordinate getNextStep(Coordinate pos);
    
}
