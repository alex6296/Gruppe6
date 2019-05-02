package dk.sdu.g3.common.rendering;

public interface IRenderableText extends IRenderable {
    
    public String getText();
    public float[] getColor(); // if non set it gets to be the default color. array skal indeholde r, ,g, b, a som er farve tinten mellem 0 og 1. 

}
