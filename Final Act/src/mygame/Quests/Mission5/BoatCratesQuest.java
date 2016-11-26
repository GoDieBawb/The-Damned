/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class BoatCratesQuest extends Quest {
    
    public BoatCratesQuest(AppStateManager stateManager, Node holder) {
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
            speech = "You've already removed the bread from the hiding place";
        }
        
        else if (player.inventory.contains("FoodKnowledge")) {
            
            if (player.inventory.contains("Bread") || player.inventory.contains("PoisonedBread")) {
                speech = "You've already taken the bread from the hiding place.";
            }
            
            else if (player.inventory.contains("Poison")) {
                speech = "Moving the crates aside you find the bread... You pour the bottle of poison all over it.";
                player.inventory.add("PoisonedBread");
                player.inventory.remove("Bread");
            }
            
            else {
                speech = "You move the crates aside and find the hidden bread.";
                player.inventory.add("Bread");
            }
            
        }
        
        else {
            speech = "All the ration crates have been emptied, without new supplies, we will die.";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
