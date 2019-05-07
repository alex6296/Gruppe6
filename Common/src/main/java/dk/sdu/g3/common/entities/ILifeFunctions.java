package dk.sdu.g3.common.entities;

public interface ILifeFunctions {
    
    int getCurrentHp();
    int getMaxHp();
    
    void takeDamage(int damage);
    
}
