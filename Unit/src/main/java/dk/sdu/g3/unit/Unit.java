/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.sdu.g3.unit;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.IUnit;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.rendering.IRenderableUnit;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.List;

/**
 *
 */
@ServiceProviders(value = {@ServiceProvider (service = IUnit.class),})
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
    
    
    
    
    public Unit(int hitPoints, int damage, int[][] footprint, int cost
    , int attackRange, int attackSpeed, Coordinate position){
        
        this.hitPoints = hitPoints; 
        this.damage = damage; 
        this.unitFootprint = footprint;
        this.costOfUnit = cost;
        this.attackRange = attackRange;
        this.attackSpeed = attackSpeed;
        this.position = position;
        
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
    public void setCurrentPosition(Coordinate coord) {   
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

}
