/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.factory;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.tower.Tower;

/**
 *
 * @author Lenovo
 */
public class towerFactory {

    public ITower getNewTower() {
        return (ITower) new Tower();
    }

    public ITower getNewTower(int life, int damage, int[][] footprint, int cost, int attackSpeed, int attackRange, Coordinate position) {
        return (ITower) new Tower(life, damage, footprint, cost, attackSpeed, attackRange, position);
    }

}
