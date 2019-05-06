package dk.sdu.g3.common.rendering;

import java.util.List;


public interface IStage {
    //Definerer midten af "towerpicker"
    public float getPosScaleX();
    //Definerer midten af "towerpicker"
    public float getPosScaleY();
    public float getWithScale();
    public float getHigthScale();
//    public void setPosScaleX(float scale);
//    public void setPosScaleY(float scale);
//    public void setWithScale(float scale);
//    public void setHigthScale(float scale);
    public Graphic getBackgroundFile();
    public List<IRenderable> getRenderables();
    Object handleInput(float XScale, float YScale);

}
