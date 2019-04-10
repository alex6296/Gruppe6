/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.g3.common.entities;

/**
 *
 * @author pvies
 */
public interface ILifeFunctions {
    
    int getCurrentHp();
    int getMaxHp();
    
    void takeDamage(int damage);
    
}
