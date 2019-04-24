/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.tower;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.services.IUnit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class TowerTest {

    private int life = 100;
    private int damage = 10;
    private int[][] footprint = new int[][]{{3}, {3}};
    private int cost = 50;
    private int attackSpeed = 1;
    private int attackRange = 5;
    private Coordinate position;

    public TowerTest() {
    }

    /**
     * Test of shoot method, of class Tower.
     */
    @Test
    public void testShoot() {
        System.out.println("shoot");
        Tower instance = new Tower(life, damage, footprint, cost, attackSpeed, attackRange, position);
        ILifeFunctions lf = new Life(100);

        ILifeFunctions[] enemiesInRange = new ILifeFunctions[1];
        enemiesInRange[0] = lf;
        int expR = (enemiesInRange[0].getMaxHp()-damage*attackSpeed);

        instance.shoot(enemiesInRange);

         assertEquals(expR, enemiesInRange[0].getCurrentHp());    
    }

    public class Life implements ILifeFunctions, IUnit {

        private int hp = 100;
        private int ogHp = hp;

        public Life(int hp) {
            this.hp = hp;
            this.ogHp = hp;
        }

        @Override
        public int getCurrentHp() {
            return hp;
        }

        @Override
        public int getMaxHp() {
            return ogHp;
        }

        @Override
        public void takeDamage(int damage) {
            hp -= damage;
        }

        @Override
        public Coordinate getNextStep(Coordinate position) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void attack() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int[][] getFootprint() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Coordinate getCurrentPosition() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getCost() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
