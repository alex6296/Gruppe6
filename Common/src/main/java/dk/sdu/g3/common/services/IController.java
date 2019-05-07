package dk.sdu.g3.common.services;

import java.util.List;

public interface IController {

    List<IPlaceableEntity> getEntities();
//    IPlaceableEntity create();
    void remove(IPlaceableEntity entity);

}
