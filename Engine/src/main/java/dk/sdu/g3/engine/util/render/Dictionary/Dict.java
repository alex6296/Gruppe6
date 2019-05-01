/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.engine.util.render.Dictionary;

import dk.sdu.g3.common.data.Coordinate;

/**
 *
 * @author Administrator
 */
public interface Dict {

    public void insert(Coordinate center, int size, int footPrint, Object refrence);

    public void remove(Object refrence);

    public Object search(Coordinate center);
}
