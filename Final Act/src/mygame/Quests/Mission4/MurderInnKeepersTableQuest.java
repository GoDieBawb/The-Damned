/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class MurderInnKeepersTableQuest extends Quest {
    
    private boolean isLocked;
    
    public MurderInnKeepersTableQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "MurderQuest";
        isLocked = true;
    }
    
    @Override
    public void act(){
        
        Quest murderQuest = player.questList.getQuest("MurderQuest");
        String speech;
        
        if (murderQuest == null) {
            murderQuest = new MurderQuest(stateManager, player);
            player.questList.add(murderQuest);
            murderQuest.step = "Start";
        }
        
        if (isLocked) {
            
            if (player.inventory.contains("Knife")) {
                speech   = "Using the knife you pry open the jewelry box";
                isLocked = false;
            }
            
            else {
                speech = "The InnKeepers Jewelry Box sits on the table... It's locked.";
            }
            
        }
        
        else {
            
            if (player.inventory.contains("Ring")) {
                speech = "You place the victim's ring into the InnKeeper's Jewelry Box and lock it.";
                player.inventory.remove("Ring");
                murderQuest.step = "PlacedRing";
            }
            
            else if (murderQuest.step.equals("PlacedRing")) {
                speech = "The ring has already been planted in the InnKeepers Jewelry Box";
            }
            
            else {
                speech = "This Jewelry Box has been unlocked.";
            }
            
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
