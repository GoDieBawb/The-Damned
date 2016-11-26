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
public class BoatGuardQuest extends Quest {
    
    private boolean hasMeat;
    
    public BoatGuardQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "BoatQuest";
        hasMeat = true;
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
        
        if (player.inventory.contains("KilledGuard")) {
            
            if (hasMeat) {
                speech = "You strip all the edible meat from the bones of the slain guard.";
                hasMeat = false;
                player.inventory.add("RawMeat");
            }
            
            else {
                speech = "The guards corpse stripped of all edible meat lies here on the dock.";
            }
            
        }
        
        else if (player.inventory.contains("Axe")) {
            speech = "As you approach the guard with the axe you swing it, killing him...";
            player.inventory.add("KilledGuard");
            ((Npc) holder).phys.setEnabled(false);
            ((Npc) holder).animControl.clearChannels();
            ((Npc) holder).model.rotate(-89.5f,0,0);
        }
        
        else if (player.inventory.contains("Bread")) {
            speech = "Seeing you with the stolen the guard kills you immedately";
            boatQuest.fail();
        }
        
        else if (player.inventory.contains("Water")) {
            speech = "Seeing you with the stolen water the guard kills you immedately";
            boatQuest.fail();
        }
        
        else if (player.inventory.contains("Shovel")) {
            speech = "Seeing you with the stolen shovel the guard kills you immedately";
            boatQuest.fail();
        }
        
        else if (player.inventory.contains("Poison")) {
            speech = "Seeing you with the stolen poison the guard kills you immedately";
            boatQuest.fail();
        }
        
        else {
            speech = "I will be rationing the food until the supplies arrive. Until then I'm guarding this boat.";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
