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

    private TextTest text;
    private ArrayList<IRenderable> renderlist;

    //try to get an instance of a tower 
    public TowerPicker() {
        renderlist = new ArrayList<>();

        text = new TextTest(this);
        renderlist.add(text);

        ITowerFactory test = new towerFactory();
        insertTower(test);
        ITowerFactory test1 = new towerFactory();
        insertTower(test1);
        ITowerFactory test2 = new towerFactory();
        insertTower(test2);
        ITowerFactory test3 = new towerFactory();
        insertTower(test3);
        ITowerFactory test4 = new towerFactory();
        insertTower(test4);
    }

    @Override
    public List<IRenderable> getRenderables() {
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
        
        for (IRenderable t: renderlist) {
            try{
            TowerOnTowerPicker temp = (TowerOnTowerPicker ) t;
            if (temp.getItf()==null) {
                renderlist.remove(t);
            }
            }catch(ClassCastException e){}
        }
        
        for (ITowerFactory tf : tfs) {
            if(tf == null){
                tfs.remove(tf);
            }
        }
        if (tfs.size() >= 3) {
            System.out.println(" !ERROR!  to many factories");
            return;
        }

        tfs.add(towerf);
        float dif = this.startpoint * tfs.size() * interval;

        //add to render
        TowerOnTowerPicker towerBox = new TowerOnTowerPicker(this, dif);
        towerBox.setItf(towerf);
        renderlist.add(towerBox);
        
        

        //add to inputhandler
        dict.insert(this.getPosX - this.getWidth / 2, this.getPosY - this.getHeight / 2, this.getPosX + this.getWidth / 2 * -1, this.getPosY + this.getHeight / 2 , towerf);
    }

    @Override
    public Object handleInput(float XScale, float YScale) {
       Object resolved = null;
        try{
            
            System.out.println("--TTT-- SUCKY SUCKY DUCKY DUCKTY");
        resolved = dict.search(XScale, YScale);
        System.out.println("---RESOLVED--- = " + resolved);
       

            
        }catch(UnsupportedOperationException e){
            e.printStackTrace();
        }
                
        return tf.getNewTower(10, 10, 1, 1, 10, 10, null);
                
        
    }
}
