/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.pathfinding;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.IPathfinding;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author Pottemuld
 */

@ServiceProviders(value = {@ServiceProvider(service = IPathfinding.class), })
public class Pathfinding implements IPathfinding {

    @Override
    public Coordinate getNextCoordinate(Coordinate currentCoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
