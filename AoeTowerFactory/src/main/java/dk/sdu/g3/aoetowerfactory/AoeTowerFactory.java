package dk.sdu.g3.aoetowerfactory;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.services.ITower;
import dk.sdu.g3.common.services.ITowerFactory;
import dk.sdu.g3.aoetower.AoeTower;
import dk.sdu.g3.common.rendering.Graphic;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders(value = {
    @ServiceProvider(service = ITowerFactory.class),})
public class AoeTowerFactory implements ITowerFactory {

    private Graphic file = new AoeTower().getFile();


    @Override
    public ITower getNewTower() {
        return (ITower) new AoeTower();
    }

    @Override
    public ITower getNewTower(int damage, int footprint, int cost, int attackSpeed, int attackRange, Coordinate position) {
        return (ITower) new AoeTower(damage, footprint, cost, attackSpeed, attackRange, position);
    }

    @Override
    public Graphic getFile() {
        return this.file;
    }

}
