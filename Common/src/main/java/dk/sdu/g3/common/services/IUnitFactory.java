/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;

/**
 *
 * @author sebastian
 */
public interface IUnitFactory {
    
    public IUnit getNewUnit();
    

    public IUnit getNewUnit(int currentHp, int damage, int footprint, int cost, int attackRange, int attackSpeed, 
            Coordinate currentPosition, Coordinate path);
}
