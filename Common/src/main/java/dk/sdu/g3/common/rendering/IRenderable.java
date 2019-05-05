/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.rendering;

/**
 * general interface for all rendering, Shuld not be used for implementation, chose ither IRenderingText or IRenderingSprite based on your spesific need
 * @author Rasmus
 */
public interface IRenderable{
    
    /**
     * 
     * @return 
     */
    public IStage getStage();
    public void setStage(IStage stage); // skal den bruges??
    public Layer getLayer();
    public float getPosScaleX();
    public float getPosScaleY();
    public float getWithScale();
    public float getHigthScale();
    public void setPosScaleX(float scale);
    public void setPosScaleY(float scale);
    public void setWithScale(float scale);
    public void setHigthScale(float scale);
    
    

}
