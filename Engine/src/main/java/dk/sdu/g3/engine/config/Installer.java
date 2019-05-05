    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.engine.config;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import dk.sdu.g3.engine.game.STDGame;
import org.openide.modules.ModuleInstall;

public class Installer extends ModuleInstall {

     private static Game game;
    
    @Override
    public void restored() {
           game = new STDGame();

        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "STD";
        cfg.width = 1080;
        cfg.height = 720;
        cfg.useGL30 = false;
        cfg.resizable = true;

        new LwjglApplication(game, cfg);
    }

}
