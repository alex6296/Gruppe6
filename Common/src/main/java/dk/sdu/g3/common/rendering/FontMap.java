package dk.sdu.g3.common.rendering;

import java.util.HashMap;


public class FontMap {
    private HashMap<Fonts, String> fontmap;

    public FontMap() {
        fontmap = new HashMap<>();
        fontmap.put(Fonts.AINCIENT, "assets/AincientMedium.ttf");
        fontmap.put(Fonts.ENCHANTED, "assets/EnchantedLand.otf");
        fontmap.put(Fonts.GREGORIAN, "assets/GregorianFLF.ttf");
    }
    
 public HashMap<Fonts, String> getFontmap() {
        return fontmap;
    }

}
