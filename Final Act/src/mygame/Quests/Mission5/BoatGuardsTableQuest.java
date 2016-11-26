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
public class BoatGuardsTableQuest extends Quest {
    
    public BoatGuardsTableQuest(AppStateManager stateManager, Node holder) {
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
        
        if (boatQuest.step.equals("Start")) {
            speech = "It has been desperate times since the fog set in, and the supply ship hasn't arrived. I've hidden the last of the bread behind the storage crates, and buried the last of the water under the ruined house. Also rats have been a problem, I've created a bottle of poison to stop them.";
        }
        
        else {
            speech = "It has been desperate times since the fog set in, and the supply ship hasn't arrived. I've hidden the last of the bread behind the storage crates, and buried the last of the water under the ruined house. Also rats have been a problem, I've created a bottle of poison to stop them.";
        }
        
        if (!player.inventory.contains("FoodKnowledge")) {
            player.inventory.add("FoodKnowledge");
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
