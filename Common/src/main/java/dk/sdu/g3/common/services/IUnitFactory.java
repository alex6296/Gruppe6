package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;
import java.util.List;

public interface IUnitFactory {

    public IUnit getNewUnit();
    public IUnit getNewUnit(int currentHp, int footprint, int cost, Coordinate currentPosition, List<Coordinate> path, int speed);
    
}
