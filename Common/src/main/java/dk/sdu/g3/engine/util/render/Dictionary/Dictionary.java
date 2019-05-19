package dk.sdu.g3.engine.util.render.Dictionary;

import dk.sdu.g3.common.data.inputMapping;
import dk.sdu.g3.common.data.Coordinate;
import java.util.ArrayList;
import java.util.List;

public class Dictionary implements Dict {

    List<inputMapping> mappings = new ArrayList<inputMapping>();

    /**
     *
     * @param center Coordinate of the center point of an square element
     * @param tileSize the "radius" of an tile
     * @param footPrint how many tiles this elemet takes up
     * @param refrence
     */
    @Override
    public void insert(Coordinate center, int tileSize, int footPrint, Object refrence) {
        inputMapping element = new inputMapping(center, tileSize, footPrint, refrence);
        mappings.add(element);

    }

    /**
     * removes an object
     *
     * @param refrence to the object that should be removed
     */
    @Override
    public void remove(Object refrence) {
        for (inputMapping m : mappings) {
            if (m.getRefrence().equals(refrence)) {
                mappings.remove(m);
                break;
            }
        }
    }

    /**
     * finds what object the coordinate is within
     *
     * @param target the coordinates of the clicked point
     * @return the reference to the object hit
     */
    @Override
    public Object search(Coordinate target) {
        for (inputMapping m : mappings) {
            if (!(m.getOrigoX() <= target.getX() && target.getX() <= m.getBorderX())) {

                continue;
            }

            if (m.getOrigoY() <= target.getY() && target.getY() <= m.getBorderY()) {

                return m.getReference();
            }
        }
        return null;
    }

    @Override
    public Object search(float targetX, float targetY) {

        for (inputMapping m : mappings) {
            if ((m.getReference() == null)) {
                mappings.remove(m);
                continue;
            }

            if (!(m.getOrigoX() <= targetX && targetX <= m.getBorderX())) {
                continue;
            }

            if (m.getOrigoY() <= targetY && targetY <= m.getBorderY()) {

                return m.getReference();
            }
        }

        for (inputMapping m : mappings) {

        }

        return null;
    }

    @Override
    public void insert(float Xorigo, float YOrigo, float XBorder, float YBorder, Object reference) {
        inputMapping element = new inputMapping(Xorigo, YOrigo, XBorder, YBorder, reference);
        mappings.add(element);
    }

}
