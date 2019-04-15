/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.sdu.g3.common.services;

import dk.sdu.g3.common.entities.ILifeFunctions;

/**
 *
 */
public interface ITower extends IPlaceableEntity {
    
    public void shoot(ILifeFunctions[] enemiesInRange);

}
