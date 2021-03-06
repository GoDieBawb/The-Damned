/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class OldGateQuest extends Quest {
    
    public OldGateQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "GoblinQuest";
    }
    
    @Override
    public void act() {
        
        Quest goblinQuest = player.questList.getQuest("GoblinQuest");
        String speech;
        
        if (goblinQuest == null) {
            goblinQuest      = new GoblinQuest(stateManager, player);
            goblinQuest.step = "Start";
            player.questList.add(goblinQuest);
        }
        
        switch (goblinQuest.step) {
            case "Start":
                speech = "You don't want to enter the Goblin Forest...";
                break;
            case "GetWood":
                speech = "You climb through the rusted and broken gate... Entering the Goblin Forest";
                break;
            default:
                speech = "You don't want to enter the Goblin Forest";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
