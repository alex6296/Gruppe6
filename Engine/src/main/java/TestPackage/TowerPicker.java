/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import dk.sdu.g3.common.rendering.IRenderable;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.services.ITower;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robertfrancisti
 */
public class TowerPicker implements IStage {
    
    private final float getWidth = (float) 0.25;
    private final float getHeight = (float) 0.6;
    private final float getPosX = (float) 0.8;
    private final float getPosY = (float) 0.5;
    
    private TowerOnTowerPicker tower;
    private TowerOnTowerPicker tower2;
    
    //try to get an instance of a tower 
    
    
    public TowerPicker(){

      tower = new TowerOnTowerPicker(this, (float) 0.8);
      tower2 = new TowerOnTowerPicker(this, (float) 0.4);
       
        
    }
    
    public List<IRenderable> getTower(){
        
        ArrayList<IRenderable> renderList = new ArrayList<>();
        
        renderList.add(tower);
        renderList.add(tower2);
        return renderList;
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
        return "Common/src/main/resources/assets/wall22.png";    
    }
    
    
}
