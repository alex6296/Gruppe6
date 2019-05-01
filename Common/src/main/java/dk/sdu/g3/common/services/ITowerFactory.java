/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;

/**
 *
 * @author Lenovo
 */
public interface ITowerFactory {

    public ITower getNewTower();

    public ITower getNewTower(int life, int damage, int footprint, int cost, int attackSpeed, int attackRange, Coordinate position);

}
