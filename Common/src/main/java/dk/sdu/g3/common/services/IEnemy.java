package dk.sdu.g3.common.services;

public interface IEnemy extends IController {
    
     int getCurrentWave();
     void createWave();
     boolean update();
    
}
