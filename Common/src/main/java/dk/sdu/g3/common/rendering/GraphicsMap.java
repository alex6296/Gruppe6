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
        graphics.put(Graphic.TowerPickerBackground, "assets/Par1.png");
        graphics.put(Graphic.Towers, "assets/SmallStatue.png");
        graphics.put(Graphic.Coins, "assets/Coin.png");
        graphics.put(Graphic.MAIN_MENU, "assets/MainMenu.png");
        graphics.put(Graphic.SEND_WAVE, "assets/sendWave.png");
    }

    public HashMap<Graphic, String> getGraphics() {
        return graphics;
    }
    

}
