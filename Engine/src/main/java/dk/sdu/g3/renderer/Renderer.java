/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import dk.sdu.g3.engine.game.STDGame;

/**
 *
 * @author pvies
 */
public class Renderer {
    
    private final STDGame game;
    public Renderer(final STDGame game){
        this.game = game;
    }
    
    /**
     * this is the method that will be called everytime the Screen want to render stuff
     */
    public void renderAll() {
    Texture test = new Texture("assets/wall22.png");
        draw(test, Gdx.graphics.getWidth()/4,Gdx.graphics.getHeight()/4, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0, 0, test.getWidth(), test.getHeight(), true, true);
    }
    
//    public void draw() {
//        for (Component c : Component) {
//            for (IRenderables r : renderables) {
//                int positionX = r.getPosition().getX()-tileSize;
//                int positionY = r.getPosition().getY()-tileSize;
//                sprite = scale(r.getFootprint(), r.getSpriteURL(), tileSize);
//                render(new Coordinate(positionX, positionY), sprite);
//            }
//        }
//    }
//    
//    public Sprite scale(int footprint, String spriteURL, int tileSize) {
//        sprite.height = targetSize;
//        sprite.length = targetSize;
//    }
//    
//    public void render(Coordinate position, Sprite sprite) {
//        renderAt(position);
//        renderSprite(Sprite);
//    }
    
     /**
     * Method for passing draw to the renderor, its not don yest and må change local but use it to know what we need to use to draw something on the base level:
     * @param texture the gdx texture of the file, we will proberbly change this to becomes the a passing of the file
     * @param x the x value of the lover left corner of the element based on the total window
     * @param y  value of the lover left corner of the element based on the total window
     * @param width the desired with in pixels of the objec( maby we shuld make it relative to the screen size)
     * @param height the desired higth in pixels of the objec( maby we shuld make it relative to the screen size)
     * @param srcX the texel x value of the lover left corner of the sprite in the png ( defult suld be 0) 
     * @param srcY the texel y value of the lover left corner of the sprite in the png ( defult suld be 0)
     * @param srcWidththe texel with of the desired image in the texture (png)
     * @param srcHeight texel higth of the desired image in the texture (png)
     * @param flipX if true it flips the sprite horizontaly
     * @param flipY if true it flips the sprite vertivaly
     */
    public void draw(Texture texture,float startX, float startY, float desiredWidth, float desiredHeight, int sreX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY){
        game.batch.draw(texture, startX, startY, desiredWidth, desiredHeight, srcY, srcY, srcWidth, srcHeight, flipX, flipY);
    }

    


}