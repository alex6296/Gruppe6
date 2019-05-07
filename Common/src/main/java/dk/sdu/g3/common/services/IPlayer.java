package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;

public interface IPlayer extends IController {
    
    int getCurrentHp();
    boolean decreaseHp(int damage);     // returns boolean indicating whether this damage killed the controller
    int getCurrentGold();
    void placeReservedTower(Coordinate coor);
    void reserveTower(ITower tower);
    
}
