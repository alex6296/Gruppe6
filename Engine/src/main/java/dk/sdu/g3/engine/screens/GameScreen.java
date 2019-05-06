package dk.sdu.g3.engine.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.g3.engine.game.STDGame;
import dk.sdu.g3.engine.game.GameInputHandler;
import org.openide.util.Exceptions;

public class GameScreen implements Screen {

    private final STDGame game;

    //Textures:
    private Texture background;

    private float time = 0;

    public GameScreen(final STDGame game) {
        this.game = game;
        final GameScreen gamescreen = this;
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
        time = time + f;
        if (time >= 0.1) {
            //System.out.println("float time: " + time);
            
            //gameloop
            game.gameLoop();

            //this is what renders stuff
            game.batch.begin();
            //drawing background
            game.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0, Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 3, false, false);

            try {
                game.renderer.renderAll();
            } catch (Exception ex) {
                Exceptions.printStackTrace(ex);
            }

            game.batch.end();
            time = 0;
            //dispose fonts?
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
        
    }
    
    
}
