package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;
import java.util.List;

public interface IPathfinding {
    
    List<Coordinate> generatePath(IMap map, Coordinate start, Coordinate goal) throws Exception; 
}
