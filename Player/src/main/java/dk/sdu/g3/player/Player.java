/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.player;

import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.services.IPlaceableEntity;
import dk.sdu.g3.common.services.IPlayer;
import java.util.List;
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
    PlayerGoldPlayerHealth pl;
    
    
    private  int  currentHp;
    private int currentGold;
    
    
    public Player(){
       tp = new TowerPicker();
    }

    @Override
    public int getCurrentHp() {
     
        return currentHp;
    }

    @Override
    public int getCurrentGold() {
     
        return currentGold;
        
    }

    @Override
    public List<IPlaceableEntity> getEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(IPlaceableEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(ILifeFunctions livingEntity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean decreaseHp(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
