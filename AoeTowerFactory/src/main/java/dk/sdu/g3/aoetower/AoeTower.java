package dk.sdu.g3.aoetower;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.IUnit;
import java.util.ArrayList;
import java.util.List;

public class AoeTower implements ITower {

    // functionality attributes
    private Coordinate pos;
    private int cost = 15;
    private int footprint = 1;
    private int atkspeed = 3;
    private int atkCounter = 0;
    private int damage = 25;
    private int range = 100;

    // rendering attributes
    private Graphic file = Graphic.AOETOWER;
    private IStage stage;
    private Layer layer = Layer.FORGOUND;
    private float posX, posY, width, height;

    
    public AoeTower() {
    }

    public AoeTower(int damage, int footprint, int cost, int attackSpeed, int attackRange, Coordinate position) {
        this.damage = damage;
        this.footprint = footprint;
        this.cost = cost;
        this.atkspeed = attackSpeed;
        this.range = attackRange;
        this.pos = position;
    }

    @Override
    public void setPosition(Coordinate coord) {
        this.pos = coord;
    }

    @Override
    public Coordinate getCurrentPosition() {
        return this.pos;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public int getFootprint() {
        return this.footprint;
    }

    @Override
    public int getActionSpeed() {
        return this.atkspeed;
    }

    @Override
    public int getImpact() {
        return this.damage;
    }

    @Override
    public int getRange() {
        return this.range;
    }

    @Override
    public List<IPlaceableEntity> action(List<IPlaceableEntity> targetList) {
        List<IPlaceableEntity> killedEntities = new ArrayList<>();
        atkCounter++;

        if (atkCounter >= atkspeed) {
            for (IPlaceableEntity entity : targetList) {
                if (entity instanceof IUnit) {
                    IUnit unit = (IUnit) entity;
                    if (unit.getCurrentHp() > 0) {
                        if (unit.takeDamage(this.damage)) {
                            killedEntities.add(entity);     // no break out of loop because AoeTowers attack all units in range
                        }
                    }
                }
            }
            atkCounter = 0;
        }

        return killedEntities;
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
