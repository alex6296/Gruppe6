/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.rendering;

import dk.sdu.g3.common.data.Coordinate;

/**
 *
 * @author pvies
 */
public interface IRenderableEntity extends IRenderable {

    String getSpriteUrl();

    Coordinate getCurrentPosition();

    int getFootprint();

}
