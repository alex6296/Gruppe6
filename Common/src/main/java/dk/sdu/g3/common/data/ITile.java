/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.data;

import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.List;

/**
 *
 * @author pvies
 */
public interface ITile {
    
    Coordinate getCoordinate();
    int getSize();
    List<IPlaceableEntity> getEntities();
    
    boolean isOccupied();
    
}
