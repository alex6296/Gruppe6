/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.engine.util.render.Dictionary;

import dk.sdu.g3.common.data.Coordinate;
import java.util.ArrayList;
import java.util.List;

public class Dictionary implements Dict {

    List<Mapping> mappings = new ArrayList<Mapping>();

    /**
     *
     * @param center Coordinate of the center point of an square element
     * @param tileSize the "radius" of an tile
     * @param footPrint how many tiles this elemet takes up
     * @param refrence
     */
    @Override
    public void insert(Coordinate center, int tileSize, int footPrint, Object refrence) {
        Mapping element = new Mapping(center, tileSize, footPrint, refrence);
        mappings.add(element);

    }

    /**
     * removes an object
     *
     * @param refrence to the object that should be removed
     */
    @Override
    public void remove(Object refrence) {
        for (Mapping m : mappings) {
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
        Object refrence = null;
        for (Mapping m : mappings) {
            if (!(m.getOrigoX() <= target.getX() && target.getX() <= m.getBorderX())) {

                continue;
            }

            if (m.getOrigoY() <= target.getY() && target.getY() <= m.getBorderY()) {

                return m.getRefrence();
            }
        }
        return refrence;
    }

    private class Mapping {

        private int origoX;
        private int origoY;
        private int BorderX;
        private int BorderY;
        private int footPrint;

        private int size;
        private Object reference;

        public Mapping(Coordinate center, int size, int footPrint, Object reference) {
            this.size = size;
            this.reference = reference;
            this.footPrint = footPrint;
            origoX = center.getX() - size * footPrint;
            origoY = center.getY() - size * footPrint;
            BorderX = origoX + size * 2 * footPrint;
            BorderY = origoY + size * 2 * footPrint;
        }

        public int getFootPrint() {
            return footPrint;
        }

        public Object getReference() {
            return reference;
        }

        public int getOrigoX() {
            return origoX;
        }

        public int getOrigoY() {
            return origoY;
        }

        public int getBorderX() {
            return BorderX;
        }

        public int getBorderY() {
            return BorderY;
        }

        public int getSize() {
            return size;
        }

        public Object getRefrence() {
            return reference;
        }
    }

}
