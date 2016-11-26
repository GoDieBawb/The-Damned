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
public class MurderBottleQuest extends Quest {
    
    public MurderBottleQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "MurderQuest";
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
        
        speech = "You take the bottle of vodka from the counter...";
        holder.removeFromParent();
        player.inventory.add("Bottle");
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
