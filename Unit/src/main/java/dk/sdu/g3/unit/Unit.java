package dk.sdu.g3.unit;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;
import java.util.List;

public class Unit implements IUnit {

    // functionality attributes
    private int MAXHP = 1000;
    private int hitPoints = 1000;
    private int costOfUnit = 2;
    private int unitFootprint = 1;
    private Coordinate position;
    private List<Coordinate> path;
    private int movespeed = 4;

    // rendering attributes
    private final Graphic file = Graphic.ENEMYUNITS;
    private IStage stage;
    private final Layer layer = Layer.FORGOUND;
    private float posX, posY, width, height;

    
    public Unit() {
    }

    public Unit(int hitPoints, int footprint, int cost, Coordinate position, List<Coordinate> path, int speed) {
        this.MAXHP = hitPoints;
        this.hitPoints = hitPoints;
        this.unitFootprint = footprint;
        this.costOfUnit = cost;
        this.position = position;
        this.path = path;
        this.movespeed = speed;
    }

    @Override
    public Coordinate getNextStep(Coordinate pos) {
        for (int i = 0; i < path.size(); i++) {
            if (pos.getX() == path.get(i).getX() && pos.getY() == path.get(i).getY()) {
                if (i + movespeed < path.size()) {
                    return path.get(i + movespeed);
                }
            }
        }
        return null;
    }

    @Override
    public int getFootprint() {
        return this.unitFootprint;
    }

    @Override
    public Coordinate getCurrentPosition() {
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
    public int getMovespeed() {
        return this.movespeed;
    }

    @Override
    public int getMaxHp() {
        return this.MAXHP;
    }

    @Override
    public int getCurrentHp() {
        return this.hitPoints;
    }

    @Override
    public boolean takeDamage(int damage) {
        this.hitPoints -= damage;

        return !(this.hitPoints > 0);
    }

    public void setPath(List<Coordinate> cord) {
        this.path = cord;
    }

    @Override
    public List<Coordinate> getPath() {
        return path;
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
