//package TestPackage;
//
//import dk.sdu.g3.common.rendering.Fonts;
//import dk.sdu.g3.common.rendering.IRenderableText;
//import dk.sdu.g3.common.rendering.IStage;
//import dk.sdu.g3.common.rendering.Layer;
//
//
//public class TextTest implements IRenderableText{
//    
//    private float x = (float) 0.1;
//    private float y = (float) 0.1;
//    private float with = (float) 0.8;
//    private float hight = (float) 0.1;
//    private IStage stage;
//    private String text = "Hans gik en tur";
//    private Fonts font = Fonts.AINCIENT;
//    private Layer layer = Layer.FORGOUND;
//    
//    public TextTest(IStage stage) {
//        this.stage = stage;
//    }
//
//    @Override
//    public String getText() {
//        return text;
//    }
//
//    @Override
//    public float[] getColor() {
//        return null;
//    }
//
//    @Override
//    public Fonts getFont() {
//        return font;
//    }
//
//    @Override
//    public IStage getStage() {
//        return stage;
//    }
//
//
//    @Override
//    public void setStage(IStage stage) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Layer getLayer() {
//        return layer;
//       
//    }
//
//    @Override
//    public float getPosScaleX() {
//        return x;
//    }
//
//    @Override
//    public float getPosScaleY() {
//       return y;
//    }
//
//    @Override
//    public float getWithScale() {
//        return with;
//    }
//
//    @Override
//    public float getHigthScale() {
//        return hight;
//    }
//
//    @Override
//    public void setPosScaleX(float scale) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setPosScaleY(float scale) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setWithScale(float scale) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setHigthScale(float scale) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
