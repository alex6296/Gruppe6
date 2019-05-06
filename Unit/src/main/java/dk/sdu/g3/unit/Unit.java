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
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IRenderableSprite;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.List;

/**
 *
 */
public class Unit implements IUnit, IRenderableSprite {
    
    private final int MAXHP = 20;
    private int damage;
    private int hitPoints;
    private final int DAMAGE = 5;
    private Unit unit;
    private int costOfUnit;
    private ITile tile;
    private int unitFootprint;
    private int attackRange;
    private int attackSpeed; 
    private Coordinate position;
    private final String spriteUrl = "";
    private List<Coordinate> path;
    
    // rendering attributes
    private Graphic file = Graphic.Coins;
    private IStage stage;
    private Layer layer = Layer.FORGOUND;
    private float posX, posY, width, height;
    
    
    
    public Unit(){
        
    }
    
    public Unit(int hitPoints, int damage, int footprint, int cost, int attackRange, int attackSpeed, Coordinate position, List<Coordinate> path){
        
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
    public int getFootprint() {
        
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

    public int getMaxHp() {  
       return this.MAXHP;    
    }

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

    public int getUnitFootprint() {
        return unitFootprint;
    }

    public void setUnitFootprint(int unitFootprint) {
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
        return this.attackSpeed;
    }

    
    public void setPath(List<Coordinate> cord){
        this.path = cord;
    }
    
    @Override
    public List<Coordinate> getPath(){
        return path;
    }

    @Override
    public int getLife() {
        return this.hitPoints;
    }

    @Override
    public Graphic getFile() {
        return this.file;
    }

    @Override
    public IStage getStage() {
        return this.stage;
    }

    @Override
    public void setStage(IStage stage) {
        this.stage = stage;
    }

    @Override
    public Layer getLayer() {
        return layer;
    }

    @Override
    public float getPosScaleX() {
        return this.posX;
    }

    @Override
    public float getPosScaleY() {
        return this.posY;
    }

    @Override
    public float getWithScale() {
        return this.width;
    }

    @Override
    public float getHigthScale() {
        return this.height;
    }

    @Override
    public void setPosScaleX(float scale) {
        this.posX = scale;
    }

    @Override
    public void setPosScaleY(float scale) {
        this.posY = scale;
    }

    @Override
    public void setWithScale(float scale) {
        this.width = scale;
    }

    @Override
    public void setHigthScale(float scale) {
        this.height = scale;
    }


}