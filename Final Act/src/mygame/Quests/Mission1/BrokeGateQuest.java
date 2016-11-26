/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class BrokeGateQuest extends Quest {
    
    public BrokeGateQuest(AppStateManager stateManager, Node holder) {
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
                speech = "This gate was broken down by Goblins....";
                break;
            case "FixGate":
                speech = "Using some of the wood you fix the gate.";
                ((Interactable) holder).model.rotate(89,0,0);
                ((Interactable) holder).model.move(0,2,0);
                goblinQuest.step = "BurnHouse";
                break;
            case "BurnHouse":
                speech = "The Goblins are gathered in the main house... Time to burn it down";
                break;
            default:
                speech = "This gate was broken down by Goblins....";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
