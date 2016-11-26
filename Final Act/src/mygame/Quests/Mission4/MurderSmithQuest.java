/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.Quest;

/**
*
* @author Bob
*/
public class MurderSmithQuest extends Quest {
    
    private boolean isDrunk;
    private boolean isDead;
    
    public MurderSmithQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "MurderQuest";
        isDrunk = false;
        isDead  = false;
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
        
        if (isDrunk) {
            
            if (player.inventory.contains("Axe")) {
                speech = "Too drunk to see you coming you swing the axe and kill the unsuspecting blacksmith.";
                murderQuest.step = "KilledSmith";
                player.inventory.add("Blood");
                ((Npc) holder).phys.setEnabled(false);
                ((Npc) holder).animControl.clearChannels();
                ((Npc) holder).model.rotate(-89.5f,0,0);
                isDrunk = false;
                isDead  = true;
            }
            
            else {
                speech = "The BlackSmith is currently quite drunk...";
            }
            
        }
        
        else if (isDead) {
            
            speech = "The BlackSmith's dead body lies on the ground";
            
        }
        
        else {
            
            if (player.inventory.contains("Bottle")) {
                speech = "I see you have a bottle of Voda there! You sure do know what I like.";
                player.inventory.remove("Bottle");
                isDrunk = true;
            }
            
            else if (player.inventory.contains("Blood")) {
                speech = "The Smith sees you covered in blood and calls the inspector.";
                murderQuest.fail();
            }
            
            else {
                speech = "I can't believe it... A murder, I could sure use a drink.";
            }
            
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
