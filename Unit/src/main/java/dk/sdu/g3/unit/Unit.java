/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.sdu.g3.unit;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.rendering.IRenderableUnit;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.List;

/**
 *
 */
public class Unit implements IUnit, IRenderableUnit{
    
    
    public Unit(){
        
    }
    
    
    
    private final int MAXHP = 20;
    private int damage;
    private int hitPoints;
    private final int DAMAGE = 5;
    private Unit unit;
    private int costOfUnit;
    private ITile tile;
    private int[][] unitFootprint;
    private int attackRange;
    private int attackSpeed; 
    private Coordinate position;
    private final String spriteUrl = "";
    private Coordinate path;
    
    
    
    
    public Unit(int hitPoints, int damage, int[][] footprint, int cost, int attackRange, int attackSpeed, Coordinate position, Coordinate path){
        
        this.hitPoints = hitPoints; 
        this.damage = damage; 
        this.unitFootprint = footprint;
        this.costOfUnit = cost;
        this.attackRange = attackRange;
        this.attackSpeed = attackSpeed;
        this.position = position;
        this.path = path;
        
    }

    @Override
    public Coordinate getNextStep(Coordinate position) {
        
        if(!tile.isOccupied()){
           position = new Coordinate(position.getX(), position.getY());
           return position;
        }
      return null;
    }

   

    @Override
    public int[][] getFootprint() {
        
        return this.unitFootprint;
        
    }

    @Override
    public Coordinate getCurrentPosition() {           
        this.position = new Coordinate(position.getX(), position.getY());       
        return position;
        
    }

    @Override
    public int getCost() {
        return costOfUnit;
    }

    @Override
    public void setPosition(Coordinate coord) {   
       this.position = coord;
    }

    @Override
    public void attack(List<IPlaceableEntity> targetList) {
       
        
        for (IPlaceableEntity enti : targetList) {
           ILifeFunctions enty =  (ILifeFunctions) enti;
            
           if(enty.getCurrentHp() == 0){
               // Do nothing 
           }else{
                 enty.takeDamage(DAMAGE);
           }
        }
     
    }
   
    public String getSpriteUrl() {
        return this.spriteUrl;
    }

    @Override
    public int getMaxHp() {  
       return this.MAXHP;    
    }

    @Override
    public int getCurrentHp() {  
        return this.hitPoints;
    }
    public void setAttackSpeed(int attackSpeed){
        this.attackSpeed = attackSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getCostOfUnit() {
        return costOfUnit;
    }

    public void setCostOfUnit(int costOfUnit) {
        this.costOfUnit = costOfUnit;
    }

    public ITile getTile() {
        return tile;
    }

    public void setTile(ITile tile) {
        this.tile = tile;
    }

    public int[][] getUnitFootprint() {
        return unitFootprint;
    }

    public void setUnitFootprint(int[][] unitFootprint) {
        this.unitFootprint = unitFootprint;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    @Override
    public int getAttackSpeed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(Coordinate coord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setPath(Coordinate cord){
        this.path = cord;
    }
    
    public Coordinate getPath(){
        return path;
    }


}
