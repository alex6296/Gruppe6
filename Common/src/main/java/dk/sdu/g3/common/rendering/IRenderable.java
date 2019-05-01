/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.rendering;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IRenderable {

    public List<IRenderable> getForGroundElements();

    public List<IRenderable> getMiddleGroundsElements();

    public List<IRenderable> getBackGroundsElements();

}
