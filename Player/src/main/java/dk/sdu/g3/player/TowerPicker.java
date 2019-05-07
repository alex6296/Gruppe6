/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.player;

import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IRenderable;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.services.ITowerFactory;
import dk.sdu.g3.engine.util.render.Dictionary.Dictionary;
import dk.sdu.g3.towerfactory.towerFactory;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
    @ServiceProvider(service = IStage.class)
})

/**
 *
 * @author robertfrancisti
 */
public class TowerPicker implements IStage {

    private float startpoint = (float) 1.5;
    private float interval = (float) 0.2;
    private List<ITowerFactory> tfs = new ArrayList<>();

    private Dictionary dict = new Dictionary();
    private final float getWidth = (float) 0.25;
    private final float getHeight = (float) 0.6;
    private final float getPosX = (float) 0.83;
    private final float getPosY = (float) 0.5;
    private towerFactory tf = new towerFactory();
    private Player player;
    

    private TextTest text;


    TowerOnTowerPicker t1;
    Object t1id = new Object();
    ITowerFactory tf1;
   
    TowerOnTowerPicker t2;
    Object t2id = new Object();
    ITowerFactory tf2;
    
    TowerOnTowerPicker t3;
    Object t3id = new Object();
    ITowerFactory tf3;
    
    //try to get an instance of a tower 
    public TowerPicker() {
    text = new TextTest(this);
    text.injectPlayer(player);
   
    }

    @Override
    public List<IRenderable> getRenderables() {
            ArrayList<IRenderable> renderlist = new ArrayList<>();
            
            if (tf1!=null) {
            renderlist.add(t1);
        }
                if (tf2!=null) {
            renderlist.add(t2);
        }
                    if (tf3!=null) {
            renderlist.add(t3);
        }
             renderlist.add(text);
        return renderlist;
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
    public Graphic getBackgroundFile() {
        return Graphic.TOWERPICKERBACKGROUND;
    }

    public void insertTower(ITowerFactory towerf) {
        
        if(t1 == null){
               
            t1 = new TowerOnTowerPicker(this, (float) 0.8,t1id);
             dict.insert(t1.getPosScaleX()-t1.getHigthScale() / 2 ,t1.getPosScaleY()-t1.getWithScale() / 2,t1.getPosScaleX()+t1.getHigthScale() / 2 ,t1.getPosScaleY()+t1.getWithScale() / 2, t1id);
            tf1=towerf;
            
        return;
        }if(t2 == null){
                 
            t2 = new TowerOnTowerPicker(this, (float) 0.6, t2id);
            dict.insert(t2.getPosScaleX()-t2.getHigthScale() / 2 ,t2.getPosScaleY()-t2.getWithScale() / 2,t2.getPosScaleX()+t2.getHigthScale() / 2 ,t2.getPosScaleY()+t2.getWithScale() / 2, t2id);            
           
             tf2=towerf;
            
        return;
        }if(t3 == null){
            
            t3 = new TowerOnTowerPicker(this, (float) 0.4, t3id);
            tf3=towerf;
            dict.insert(t3.getPosScaleX()-t3.getHigthScale() / 2 ,t3.getPosScaleY()-t3.getWithScale() / 2,t3.getPosScaleX()+t3.getHigthScale() / 2 ,t3.getPosScaleY()+t3.getWithScale() / 2, t3id);    
           
            System.out.println("can only hold 3 towerfactories");
        return;
        }    
    }

    
    @Override
    public Object handleInput(float XScale, float YScale) {
       Object resolved = null;
       
        try{
        resolved = dict.search(XScale, YScale);           
                    if (resolved.equals(t1id)) {
            if (tf1 != null) {
                                System.out.println("tower was clikced : id = "+ tf1);
                return tf1.getNewTower();

            }
        }
         if (resolved.equals(t2id)) {
                 if (tf2 != null) {
                                               System.out.println("tower was clikced : id = "+ tf2);
                return tf2.getNewTower();
            }
        }
          if (resolved.equals(t3id)) {
                 if (tf3 != null) {
                                               System.out.println("tower was clikced : id = "+ tf3);
                return tf3.getNewTower();
            }
        } 
            
        }catch(NullPointerException e){
            System.out.println("nope null pointer");
        }
  

        
        
        return resolved;
    }
}
                

                
        
    

