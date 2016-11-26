/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class MineQuest extends Quest {
    
    public MineQuest(AppStateManager stateManager, Node holder) {
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
        
        if (mineQuest.step.equals("Start")) {
            
        }
        
    }
    
}
