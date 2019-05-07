package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;

public interface ITowerFactory {

    public ITower getNewTower();
    public ITower getNewTower(int damage, int footprint, int cost, int attackSpeed, int attackRange, Coordinate position);

}
