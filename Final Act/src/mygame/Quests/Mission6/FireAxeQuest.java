/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission6;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class FireAxeQuest extends Quest {
    
    public FireAxeQuest(AppStateManager stateManager, Node holder) {
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
        
        if (player.inventory.contains("BurnedTable")) {
            speech = "You pick up the axe...";
            player.inventory.add("Axe");
            holder.removeFromParent();
        }
        
        else {
            speech = "As you attempt to grab the axe, he grows suspicious stops you from completing your evil plan.";
            fireQuest.fail();
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
