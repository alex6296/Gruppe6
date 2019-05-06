/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.player;

import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IRenderableSprite;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;

/**
 *
 * @author robertfrancisti
 */
public class PlayerGoldPlayerHealth implements IRenderableSprite {

    
   
    
    private  float getWidth = (float) 0.1;
    private  float getHeight = (float) 0.1;
    private  float getPosX = (float) 0.5;
    private  float getPosY;  
    private IStage picker;
    private Layer layer;
    
   
    
    
    public PlayerGoldPlayerHealth(IStage stage, float YPosition){
       this.picker = stage;
       this.getPosY = YPosition;
       
    }

  
    
    @Override
    public Graphic getFile() {
       return Graphic.Coins;
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
        return layer.FORGOUND;
    }


    @Override
    public void setPosScaleX(final float scale) {
        this.getPosX = scale;
    }

    @Override
    public void setPosScaleY(float scale) {
        this.getPosY = scale;
    }

    @Override
    public void setWithScale(float scale) {
        this.getWidth = scale;
    }

    @Override
    public void setHigthScale(float scale) {
       this.getHeight = scale;
    }

    @Override
    public float getPosScaleX() {
        return this.getPosX;
    }

    @Override
    public float getPosScaleY() {
        return this.getPosY;
    }

    @Override
    public float getWithScale() {
       
        return this.getWidth;
    }

    @Override
    public float getHigthScale() {
       
        return this.getHeight;
    }

 
}
