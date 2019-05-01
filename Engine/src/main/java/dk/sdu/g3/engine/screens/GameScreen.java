package dk.sdu.g3.engine.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.g3.engine.game.STDGame;


public class GameScreen implements Screen {
    
    private final STDGame game;

    //Textures:
    private Texture background;

    public GameScreen(final STDGame game) {
        this.game = game;
        final GameScreen gamescreen = this;
        background = new Texture("assets/wall.png");
        background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }

    @Override
    public void show() {
       
    }

    @Override
    public void render(float f) {
        game.batch.begin();
        //drawing background
        game.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0, Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 3, false, false);
       
        game.renderer.renderAll();
        
        game.batch.end();
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
        
    }
    
    
}