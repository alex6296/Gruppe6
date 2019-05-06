/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.data;

/**
 *
 * @author pvies
 */
public class Coordinate {
    
    private int x, y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(float XScale, float YScale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
}
