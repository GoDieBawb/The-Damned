/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.Quest;

/**
*
* @author Bob
*/
public class BoatFarmerQuest extends Quest {
    
    public BoatFarmerQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "BoatQuest";
    }
    
    @Override
    public void act(){
        
        String speech;
        Quest  boatQuest = player.questList.getQuest("BoatQuest");
        
        if (boatQuest == null) {
            boatQuest = new BoatQuest(stateManager, player);
            player.questList.add(boatQuest);
            boatQuest.step = "Start";
        }
        
        if (player.inventory.contains("KilledSmith")) {
            speech = "The Farmer's poisoned flesh will not make for good food on the voyage";
            }
        
        else if (player.inventory.contains("Poison")) {
            speech = "The farmer sees you with the bottle of poison and summons the guard who kills you on site.";
            boatQuest.fail();
        }
        
        else if (player.inventory.contains("PoisonedBread")) {
            speech = "The Farmer desperately eats the bread as fast as he can... He collapses and dies almost immediately.";
            player.inventory.remove("PoisonedBread");
            player.inventory.add("KilledSmith");
            ((Npc) holder).phys.setEnabled(false);
            ((Npc) holder).animControl.clearChannels();
            ((Npc) holder).model.rotate(-89.5f,0,0);
        }
        
        else if (player.inventory.contains("Bread")) {
            speech = "I see you have bread... What would it take for you to share some of that!";
            }
        
        else {
            speech = "I'm so hungry... If that supply ship doesn't show up we all starve to death";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
