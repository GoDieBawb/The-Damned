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
public class BoatSaltBarrelsQuest extends Quest {
    
    public BoatSaltBarrelsQuest(AppStateManager stateManager, Node holder) {
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
        
        if (player.inventory.contains("CuredMeat")) {
            speech = "The meat has already been cured for the long voyage ahead of you.";
            }
        
        else if (player.inventory.contains("Meat")) {
            speech = "Salting the meat ensures it doesn't rot on the long voyage ahead of you.";
            player.inventory.remove("Meat");
            player.inventory.add("CuredMeat");
        }
        
        else if (player.inventory.contains("RawMeat")) {
            speech = "The meat needs to be cooked before it is preserved.";
        }
        
        else {
            speech = "Full of salt... The one plentiful thing on this island.";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
