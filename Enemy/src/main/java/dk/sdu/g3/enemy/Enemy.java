/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.enemy;

import dk.sdu.g3.common.services.IEnemy;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.ITowerFactory;
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
    ArrayList<ITower> waveList = new ArrayList();
    ArrayList<ITowerFactory> towerList = new ArrayList();
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
                waveList.add(tower.getNewTower());
                
                
            }
        }
        while(smallUnits == counter){
            for (ITowerFactory tower : unitLoader.getSP(ITowerFactory.class)){
                waveList.add(tower.getNewTower());
        
            }
        }
    }
    public int generateWaveComposition(){
        ArrayList<Object> wave = new ArrayList();
        int bigUnits = random.nextInt(51);
        
    return bigUnits;
}
    
    
    public class serviceLoaderEnemy {

        private final Lookup lookup = Lookup.getDefault();
        private Lookup.Result<ITowerFactory> result;

        public serviceLoaderEnemy() {
            //vars
            
            result = lookup.lookupResult(ITowerFactory.class); //Finds SP'
            result.addLookupListener(lookupListener);
            result.allItems();

            System.out.println("---IGamePluginService---");
            //inizial load
            for (ITowerFactory plugin : result.allInstances()) {
                System.out.println(plugin);
                towerList.add(plugin);
            }
        }

        private final LookupListener lookupListener = new LookupListener() {
            @Override
            public void resultChanged(LookupEvent le) {

                Collection<? extends ITowerFactory> updated = result.allInstances();

                for (ITowerFactory us : updated) {
                    // Newly installed modules
                    if (!towerList.contains(us)) {
                        towerList.add(us);
                    }
                }

                // Stop and remove module
                for (ITowerFactory gs : towerList) {
                    if (!updated.contains(gs)) {
                        
                        towerList.remove(gs);
                    }
                }
            }
        };

        private <T> Collection<? extends T> getSP(Class<T> SPI) {
            return lookup.lookupAll(SPI);
        }

    }
    }
