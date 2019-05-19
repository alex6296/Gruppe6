package dk.sdu.g3.engine.game;

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
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.GraphicsMap;
import dk.sdu.g3.common.rendering.IRenderable;
import dk.sdu.g3.common.rendering.IRenderableText;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.serviceLoader.ServiceLoader;
import dk.sdu.g3.common.services.IEnemy;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.IPlayer;
import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.renderer.Renderer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.openide.util.Lookup;

public class STDGame extends Game {

    public static OrthographicCamera cam;
    public SpriteBatch batch;
    public Renderer renderer;
    private final Lookup lookup = Lookup.getDefault();
    private GameScreen gameScreen;
    private boolean isWavePhase = false;
    private float time = 1;

    //modules
    private List<IEnemy> enemyList;
    private List<IPlayer> playerList;
    private List<IMap> mapList;
//    private List<IStage> stagelist;

    private final GraphicsMap graphMap = new GraphicsMap();
    private final FontMap fontLib = new FontMap();
    private HashMap<Graphic, Texture> textureMap;
    private HashMap<String, BitmapFont> fontMap = new HashMap<>();

    @Override
    public void create() {

        cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.translate(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        cam.update();
        createTextures();
        getStages();

        batch = new SpriteBatch();

        this.renderer = new Renderer(this);

        this.setScreen(new MainMenuScreen(this));

        //subscribing to services:
        enemyList = (List<IEnemy>) new ServiceLoader(IEnemy.class).getServiceProviderList();
        mapList = (List<IMap>) new ServiceLoader(IMap.class).getServiceProviderList();
        playerList = (List<IPlayer>) new ServiceLoader(IPlayer.class).getServiceProviderList();
    }

    public void gameLogic(float f) {

        if (isWavePhase) {
            time = time + f;
            if (time >= 0.1) {
                for (IEnemy enemy : enemyList) {
                if (!enemy.update()) {
                    System.out.println("All enemies defeated! You won the wave!");
                    endWavePhase();
                }
                }
                for (IMap map : mapList) {
                    List<IPlaceableEntity> toBeRemoved = map.updatePositions();
                    for (IPlayer player : playerList) {
                        if (!player.decreaseHp(toBeRemoved.size())) {
                            System.out.println("Player has died! You should lose!");
                            System.out.println("KOMPONENTER HAR OGSÅ FØLELSER!!! >:(");
                            System.out.println("Man kan jo håbe det er noget paranormalt...");
                            System.out.println("Hvis du læser dette håber vi du får en rigtig god dag! Pls giv os 12 <3<3");
                        }
                    }
                    for (IEnemy enemy : enemyList) {
                        for (IPlaceableEntity entity : toBeRemoved) {
                            enemy.remove(entity);
                        }
                    }
                }
                for (IMap map : mapList) {
                    List<IPlaceableEntity> targets = map.updateActions();
                    
                    if (!targets.isEmpty() && targets.get(0) instanceof IUnit) {
                        
                        for (IPlaceableEntity target : targets) {
                            for (IEnemy enemy : enemyList) {
                                enemy.remove(target);
                            }
                            for (IPlayer player : playerList) {
                                player.earnGold(target.getCost());
                            }
                        }
                    }
                }
                time = 0;
            }
        }
    }

    public void startWavePhase() {
        System.out.println("Starting a new wave.");
        isWavePhase = true;
        for (IEnemy enemy : enemyList) {
            enemy.createWave();
        }
    }

    private void endWavePhase() {
        isWavePhase = false;
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void render() {
        super.render();

    }

    public void StartGame() {
        gameScreen = new GameScreen(this);
        this.setScreen(gameScreen);

    }

    public ArrayList<ArrayList<IRenderable>> getRenderList() throws Exception {
        ArrayList<IRenderable> renderlist = new ArrayList<>();
        for (IStage stage : getStages()) {
            for (IRenderable rend : stage.getRenderables()) {
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
            } else {
                switch (rend.getLayer()) {
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
        }
        if (!notdefinedList.isEmpty()) {
            throw new Exception("there were things not defined in layer" + notdefinedList.toString());
        }
        renderListList.add(backgroundList);
        renderListList.add(midgroundList);
        renderListList.add(forgroundlist);

        return renderListList;
    }

    public Collection<? extends IStage> getStages() {
        return lookup.lookupAll(IStage.class);
    }

    public Texture getTexture(Graphic graph) {
        return textureMap.get(graph);
    }

    public BitmapFont getFont(IRenderableText text) {
        //Hvis ikke klassens font er i mappet
        if (!fontMap.containsKey(text.getFont().toString() + text.toString())) {
            System.out.println("made a new font: " + text.getFont().toString() + text.toString());

            //set font op
            FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontLib.getFontmap().get(text.getFont())));
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.size = (int) ((text.getStage().getHigthScale() * Gdx.graphics.getHeight()) * text.getHigthScale());
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

    Iterable<IPlayer> getPlayerList() {
        return playerList;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void mainMenu() {
        gameScreen = null;
        this.setScreen(new MainMenuScreen(this));
    }

    public boolean isWavePhase() {
        return isWavePhase;
    }

}
