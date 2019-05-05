/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import dk.sdu.g3.common.rendering.Graphic;
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
    private TextTest text;
    private ArrayList<IRenderable> renderlist;

    //try to get an instance of a tower 
    public TowerPicker() {
        renderlist = new ArrayList<>();
        tower = new TowerOnTowerPicker(this, (float) 0.8);
        renderlist.add(tower);
        tower2 = new TowerOnTowerPicker(this, (float) 0.4);
        renderlist.add(tower2);
        text = new TextTest(this);
        renderlist.add(text);
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
        return Graphic.WALL2;
    }

}
