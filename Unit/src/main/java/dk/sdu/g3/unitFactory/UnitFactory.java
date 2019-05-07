package dk.sdu.g3.unitFactory;

import dk.sdu.g3.common.data.Coordinate;

import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.common.services.IUnitFactory;
import dk.sdu.g3.unit.Unit;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
    @ServiceProvider(service = IUnitFactory.class),})
public class UnitFactory implements IUnitFactory {

    public IUnit getNewUnit() {
        return new Unit();
    }

    public IUnit getNewUnit(int hitPoints, int footprint, int cost, Coordinate position, List<Coordinate> path) {
        return new Unit(hitPoints, footprint, cost, position, path);
    }

}
