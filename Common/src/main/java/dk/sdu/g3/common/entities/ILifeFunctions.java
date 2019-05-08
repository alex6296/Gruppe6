package dk.sdu.g3.common.entities;

public interface ILifeFunctions {
    
    int getCurrentHp();
    int getMaxHp();
    
    boolean takeDamage(int damage);     // returns true if this damage kills the entity
    
}
