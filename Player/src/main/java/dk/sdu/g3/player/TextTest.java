package dk.sdu.g3.player;

import dk.sdu.g3.common.rendering.Fonts;
import dk.sdu.g3.common.rendering.IRenderableText;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;

public class TextTest implements IRenderableText {

    private float x = (float) 0.1;
    private float y = (float) 0.03;
    private float width = (float) 0.8;
    private float height = (float) 0.1;
    private IStage stage;
    private Player player;
    private Fonts font = Fonts.ENCHANTED;
    private Layer layer = Layer.FORGOUND;

    public TextTest(IStage stage, Player player) {
        this.stage = stage;
        this.player = player;
    }

    @Override
    public String getText() {
        return "Gold " + player.getCurrentGold() + "          HP " + player.getCurrentHp();
    }

    @Override
    public float[] getColor() {
        return null;
    }

    @Override
    public Fonts getFont() {
        return font;
    }

    @Override
    public IStage getStage() {
        return stage;
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
        return this.x;
    }

    @Override
    public float getPosScaleY() {
        return this.y;
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
        this.x = scale;
    }

    @Override
    public void setPosScaleY(float scale) {
        this.y = scale;
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
