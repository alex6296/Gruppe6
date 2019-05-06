/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.player;

import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.services.IMap;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.IPlayer;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.ITowerFactory;
import java.util.ArrayList;
import java.util.Collection;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
  @ServiceProvider(service = IPlayer.class)    
})

/**
 *
 * @author robertfrancisti
 */
public class Player implements IPlayer {
  
    private TowerPicker tp;
    int hp = 10;
    int gold = 10;
    ArrayList<IPlaceableEntity> EntityList = new ArrayList();
    ArrayList<ITowerFactory> TowerFactoryList = new ArrayList();
    serviceLoaderPlayer unitLoader = new serviceLoaderPlayer();
    ITower tower1;
    
    public Player(){
       tp = new TowerPicker();
    }
    public Player(int hp, int gold) {
        this.hp = hp;
        this.gold = gold;
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
    public ArrayList<IPlaceableEntity> getEntities() {
        return EntityList;
    }

    @Override
    public boolean create(ITower tower2) {
        for (ITowerFactory tower : unitLoader.getSP(ITowerFactory.class)){
            
                EntityList.add(tower.getNewTower(tower2.getLife(), tower2.getDamage(), tower2.getFootprint(), tower2.getCost(), tower2.getAttackSpeed(), tower2.getAttackRange(), tower2.getCurrentPosition()));
            return true;    
        }
        return false;
    }

    @Override
    public void remove(ILifeFunctions livingEntity) {
        EntityList.remove(livingEntity);
    }
    
    public void placeTowerOnMap(ITower Tower){
//    unitLoader.getSP(IMap.class).add(Tower);

}

    @Override
    public boolean decreaseHp(int damage) {
        hp = hp - damage;
        if (hp <= 0){
            return false;
        }
        return true;
    }

    
        public class serviceLoaderPlayer {

        private final Lookup lookup = Lookup.getDefault();
        private Lookup.Result<ITowerFactory> result;

        public serviceLoaderPlayer() {
            //vars
            
            result = lookup.lookupResult(ITowerFactory.class); //Finds SP'
            result.addLookupListener(lookupListener);
            result.allItems();

            System.out.println("---IGamePluginService---");
            //inizial load
            for (ITowerFactory plugin : result.allInstances()) {
                System.out.println(plugin);
                TowerFactoryList.add(plugin);
            }
        }

        private final LookupListener lookupListener = new LookupListener() {
            @Override
            public void resultChanged(LookupEvent le) {

                Collection<? extends ITowerFactory> updated = result.allInstances();

                for (ITowerFactory us : updated) {
                    // Newly installed modules
                    if (!TowerFactoryList.contains(us)) {
                        TowerFactoryList.add(us);
                    }
                }

                // Stop and remove module
                for (ITowerFactory gs : TowerFactoryList) {
                    if (!updated.contains(gs)) {
                        
                        TowerFactoryList.remove(gs);
                    }
                }
            }
        };

        private <T> Collection<? extends T> getSP(Class<T> SPI) {
            return lookup.lookupAll(SPI);
        }
        
        public String toString(){
            return getCurrentGold() + " \t" + getCurrentHp();
        }

    }
}


