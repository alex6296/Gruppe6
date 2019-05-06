/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.unitFactory;

import dk.sdu.g3.common.data.Coordinate;

import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.common.services.IUnitFactory;
import dk.sdu.g3.unit.Unit;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

/**
 *
 * @author sebastian
 */
@ServiceProviders(value = {
    @ServiceProvider(service = IUnitFactory.class),})
public class UnitFactory implements IUnitFactory {
    
    public IUnit getNewUnit(){
        return new Unit();
    }
    
    public IUnit getNewUnit(int hitPoints, int damage, int footprint, int cost
    , int attackRange, int attackSpeed, Coordinate position, List<Coordinate> path){
        return new Unit(hitPoints, damage, footprint, cost,attackRange,
                attackSpeed,position,path);
        
    }
    
}
