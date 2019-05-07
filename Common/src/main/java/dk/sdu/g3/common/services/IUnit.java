package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.entities.ILifeFunctions;
import dk.sdu.g3.common.entities.IMovable;
import dk.sdu.g3.common.rendering.IRenderableSprite;
import java.util.List;

public interface IUnit extends IPlaceableEntity, IMovable, ILifeFunctions, IRenderableSprite {

    public void setPath(List<Coordinate> cord);

}
