package dk.sdu.g3.engine.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import dk.sdu.g3.common.data.Coordinate;
import dk.sdu.g3.common.data.ITile;
import dk.sdu.g3.common.rendering.IStage;
import dk.sdu.g3.common.services.ITower;


public class GameInputHandler extends InputAdapter {
    STDGame game;

    public GameInputHandler(STDGame game) {
        this.game = game;
    }
    
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button){
        int gameY = (Gdx.graphics.getHeight() - screenY);
        if(!clickIsOnStage(screenX, gameY)){
            //check buttons
        }
        
        
        return true;
    }

    private boolean clickIsOnStage(int x, int y) {
        for(IStage stage : game.getStages()){
            if(stageIsClicked(stage,x,y)){
                Object ret = stageHandleClick(stage,x,y);
                if(ret instanceof ITile){
                    if(((ITile) ret).isOccupied()){
                        //inspect ret
                        //((ITile) ret).getEntities()
                                           }
                    else{
                        //player.createTower(((ITile) ret).getCoordinate());
                    }
                }
                else if (ret instanceof ITower){
                    //inspect Tower eller set reserved tower
                }
            return true;
            }
        }

        return false;
    }

    private boolean stageIsClicked(IStage stage, int x, int y) {
        if ((getStageX(stage)-(getStageWith(stage)/2)) <= x && x <= (getStageX(stage)+(getStageWith(stage)/2)) && (getStageY(stage)-(getStageHight(stage)/2)) <= y && y <= (getStageY(stage)+(getStageHight(stage)/2))){
            return true;
        }
            return false;
    }

    private Object stageHandleClick(IStage stage, int x, int y) {
        float flX = convertX(stage,x);
        float flY = convertY(stage, y);
        return stage.handleInput(flX, flY);
    }

    private int getStageWith(IStage stage) {
        return (int) (stage.getWithScale()*Gdx.graphics.getWidth());
    }

    private int getStageHight(IStage stage) {
        return (int) (stage.getHigthScale()*Gdx.graphics.getHeight());
    }

    private int getStageX(IStage stage) {
        return (int) (stage.getPosScaleX()*Gdx.graphics.getWidth());
    }

    private int getStageY(IStage stage) {
        return (int) (stage.getPosScaleY()*Gdx.graphics.getHeight());
    }

    private float convertX(IStage stage, int x) {
        
        return (x-(getStageX(stage)-(getStageWith(stage)/2)))/getStageWith(stage);
    }

    private float convertY(IStage stage, int y) {
        return (y-(getStageY(stage)-(getStageHight(stage)/2)))/getStageHight(stage);
    }

}