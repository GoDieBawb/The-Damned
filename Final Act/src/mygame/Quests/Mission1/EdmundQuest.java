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
public class EdmundQuest extends Quest{
    
    public EdmundQuest(AppStateManager stateManager, Node holder) {
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
                speech = "Hello Traveler... These are dire times for our village. A nearby village has been overrun by goblins!";
                goblinQuest.step = "SeeGuard";
                break;
            case "SeeGuard":
                speech = "The Goblins have stormed their town gate and killed the citizens... Lago will know what to do!";
                break;
            default:
                speech = "I hope we can save our village...";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
