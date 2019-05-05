/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.data;

import dk.sdu.g3.common.data.Coordinate;

/**
 *
 * @author Administrator
 */
 public class inputMapping {

        private int origoX;
        private int origoY;
        private int BorderX;
        private int BorderY;
        private int footPrint;

        private int size;
        private Object reference;

        public inputMapping(Coordinate center, int size, int footPrint, Object reference) {
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