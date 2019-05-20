package dk.sdu.g3.greenunit;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;
import dk.sdu.g3.common.services.IUnit;
import java.util.List;

public class GreenUnit implements IUnit {

    // funtionality attributes
    private int movespeed = 2;
    private int footprint = 1;
    private int MAXHP = 1500;
    private int hitpoints = 1500;
    private int cost = 5;
    private Coordinate pos;
    private List<Coordinate> path;
    
    // rendering attributes
    private final Graphic file = Graphic.GREENUNIT;
    private IStage stage;
    private final Layer layer = Layer.FORGOUND;
    private float posX, posY, width, height;
    
    
    public GreenUnit() {
    }
    
    public GreenUnit(int hitPoints, int footprint, int cost, Coordinate position, List<Coordinate> path) {
        this.MAXHP = hitPoints;
        this.hitpoints = hitPoints;
        this.footprint = footprint;
        this.cost = cost;
        this.pos = position;
        this.path = path;
    }
    
    @Override
    public void setPath(List<Coordinate> coordinates) {
        this.path = coordinates;
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
    public List<Coordinate> getPath() {
        return this.path;
    }

    @Override
    public int getMovespeed() {
        return this.movespeed;
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
    public int getCurrentHp() {
        return this.hitpoints;
    }

    @Override
    public int getMaxHp() {
        return this.MAXHP;
    }

    @Override
    public boolean takeDamage(int damage) {
        this.hitpoints -= damage;
        
        return !(this.hitpoints > 0);
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