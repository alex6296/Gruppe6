/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.services;

import dk.sdu.g3.common.data.Coordinate;
import java.util.List;

/**
 *
 * @author pvies
 */
public interface IPathfinding {
    
    List<Coordinate> generatePath(IMap map, Coordinate start, Coordinate goal) throws Exception; 
}
