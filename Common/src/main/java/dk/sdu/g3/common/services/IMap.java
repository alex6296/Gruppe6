/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import java.util.List;

/**
 *
 * @author pvies
 */
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
