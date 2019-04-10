/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dk.sdu.g3.tower;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.ITower;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;



/**
 *
 */
@ServiceProviders(value = {@ServiceProvider(service = ITower.class),})
public class Tower implements ITower {
    
    int life;
    int damage;
    int footprint;
    int cost;
    int attackSpeed;
    int attackRange;

    @Override
    public int[][] getFootprint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordinate getCurrentPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
