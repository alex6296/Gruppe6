package dk.sdu.g3.map;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.entities.IMovable;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IRenderableSprite;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;
import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.ArrayList;
import java.util.List;


public class Tile implements ITile, IRenderableSprite {
    
    // renderable attributes
    private Layer layer = Layer.MIDGROUND;
    private Graphic file = Graphic.WALL2;
    private float posX;
    private float posY;
    private float width;
    private float height;
    private IStage stage;
    
    // functionality attributes
    private Coordinate coord;
    private int size;
    private ArrayList<IPlaceableEntity> entities = new ArrayList<>();
    
    
    public Tile(int x, int y, int size, float posXscale, float posYscale, float widthS, float heightS, IStage stage) {
        this.coord = new Coordinate(x, y);
        this.size = size;
        
        this.posX = posXscale;
        this.posY = posYscale;
        
        this.width = widthS;
        this.height = heightS;
        
        this.stage = stage;
    }
    
    
    public void add(IPlaceableEntity entity) {
        this.entities.add(entity);
    }
    
    public void remove(IPlaceableEntity entity) {
        this.entities.remove(entity);
    }

    @Override
    public Coordinate getCoordinate() {
        return this.coord;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public List<IPlaceableEntity> getEntities() {
        return this.entities;
    }

    @Override
    public boolean isOccupied() {
        for(IPlaceableEntity en : entities) {
            if (!(en instanceof IMovable)) {
                return true;
            }
        }
        return false;
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
