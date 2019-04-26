/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.tower;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.rendering.IRenderableUnit;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.IUnit;

public class Tower implements ITower, IRenderableUnit {

    private int life = 100;
    private int MAXLIFE = life;
    private int damage = 10;
    private int[][] footprint = new int[][]{{3}, {3}};
    private int cost = 50;
    private int attackSpeed = 4;
    private int attackRange = 5;
    private Coordinate position;
    final private String SpriteUrl = "\\Tower\\src\\assets\\tower.png";

    public Tower() {
    }

    /**
     * tower constructor
     *
     * @param life current life
     * @param damage done pr attack
     * @param footprint size of tiles the tower takes up
     * @param cost in ingame currensy
     * @param attackSpeed how many times the tower attacks pr. call to shoot;
     * @param attackRange how far the tower can attack
     * @param position wcordinates of the tower
     */
    public Tower(int life, int damage, int[][] footprint, int cost, int attackSpeed, int attackRange, Coordinate position) {
        this.life = life;
        this.damage = damage;
        this.footprint = footprint;
        this.cost = cost;
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.position = position;
    }

    public int getLife() {
        return life;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public int[][] getFootprint() {
        return footprint;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getAttackRange() {
        return attackRange;
    }

    @Override
    public Coordinate getCurrentPosition() {
        return position;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setFootprint(int[][] footprint) {
        this.footprint = footprint;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    @Override
    public void setPosition(Coordinate position) {
        this.position = position;
    }

    /**
     * Reduces the life, with this.getDamage, of the first validt unit in the
     * param. will loop until units damage and attackSpeed are qual or not more
     * Enemies in range exist.
     *
     * @param enemiesInRange a list of LifeFunctions[] objects of enemies in
     * range of the this tower.
     */
    @Override
    public void shoot(ILifeFunctions[] enemiesInRange) {

        for (int i = 0; i < this.attackSpeed; i++) {//amount of attacks

            for (ILifeFunctions e : enemiesInRange) {//targeting
                if (e.getCurrentHp() > 0 && e instanceof IUnit) { //check if target is dead
                    e.takeDamage(getDamage());//attack
                    break;//break after a target has been attacked
                }
            }
        }
    }

    @Override
    public int getMaxHp() {
        return this.MAXLIFE;
    }

    @Override
    public int getCurrentHp() {
        return this.life;
    }

    @Override
    public String getSpriteUrl() {
        return this.SpriteUrl;
    }

}
