package dk.sdu.g3.tower;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.IUnit;
import java.util.List;

public class Tower implements ITower {

    private int damage = 10;
    private int footprint = 1;
    private int cost = 50;
    private int attackSpeed = 4;
    private int attackRange = 20;
    private Coordinate position;

    // rendering attributes
    private final Graphic file = Graphic.TOWERS;
    private IStage stage = null;
    private final Layer layer = Layer.FORGOUND;
    private float posX, posY, width, height = 0;

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
    public Tower(int damage, int footprint, int cost, int attackSpeed, int attackRange, Coordinate position) {
        this.damage = damage;
        this.footprint = footprint;
        this.cost = cost;
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.position = position;
    }

    @Override
    public int getImpact() {
        return damage;
    }

    @Override
    public int getActionSpeed() {
        return attackSpeed;
    }

    @Override
    public int getRange() {
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

    @Override
    public void setPosition(Coordinate position) {
        this.position = position;
    }

    /**
     * Reduces the life, with this.damage, of the first validt unit in the
     * param. will loop until units damage and attackSpeed are qual or not more
     * Enemies in range exist.
     *
     * @param enemiesInRange a list of IPlaceableEntity objects of enemies in
     * range of the this tower.
     */
    @Override
    public void action(List<IPlaceableEntity> enemiesInRange) {

        for (int i = 0; i < this.attackSpeed; i++) {    //amount of attacks

            for (IPlaceableEntity e : enemiesInRange) { //targeting
                if (e instanceof IUnit) {
                    
                    IUnit enti = (IUnit) e;
                    if (enti.getCurrentHp() > 0) {      //check if target is dead
                        enti.takeDamage(this.damage);   //attack
                        break;                          //break after a target has been attacked
                    }
                    
                }
            }
        }
    }

    @Override
    public int getFootprint() {
        return footprint;
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
        return this.layer;
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
