/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.engine.game;

import TestPackage.TowerPicker;
import dk.sdu.g3.engine.screens.GameScreen;
import dk.sdu.g3.engine.screens.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import dk.sdu.g3.common.rendering.FontMap;
import dk.sdu.g3.common.rendering.Fonts;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.GraphicsMap;
import dk.sdu.g3.common.rendering.IRenderable;
import dk.sdu.g3.common.rendering.IRenderableText;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.rendering.Layer;
import dk.sdu.g3.common.services.IEnemy;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlayer;
import dk.sdu.g3.engine.util.render.Dictionary.Dict;
import dk.sdu.g3.engine.util.render.Dictionary.Dictionary;
import dk.sdu.g3.renderer.Renderer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class STDGame extends Game {

    public static OrthographicCamera cam;
    public SpriteBatch batch;
    public Renderer renderer;

    //modules
    private IEnemy enemy;
    private IPlayer player;
    private IMap map;
    private List<IStage> stagelist;

    private final GraphicsMap graphMap = new GraphicsMap();
    private final FontMap fontLib = new FontMap();
    private HashMap<Graphic, Texture> textureMap;
    private HashMap<String, BitmapFont> fontMap = new HashMap<>();

    //dictonary
    Dict inputMapping = new Dictionary();

    //RenderLists
//    private List<IRenderableEntity> forGrounds = new ArrayList<>();
//    private List<IRenderableEntity> middleGrounds = new ArrayList<>();
//    private List<IRenderableEntity> backGrounds = new ArrayList<>();
    @Override
    public void create() {

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.translate(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        cam.update();
        createTextures();
        getStages();
        
        //For tets purpse shuld be don through service loader!!!!!
        TowerPicker towerPicker = new TowerPicker();
        stagelist = new ArrayList<>();
        stagelist.add(towerPicker);

        batch = new SpriteBatch();

        this.renderer = new Renderer(this);

        this.setScreen(new MainMenuScreen(this));
    }

    public void gameLoop() {
//        for(IPlaceableEntity: map.updatePositions()){
//            enemy.
//        }

    }

//    public void addForGroundElement(IRenderableEntity e, Coordinate location) {
//        forGrounds.add(e);
//        inputMapping.insert(location, map.getTileSize(), e.getFootprint(), e);
//    }
//
//    public void addMiddleGroundElement(IRenderableEntity e, Coordinate location) {
//        middleGrounds.add(e);
//        inputMapping.insert(location, map.getTileSize(), e.getFootprint(), e);
//    }
//
//    public void addBackGroundElement(IRenderableEntity e, Coordinate location) {
//        backGrounds.add(e);
//        inputMapping.insert(location, map.getTileSize(), e.getFootprint(), e);
//    }
//
//    public void removeForGroundElement(IRenderableEntity e) {
//        forGrounds.remove(e);
//        inputMapping.remove(e);
//    }
//
//    public void removeMiddleGroundElement(IRenderableEntity e) {
//        middleGrounds.remove(e);
//        inputMapping.remove(e);
//    }
//
//    public void removeBackGroundElement(IRenderableEntity e) {
//        backGrounds.remove(e);
//        inputMapping.remove(e);
//    }
//
//    private void update() {     // this is the GameLoop
//        
//        //take indput
//        //handle input
//        draw();
//    }
//    /**
//     * draws all the elements
//     */
//    private void draw() {
//        int tileSize = map.getTileSize();
//        //render forground
//        for (IRenderableEntity f : forGrounds) {
//            Texture sprite = new Texture(f.getSpriteUrl());
//            inputMapping temp = new inputMapping(f.getCurrentPosition(), tileSize, f.getFootprint(), null);
//            renderer.draw(sprite, temp.getOrigoX(), temp.getOrigoY(),
//                    temp.getBorderX(), temp.getBorderY(),
//                    temp.getOrigoX(), temp.getOrigoY(),
//                    sprite.getWidth(), sprite.getHeight(),
//                    true, true);
//        }
//        //render middleground
//        for (IRenderableEntity m : middleGrounds) {
//            Texture sprite = new Texture(m.getSpriteUrl());
//            inputMapping temp = new inputMapping(m.getCurrentPosition(), tileSize, m.getFootprint(), null);
//            renderer.draw(sprite, temp.getOrigoX(), temp.getOrigoY(),
//                    temp.getBorderX(), temp.getBorderY(),
//                    temp.getOrigoX(), temp.getOrigoY(),
//                    sprite.getWidth(), sprite.getHeight(),
//                    true, true);
//        }
//        //render background
//        for (IRenderableEntity b : backGrounds) {
//            Texture sprite = new Texture(b.getSpriteUrl());
//            inputMapping temp = new inputMapping(b.getCurrentPosition(), tileSize, b.getFootprint(), null);
//            renderer.draw(sprite, temp.getOrigoX(), temp.getOrigoY(),
//                    temp.getBorderX(), temp.getBorderY(),
//                    temp.getOrigoX(), temp.getOrigoY(),
//                    sprite.getWidth(), sprite.getHeight(),
//                    true, true);
//        }
//        renderer.renderAll();
//    }
    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void render() {
        super.render(); // tror den her skal være der.

//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //if you want the game time
        //Gdx.graphics.getDeltaTime()
        //update();
        //draw();
    }

    public void StartGame() {
        this.setScreen(new GameScreen(this));

    }

    public ArrayList<ArrayList<IRenderable>> getRenderList() throws Exception {
        ArrayList<IRenderable> renderlist = new ArrayList<>();
        for (IStage stage : stagelist){
            for(IRenderable rend : stage.getRenderables()){
                renderlist.add(rend);
            }
        }

        ArrayList<ArrayList<IRenderable>> renderListList = new ArrayList<>();
        ArrayList<IRenderable> backgroundList = new ArrayList<>();
        ArrayList<IRenderable> midgroundList = new ArrayList<>();
        ArrayList<IRenderable> forgroundlist = new ArrayList<>();
        ArrayList<IRenderable> notdefinedList = new ArrayList<>();

        for (IRenderable rend : renderlist) {
            if (null == rend.getLayer()) {
                notdefinedList.add(rend);
            } else switch (rend.getLayer()) {
                case BACKGROUND:
                    backgroundList.add(rend);
                    break;
                case MIDGROUND:
                    midgroundList.add(rend);
                    break;
                case FORGOUND:
                    forgroundlist.add(rend);
                    break;
                default:
                    notdefinedList.add(rend);
                    break;
            }
        }
        if (!notdefinedList.isEmpty()) {
            throw new Exception("there were things not defined in layer" + notdefinedList.toString());
        }
        renderListList.add(backgroundList);
        renderListList.add(midgroundList);
        renderListList.add(forgroundlist);

        return renderListList;
    }

    public List<IStage> getStages() {
        return stagelist;
    }

    public Texture getTexture(Graphic graph) {
        return textureMap.get(graph);
    }

    public BitmapFont getFont(IRenderableText text) {
                //Hvis ikke klassens font er i mappet
        if(!fontMap.containsKey(text.getFont().toString() + text.toString())){
            System.out.println("made a new font: " + text.getFont().toString() + text.toString());
        
        //set font op
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontLib.getFontmap().get(text.getFont())));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = (int) ((text.getStage().getHigthScale()*Gdx.graphics.getHeight())*text.getHigthScale());
            //adfont til map
            fontMap.put((text.getFont().toString() + text.toString()), generator.generateFont(parameter));
            generator.dispose();
        }
        return fontMap.get(text.getFont().toString() + text.toString());
    }

    private void createTextures() {
        textureMap = new HashMap<>();
        for (Graphic e : graphMap.getGraphics().keySet()) {
            textureMap.put(e, new Texture(graphMap.getGraphics().get(e)));

        }
    }
}
