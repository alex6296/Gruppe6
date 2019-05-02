/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import dk.sdu.g3.common.rendering.IRenderable;
import dk.sdu.g3.common.rendering.IRenderableSprite;
import dk.sdu.g3.common.rendering.IRenderableText;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.engine.game.STDGame;
import static javafx.scene.text.Font.font;

/**
 *
 * @author pvies
 */
public class Renderer {

    BitmapFont font;
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("assets/Ancient Medium.ttf"));
    FreeTypeFontParameter parameter = new FreeTypeFontParameter();

    private final STDGame game;

    public Renderer(final STDGame game) {
        this.game = game;
        font = generator.generateFont(parameter);

    }

    /**
     * this is the method that will be called everytime the Screen want to
     * render stuff
     */
    public void renderAll() {
        parameter.size = 50;
        font = generator.generateFont(parameter);
        font.setColor(Color.RED);
        font.draw(game.batch, "TEST Test og mere test", 100, 500);
        //font.dispose();

    }

    public void drawSprite(IRenderableSprite renderable) {
        Texture texture = new Texture(renderable.getFile());
        float X = getRenderX(renderable);
        float Y = getRenderY(renderable);
        float width = getRenderWith(renderable);
        float hight = getRenderHigth(renderable);
        int imageX = 0;
        int imagey = 0;
        int imageWidth = texture.getWidth();
        int imageHigth = texture.getHeight();
        boolean flipX = false;
        boolean flipy = false;
        game.batch.draw(texture, X, Y, width, hight, imageX, imagey, imageWidth, imageHigth, flipX, flipy);
        texture.dispose();
    }

    public void drawText(IRenderableText text) {
        //font.s
    }

    // methods for converting scales to screen sizes:
    private float getRenderX(IRenderable ren) {
        return (getStageWith(ren.getStage()) * ren.getPosScaleX() + getStageX(ren.getStage()) - (getRenderWith(ren) / 2));
    }

    private float getRenderY(IRenderable ren) {
        return getStageHigth(ren.getStage()) * ren.getPosScaleY() + getStageY(ren.getStage()) - getRenderHigth(ren) / 2;
    }

    private float getRenderWith(IRenderable ren) {
        return ren.getWithScale() * getStageWith(ren.getStage());
    }

    private float getRenderHigth(IRenderable ren) {
        return ren.getHigthScale() * getStageHigth(ren.getStage());
    }

    private float getStageX(IStage stage) {
        return stage.getPosScaleX() * Gdx.graphics.getWidth() - getStageWith(stage) / 2;
    }

    private float getStageY(IStage stage) {
        return stage.getPosScaleY() * Gdx.graphics.getHeight() - getStageHigth(stage) / 2;
    }

    private float getStageWith(IStage stage) {
        return stage.getWithScale() * Gdx.graphics.getWidth();
    }

    private float getStageHigth(IStage stage) {
        return stage.getHigthScale() * Gdx.graphics.getHeight();
    }

}
