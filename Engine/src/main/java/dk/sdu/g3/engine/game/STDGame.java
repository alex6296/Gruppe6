/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.engine.game;

import dk.sdu.g3.engine.screens.GameScreen;
import dk.sdu.g3.engine.screens.MainMenuScreen;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dk.sdu.g3.renderer.Renderer;

/**
 *
 * @author Administrator
 */
public class STDGame extends Game {

    public static OrthographicCamera cam;
    public SpriteBatch batch;
    public Renderer renderer;

    @Override
    public void create() {
        
        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.translate(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        cam.update();
        
        batch = new SpriteBatch();
        
        this.renderer = new Renderer(this);
        
        this.setScreen(new MainMenuScreen(this));
    }

    private void update() {     // this is the GameLoop
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void render() {
        super.render(); // tror den her skal være der.
        
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //if you want the game time
        //Gdx.graphics.getDeltaTime()
        
        //update();
        //draw();
    }

    public void StartGame() {
        this.setScreen(new GameScreen(this));
    }
}