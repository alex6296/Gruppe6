package dk.sdu.g3.greenunitfactory;

import dk.sdu.g3.common.data.Coordinate;

import dk.sdu.g3.common.services.IUnit;
import dk.sdu.g3.common.services.IUnitFactory;
import dk.sdu.g3.greenunit.GreenUnit;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
    @ServiceProvider(service = IUnitFactory.class),})
public class GreenUnitFactory implements IUnitFactory {

    @Override
    public IUnit getNewUnit() {
        return new GreenUnit();
    }

    @Override
    public IUnit getNewUnit(int hitPoints, int footprint, int cost, Coordinate position, List<Coordinate> path, int speed) {
        return new GreenUnit(hitPoints, footprint, cost, position, path, speed);
    }

}
