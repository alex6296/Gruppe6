/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.enemy;

import dk.sdu.g3.common.services.IEnemy;
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

    @Override
    public int getCurrentWave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createWave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
