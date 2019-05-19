package dk.sdu.g3.engine.util.render.Dictionary;

import dk.sdu.g3.common.data.Coordinate;

public interface Dict {

    public void insert(Coordinate center, int size, int footPrint, Object refrence);

    public void insert(float Xorigo, float YOrigo, float XBorder, float YBorder,
             Object reference);

    public void remove(Object refrence);

    public Object search(Coordinate center);

    public Object search(float targetX, float targetY);

}
