/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.tower;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.services.ITower;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 */
@ServiceProviders(value = {
    @ServiceProvider(service = ITower.class),})
public class Tower implements ITower {

    private int life;
    private int damage;
    private int[][] footprint;
    private int cost;
    private int attackSpeed;
    private int attackRange;
    private Coordinate position;

    public Tower() {
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

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    @Override
    public void shoot(ILifeFunctions[] enemiesInRange) {
        for (ILifeFunctions e : enemiesInRange) {
            if (e.getCurrentHp() > 0) {
                e.takeDamage(this.damage);
                break;
            }
        }
    }

}
