package dk.sdu.g3.player;

import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IRenderableSprite;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;
import dk.sdu.g3.common.services.ITowerFactory;

public class TowerOnTowerPicker implements IRenderableSprite {

    private Object itf;

    private float width = (float) 0.3;
    private float height = (float) 0.3;
    private float posX = (float) 0.5;
    private float posY;
    private IStage picker;
    private Layer layer = Layer.FORGOUND;

    public TowerOnTowerPicker(IStage stage, float YPosition, Object itf) {
        this.picker = stage;
        this.posY = YPosition;
        this.itf = itf;
    }

    @Override
    public Graphic getFile() {
        return Graphic.TOWERS;
    }

    @Override
    public IStage getStage() {
        return picker;
    }

    @Override
    public void setStage(IStage stage) {
        this.picker = stage;
    }

    @Override
    public Layer getLayer() {
        return layer;
    }

    @Override
    public void setPosScaleX(final float scale) {
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

    public Object getItf() {
        return this.itf;
    }

    public void setItf(ITowerFactory itf) {
        this.itf = itf;
    }

}
