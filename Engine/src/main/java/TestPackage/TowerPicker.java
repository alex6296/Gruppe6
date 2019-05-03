/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import dk.sdu.g3.common.rendering.IStage;

/**
 *
 * @author robertfrancisti
 */
public class TowerPicker implements IStage {
    
    private final float getWidth = (float) 0.25;
    private final float getHeight = (float) 0.6;
    private final float getPosX = (float) 0.8;
    private final float getPosY = (float) 0.5;
     
    //try to get an instance of a tower 
    
    
    public TowerPicker(){
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

    @Override
    
    public String getBackgroundFile() {  
        System.out.println("tries to handle ");
        return "assets/wall22.png";
        
    }
    
}
