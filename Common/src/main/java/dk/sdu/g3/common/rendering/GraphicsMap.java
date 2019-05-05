package dk.sdu.g3.common.rendering;

import java.util.HashMap;

/**
 * class for asotiateing Grapics with a png-file
 * @author Rasmus
 */
public class GraphicsMap {
    private HashMap<Graphic,String> graphics;

    public GraphicsMap() {
        graphics = new HashMap<>();
        graphics.put(Graphic.WALL, "assets/wall.png");
        graphics.put(Graphic.WALL2, "assets/wall22.png");
    }

    public HashMap<Graphic, String> getGraphics() {
        return graphics;
    }
    

}
