package dk.sdu.g3.engine.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.engine.game.STDGame;
import dk.sdu.g3.engine.game.GameInputHandler;
import org.openide.util.Exceptions;

public class GameScreen implements Screen {

    private final STDGame game;

    final GameScreen gameScreen;
    //Send wave button
    private static final float WAVE_X = 0.7f;
    private static final float WAVE_Y = 0.025f;
    private static final float WAVE_BUTTON_X_SCALE = 0.25f;
    private static final float WAVE_BUTTON_Y_SCALE = 0.15f;

    //Return to menu button
    private static final float TO_MENU_X = 0.05f;
    private static final float TO_MENU_Y = 0.025f;
    private static final float TO_MENU_BUTTON_X_SCALE = 0.25f;
    private static final float TO_MENU_BUTTON_Y_SCALE = 0.15f;

    //Textures:
    private Texture background;

    public GameScreen(final STDGame game) {
        this.game = game;
        gameScreen = this;
        background = new Texture("assets/wall.png");
        background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        // adding input Processer
        Gdx.input.setInputProcessor(new GameInputHandler(game));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float f) {

      

            //gameloop
            game.gameLogic(f);

            //this is what renders stuff
            game.batch.begin();
            //drawing background
            game.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0, Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 3, false, false);

            renderButtons();

            try {
                game.renderer.renderAll();
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }

            game.batch.end();
        }


    public void renderButtons() {
        int imputY = (Gdx.graphics.getHeight() - Gdx.input.getY());
        int impx = (Gdx.input.getX());
        Color base = game.batch.getColor();
        Color tint = Color.LIGHT_GRAY;
        if (isSendWave(impx, imputY)) {
            game.batch.setColor(tint);
            game.batch.draw(game.getTexture(Graphic.SEND_WAVE), WAVE_X * Gdx.graphics.getWidth(), WAVE_Y * Gdx.graphics.getHeight(), WAVE_BUTTON_X_SCALE * Gdx.graphics.getWidth(), WAVE_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, game.getTexture(Graphic.SEND_WAVE).getWidth(), game.getTexture(Graphic.SEND_WAVE).getHeight(), false, false);
            game.batch.setColor(base);
        } else {
            game.batch.draw(game.getTexture(Graphic.SEND_WAVE), WAVE_X * Gdx.graphics.getWidth(), WAVE_Y * Gdx.graphics.getHeight(), WAVE_BUTTON_X_SCALE * Gdx.graphics.getWidth(), WAVE_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, game.getTexture(Graphic.SEND_WAVE).getWidth(), game.getTexture(Graphic.SEND_WAVE).getHeight(), false, false);
        }
        if (isMainMenu(impx, imputY)) {
            game.batch.setColor(tint);
            game.batch.draw(game.getTexture(Graphic.MAIN_MENU), TO_MENU_X * Gdx.graphics.getWidth(), TO_MENU_Y * Gdx.graphics.getHeight(), TO_MENU_BUTTON_X_SCALE * Gdx.graphics.getWidth(), TO_MENU_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, game.getTexture(Graphic.MAIN_MENU).getWidth(), game.getTexture(Graphic.MAIN_MENU).getHeight(), false, false);
            game.batch.setColor(base);
        } else {
            game.batch.draw(game.getTexture(Graphic.MAIN_MENU), TO_MENU_X * Gdx.graphics.getWidth(), TO_MENU_Y * Gdx.graphics.getHeight(), TO_MENU_BUTTON_X_SCALE * Gdx.graphics.getWidth(), TO_MENU_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, game.getTexture(Graphic.MAIN_MENU).getWidth(), game.getTexture(Graphic.MAIN_MENU).getHeight(), false, false);
        }
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        background.dispose();
    }

    public void handleButtonClick(int x, int y) {
        if (isMainMenu(x, y)) {
            gameScreen.dispose();
            game.mainMenu();
        } else if (isSendWave(x, y)) {
            game.startWavePhase();
        }
    }

    private boolean isMainMenu(int x, int y) {
        if (x > TO_MENU_X * Gdx.graphics.getWidth() && x <= TO_MENU_X * Gdx.graphics.getWidth() + TO_MENU_BUTTON_X_SCALE * Gdx.graphics.getWidth() && y > TO_MENU_Y * Gdx.graphics.getHeight() && y <= TO_MENU_Y * Gdx.graphics.getHeight() + TO_MENU_BUTTON_Y_SCALE * Gdx.graphics.getHeight()) {
            return true;
        }
        return false;
    }

    private boolean isSendWave(int x, int y) {
        if (x > WAVE_X * Gdx.graphics.getWidth() && x <= WAVE_X * Gdx.graphics.getWidth() + WAVE_BUTTON_X_SCALE * Gdx.graphics.getWidth() && y > WAVE_Y * Gdx.graphics.getHeight() && y <= WAVE_Y * Gdx.graphics.getHeight() + WAVE_BUTTON_Y_SCALE * Gdx.graphics.getHeight()) {
            return true;
        }
        return false;
    }
}
