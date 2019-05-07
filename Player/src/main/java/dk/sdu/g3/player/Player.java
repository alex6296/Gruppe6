package dk.sdu.g3.player;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.rendering.Graphic;
import dk.sdu.g3.common.rendering.IRenderable;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.serviceLoader.ServiceLoader;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.IPlayer;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.ITowerFactory;
import dk.sdu.g3.engine.util.render.Dictionary.Dictionary;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
    @ServiceProvider(service = IPlayer.class)
    ,
    @ServiceProvider(service = IStage.class),})
public class Player implements IPlayer, IStage {

    // functionality attributes
    private int hp = 100;
    private int gold = 10;
    private List<IPlaceableEntity> entityList = new ArrayList();
    private List<ITowerFactory> factoryList;
    private List<IMap> mapList;
    private ITower reservedTower;
    private Dictionary dict = new Dictionary();

    // rendering attributes
    private final float width = 0.25f;
    private final float height = 0.6f;
    private final float posX = 0.83f;
    private final float posY = 0.5f;
    private Graphic backgroundfile = Graphic.TOWERPICKERBACKGROUND;
    private TextTest text = null;

    // TowerPicker stuff
    private TowerOnTowerPicker t1;
    private Object t1id = new Object();
    private ITowerFactory tf1;

    private TowerOnTowerPicker t2;
    private Object t2id = new Object();
    private ITowerFactory tf2;

    private TowerOnTowerPicker t3;
    private Object t3id = new Object();
    private ITowerFactory tf3;

    
    public Player() {
        mapList = (List<IMap>) new ServiceLoader(IMap.class).getServiceProviderList();
        factoryList = (List<ITowerFactory>) new ServiceLoader(ITowerFactory.class).getServiceProviderList();

        for (ITowerFactory towerFactory : factoryList) {
            insertTower(towerFactory);
        }
    }

    @Override
    public int getCurrentHp() {
        return hp;
    }

    @Override
    public int getCurrentGold() {
        return gold;
    }

    @Override
    public List<IPlaceableEntity> getEntities() {
        return entityList;
    }
    
    @Override
    public void remove(IPlaceableEntity entity) {
        for (IMap map : mapList) {
            map.removeEntity(entity);
            entityList.remove(entity);
        }
    }

    @Override
    public boolean decreaseHp(int damage) {
        hp -= damage;
        if (hp <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public void reserveTower(ITower tower) {
        reservedTower = tower;
    }

    @Override
    public void placeReservedTower(Coordinate coor) {
        if (reservedTower != null) {
            reservedTower.setPosition(coor);
            for (IMap map : mapList) {
                map.addEntity(reservedTower);
                entityList.add(reservedTower);
                reservedTower = null;
            }
        }
    }

    @Override
    public List<IRenderable> getRenderables() {
        ArrayList<IRenderable> renderlist = new ArrayList<>();

        if (tf1 != null) {
            renderlist.add(t1);
        }
        if (tf2 != null) {
            renderlist.add(t2);
        }
        if (tf3 != null) {
            renderlist.add(t3);
        }
        if (text == null) {
            text = new TextTest(this, this);
        }
        renderlist.add(text);
        return renderlist;
    }

    @Override
    public float getPosScaleX() {
        return this.posX;
    }

    @Override
    public float getPosScaleY() {
        return this.posY;
    }

    @Override
    public float getWithScale() {
        return this.width;
    }

    @Override
    public float getHigthScale() {
        return this.height;
    }

    @Override
    public Graphic getBackgroundFile() {
        return this.backgroundfile;
    }

    public void insertTower(ITowerFactory towerf) {

        if (t1 == null) {

            t1 = new TowerOnTowerPicker(this, (float) 0.8, t1id);
            dict.insert(t1.getPosScaleX() - t1.getHigthScale() / 2, t1.getPosScaleY() - t1.getWithScale() / 2, t1.getPosScaleX() + t1.getHigthScale() / 2, t1.getPosScaleY() + t1.getWithScale() / 2, t1id);
            tf1 = towerf;

            return;
        }
        if (t2 == null) {

            t2 = new TowerOnTowerPicker(this, (float) 0.6, t2id);
            dict.insert(t2.getPosScaleX() - t2.getHigthScale() / 2, t2.getPosScaleY() - t2.getWithScale() / 2, t2.getPosScaleX() + t2.getHigthScale() / 2, t2.getPosScaleY() + t2.getWithScale() / 2, t2id);
            tf2 = towerf;

            return;
        }
        if (t3 == null) {

            t3 = new TowerOnTowerPicker(this, (float) 0.4, t3id);
            dict.insert(t3.getPosScaleX() - t3.getHigthScale() / 2, t3.getPosScaleY() - t3.getWithScale() / 2, t3.getPosScaleX() + t3.getHigthScale() / 2, t3.getPosScaleY() + t3.getWithScale() / 2, t3id);
            tf3 = towerf;

            System.out.println("can only hold 3 towerfactories");
            return;
        }
    }

    @Override
    public Object handleInput(float XScale, float YScale) {
        Object resolved = null;

        try {
            resolved = dict.search(XScale, YScale);
            if (resolved.equals(t1id)) {
                if (tf1 != null) {
                    System.out.println("tower was clikced : id = " + tf1);
                    return tf1.getNewTower();

                }
            }
            if (resolved.equals(t2id)) {
                if (tf2 != null) {
                    System.out.println("tower was clikced : id = " + tf2);
                    return tf2.getNewTower();
                }
            }
            if (resolved.equals(t3id)) {
                if (tf3 != null) {
                    System.out.println("tower was clikced : id = " + tf3);
                    return tf3.getNewTower();
                }
            }

        } catch (NullPointerException e) {
            System.out.println("nope null pointer");
        }

        return resolved;
    }
}
