/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.enemy;

import dk.sdu.g3.common.services.IEnemy;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.ITowerFactory;
import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.common.services.IUnitFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author robertfrancisti
 */

@ServiceProviders(value = {
    @ServiceProvider(service = IEnemy.class)
})
public class Enemy implements IEnemy {
    int currentWave = 0;
    int gold = 0;
    Random random = new Random();
    int bigUnits;
    int smallUnits;
    int counter;
    ArrayList<IPlaceableEntity> EntityList = new ArrayList();
    ArrayList<IUnitFactory> UnitFactoryList = new ArrayList();
    serviceLoaderEnemy unitLoader = new serviceLoaderEnemy();

    public Enemy() {
        
    }


    @Override
    public int getCurrentWave() {
        return currentWave;
    }

    @Override
    public void createWave() {
        bigUnits = generateWaveComposition();
        smallUnits = 100 - bigUnits;
        while(bigUnits == counter){
            for (ITowerFactory tower : unitLoader.getSP(ITowerFactory.class)){
                EntityList.add(tower.getNewTower());
                
                
            }
        }
        while(smallUnits == counter){
            for (ITowerFactory tower : unitLoader.getSP(ITowerFactory.class)){
                EntityList.add(tower.getNewTower());
        
            }
        }
    }
    public int generateWaveComposition(){
        ArrayList<Object> wave = new ArrayList();
        int bigUnits = random.nextInt(51);
        
    return bigUnits;
}

    @Override
    public boolean create(IUnit unit) {
        for (ITowerFactory tower : unitLoader.getSP(ITowerFactory.class)){
            
                EntityList.add(tower.getNewTower());
            return true;    
        }
        return false;
    }
    
    
    public class serviceLoaderEnemy {

        private final Lookup lookup = Lookup.getDefault();
        private Lookup.Result<IUnitFactory> result;

        public serviceLoaderEnemy() {
            //vars
            
            result = lookup.lookupResult(IUnitFactory.class); //Finds SP'
            result.addLookupListener(lookupListener);
            result.allItems();

            System.out.println("---IGamePluginService---");
            //inizial load
            for (IUnitFactory plugin : result.allInstances()) {
                System.out.println(plugin);
                UnitFactoryList.add(plugin);
            }
        }

        private final LookupListener lookupListener = new LookupListener() {
            @Override
            public void resultChanged(LookupEvent le) {

                Collection<? extends IUnitFactory> updated = result.allInstances();

                for (IUnitFactory us : updated) {
                    // Newly installed modules
                    if (!UnitFactoryList.contains(us)) {
                        UnitFactoryList.add(us);
                    }
                }

                // Stop and remove module
                for (IUnitFactory gs : UnitFactoryList) {
                    if (!updated.contains(gs)) {
                        
                        UnitFactoryList.remove(gs);
                    }
                }
            }
        };

        private <T> Collection<? extends T> getSP(Class<T> SPI) {
            return lookup.lookupAll(SPI);
        }

    }
    }
