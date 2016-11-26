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
public class AndyQuest extends Quest {
    
    public AndyQuest(AppStateManager stateManager, Node holder) {
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
                speech = "These are troubling times traveler. Edmund is seeking help.";
                break;
            case "SeeAndy":
                speech = "So the plan is to fix the gate... It's up to you.";
                goblinQuest.step = "FindAxe";
                break;
            case "FindAxe":
                speech = "There is an axe in the tool shed. Get some wood, and fix that gate. You'll have to find a way to kill the goblins";
                break;
            default:
                speech = "Fix that gate... Then find a way to kill the goblins.";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
