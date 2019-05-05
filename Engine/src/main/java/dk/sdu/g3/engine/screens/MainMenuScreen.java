package dk.sdu.g3.engine.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.g3.engine.game.STDGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;

public class MainMenuScreen implements Screen {

    private final STDGame game;

    //Textures:
    private Texture background;
    private Texture newGame;
    private Texture highScore;
    private Texture settings;
    private Texture exit;
    private Texture menyLogo;
    private Texture tourch; // hvis vi skal bruge dem

    private static final float MENY_LOGO_OFFSET = 0.775f;
    private static final float MENY_LOGO_X_SCALE = 0.35f;
    private static final float MENY_LOGO_Y_SCALE = 0.2f;

    // menu buttons
    private static final float START_OFFSET = 0.6f;
    private static final float SETTINGS_OFFSET = 0.2f;
    private static final float HIGHSCORE_OFFSET = 0.4f;
    private static final float MENY_BUTTON_X_SCALE = 0.25f;
    private static final float MENY_BUTTON_Y_SCALE = 0.15f;

    //Exit buttons
    private static final float EXIT_OFFSET = 0.05f;
    private static final float EXIT_X_SCALE = 0.2f;
    private static final float EXIT_Y_SCALE = 0.1f;

    public MainMenuScreen(final STDGame game) {
        this.game = game;
        final MainMenuScreen mainMenu = this;
        loadTextures();

        //seting up imput processor
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                int gameY = (Gdx.graphics.getHeight() - screenY);
                //Play Button
                if (screenX > getLeftX(MENY_BUTTON_X_SCALE) && screenX < getRightX(MENY_BUTTON_X_SCALE) && gameY > getLowerY(START_OFFSET) && gameY < getUpperY(START_OFFSET, MENY_BUTTON_Y_SCALE)) {
                    mainMenu.dispose();
                    game.StartGame();
                    
                }

                //Highscore Button
                if (screenX > getLeftX(MENY_BUTTON_X_SCALE) && screenX < getRightX(MENY_BUTTON_X_SCALE) && gameY > getLowerY(HIGHSCORE_OFFSET) && gameY < getUpperY(HIGHSCORE_OFFSET, MENY_BUTTON_Y_SCALE)) {
                    System.out.println("you hit Highscore, ist not implemenet yet");
                }

                //Settings Button
                if (screenX > getLeftX(MENY_BUTTON_X_SCALE) && screenX < getRightX(MENY_BUTTON_X_SCALE) && gameY > getLowerY(SETTINGS_OFFSET) && gameY < getUpperY(SETTINGS_OFFSET, MENY_BUTTON_Y_SCALE)) {
                    System.out.println("you hit Settings, ist not implemenet yet");
                }

                //Exit Button
                if (screenX > getLeftX(EXIT_X_SCALE) && screenX < getRightX(EXIT_X_SCALE) && gameY > getLowerY(EXIT_OFFSET) && gameY < getUpperY(EXIT_OFFSET, EXIT_Y_SCALE)) {
                    mainMenu.dispose();
                    Gdx.app.exit();;
                }
                return true;
            }

        });
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float f) {
        game.batch.begin();
        // getting the base color
        Color base = game.batch.getColor();
        Color tint = Color.LIGHT_GRAY;

        int imputY = (Gdx.graphics.getHeight() - Gdx.input.getY());
        int impx = (Gdx.input.getX());

        //drawing background
        //game.batch.draw(background, 0, 0, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0, Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 3, false, false);

        //drawing static art
        float x = getLeftX(MENY_LOGO_X_SCALE);
        float y = getLowerY(MENY_LOGO_OFFSET);
        game.batch.draw(menyLogo, x, y, MENY_LOGO_X_SCALE * Gdx.graphics.getWidth(), MENY_LOGO_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, menyLogo.getWidth(), menyLogo.getHeight(), false, false);

        //drawing buttons
        x = getLeftX(MENY_BUTTON_X_SCALE);

        //start game Button
        y = getLowerY(START_OFFSET);
        if (impx > x && impx < getRightX(MENY_BUTTON_X_SCALE) && imputY > y && imputY < getUpperY(START_OFFSET, MENY_BUTTON_Y_SCALE)) {
            game.batch.setColor(tint);
            game.batch.draw(newGame, x, y, MENY_BUTTON_X_SCALE * Gdx.graphics.getWidth(), MENY_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, newGame.getWidth(), newGame.getHeight(), false, false);
            game.batch.setColor(base);
        } else {
            game.batch.draw(newGame, x, y, MENY_BUTTON_X_SCALE * Gdx.graphics.getWidth(), MENY_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, newGame.getWidth(), newGame.getHeight(), false, false);
        }

        //HighScore button
        y = getLowerY(HIGHSCORE_OFFSET);
        if (impx > x && impx < getRightX(MENY_BUTTON_X_SCALE) && imputY > y && imputY < getUpperY(HIGHSCORE_OFFSET, MENY_BUTTON_Y_SCALE)) {
            game.batch.setColor(tint);
            game.batch.draw(highScore, x, y, MENY_BUTTON_X_SCALE * Gdx.graphics.getWidth(), MENY_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, highScore.getWidth(), highScore.getHeight(), false, false);
            game.batch.setColor(base);
        } else {
            game.batch.draw(highScore, x, y, MENY_BUTTON_X_SCALE * Gdx.graphics.getWidth(), MENY_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, highScore.getWidth(), highScore.getHeight(), false, false);
        }
        //Settings button
        y = getLowerY(SETTINGS_OFFSET);
        if (impx > x && impx < getRightX(MENY_BUTTON_X_SCALE) && imputY > y && imputY < getUpperY(SETTINGS_OFFSET, MENY_BUTTON_Y_SCALE)) {
            game.batch.setColor(tint);
            game.batch.draw(settings, x, y, MENY_BUTTON_X_SCALE * Gdx.graphics.getWidth(), MENY_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, settings.getWidth(), settings.getHeight(), false, false);
            game.batch.setColor(base);
        } else {
            game.batch.draw(settings, x, y, MENY_BUTTON_X_SCALE * Gdx.graphics.getWidth(), MENY_BUTTON_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, settings.getWidth(), settings.getHeight(), false, false);
        }

        //Exit Button
        x = getLeftX(EXIT_X_SCALE);
        y = getLowerY(EXIT_OFFSET);
        if (impx > x && impx < getRightX(EXIT_X_SCALE) && imputY > y && imputY < getUpperY(EXIT_OFFSET, EXIT_Y_SCALE)) {
            game.batch.setColor(tint);
            game.batch.draw(exit, x, y, EXIT_X_SCALE * Gdx.graphics.getWidth(), EXIT_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, exit.getWidth(), exit.getHeight(), false, false);
            game.batch.setColor(base);
        } else {
            game.batch.draw(exit, x, y, EXIT_X_SCALE * Gdx.graphics.getWidth(), EXIT_Y_SCALE * Gdx.graphics.getHeight(), 0, 0, exit.getWidth(), exit.getHeight(), false, false);
        }

        game.batch.end();
    }

    @Override
    public void resize(int i, int i1
    ) {

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
        menyLogo.dispose();
        newGame.dispose();
        settings.dispose();
        highScore.dispose();
        exit.dispose();
    }

    private void loadTextures() {
        background = new Texture("assets/wall.png");
        background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        menyLogo = new Texture("assets/startmenu.png");
        newGame = new Texture("assets/newgame.png");
        settings = new Texture("assets/settings.png");
        highScore = new Texture("assets/highscore.png");
        exit = new Texture("assets/exit.png");
    }

    private float getLeftX(float scale) {
        return Gdx.graphics.getWidth() / 2 - scale * (Gdx.graphics.getWidth() / 2);
    }

    private float getRightX(float scale) {
        return Gdx.graphics.getWidth() / 2 + scale * (Gdx.graphics.getWidth() / 2);
    }

    private float getUpperY(float offset, float yScale) {
        return (Gdx.graphics.getHeight() * offset) + Gdx.graphics.getHeight() * yScale;
    }

    private float getLowerY(float offset) {
        return Gdx.graphics.getHeight() * offset;
    }
    
   
}