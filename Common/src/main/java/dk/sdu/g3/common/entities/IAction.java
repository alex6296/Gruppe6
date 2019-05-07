package dk.sdu.g3.common.entities;

import dk.sdu.g3.common.services.IPlaceableEntity;
import java.util.List;

public interface IAction {
    
    int getActionSpeed();
    int getImpact();
    int getRange();
    
    void action(List<IPlaceableEntity> targetList);
    
}
