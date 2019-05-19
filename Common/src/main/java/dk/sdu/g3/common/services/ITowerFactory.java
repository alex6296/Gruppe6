package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.rendering.Graphic;

public interface ITowerFactory {

    public ITower getNewTower();
    public ITower getNewTower(int damage, int footprint, int cost, int attackSpeed, int attackRange, Coordinate position);
    public Graphic getFile();

}
