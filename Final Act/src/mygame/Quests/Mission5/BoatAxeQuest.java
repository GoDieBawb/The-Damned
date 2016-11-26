/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class BoatAxeQuest extends Quest{
    
    public BoatAxeQuest(AppStateManager stateManager, Node holder) {
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
            
            if (player.inventory.contains("Axe")) {
                speech = "You place the axe back on the table";
                player.inventory.remove("Axe");
                ((Interactable) holder).model.getChild("Axe").move(0,5,0);
            }
            
            else {
                speech = "You take the axe from the table.";
                player.inventory.add("Axe");
                ((Interactable) holder).model.getChild("Axe").move(0,-5,0);
            }
            
        }
        
        else {
            speech = "As you go to take the axe from the table the Farmer stops you... and kills you";
            boatQuest.fail();
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
