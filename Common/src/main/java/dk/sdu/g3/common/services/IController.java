/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.services;

import dk.sdu.g3.common.entities.ILifeFunctions;
import java.util.List;

/**
 *
 * @author pvies
 */
public interface IController {
    
    List<IPlaceableEntity> getEntities();
//    IPlaceableEntity create();
    void remove(IPlaceableEntity entity);
    boolean decreaseHp(int damage);     // returns boolean indicating whether this damage killed the controller
    public void putEntityOnMap(IPlaceableEntity Entity,IMap map1) throws Exception;
    
}
