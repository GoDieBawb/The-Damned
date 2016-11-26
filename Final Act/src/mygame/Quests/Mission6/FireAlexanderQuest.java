/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission6;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.Quest;

/**
*
* @author Bob
*/
public class FireAlexanderQuest extends Quest {
    
    public FireAlexanderQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "FireQuest";
    }
    
    @Override
    public void act(){
        
        String speech;
        Quest fireQuest = player.questList.getQuest("FireQuest");
        
        if (fireQuest == null) {
            fireQuest = new FireQuest(stateManager, holder);
            player.questList.add(fireQuest);
            fireQuest.step = "Start";
        }
        
        if (player.inventory.contains("KilledAlexander")) {
            speech = "The dead body of Alexander lies here on the floor.";
        }
        
        else if (player.inventory.contains("Axe")) {
            speech = "You swing the axe, striking Alexander. Killing him.";
            player.inventory.add("KilledAlexander");
            ((Npc) holder).die();
        }
        
        else {
            speech = "We have to keep the fire going... Just until morning.";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
