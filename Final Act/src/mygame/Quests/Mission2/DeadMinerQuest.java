/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class DeadMinerQuest extends Quest {
    
    public DeadMinerQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "MineQuest";
    }
    
    @Override
    public void act() {
        
        Quest mineQuest = player.questList.getQuest("MineQuest");
        String speech;
        
        if (mineQuest == null) {
            mineQuest      = new MineQuest(stateManager, player);
            mineQuest.step = "Start";
            player.questList.add(mineQuest);
        }
        
        switch (mineQuest.step) {
            case "Start":
                super.fail();
                speech = "Before you can inspect the body you are torn apart...";
                break;
            case "FindBody":
                speech         = "The miner's body has been torn... to pieces. You take the shovel";
                mineQuest.step = "GetGold";
                ((Interactable) holder).model.getChild("MineShovel").removeFromParent();
                break;
            default:
                speech = "This miner met a horrific death...";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
    }
    
}
