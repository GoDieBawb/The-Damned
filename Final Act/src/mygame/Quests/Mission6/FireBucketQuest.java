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
public class FireBucketQuest extends Quest {
    
    public FireBucketQuest(AppStateManager stateManager, Node holder) {
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
        
        if (player.inventory.contains("KilledAlexander")) {
            speech = "You pick up the bucket.";
            holder.removeFromParent();
            player.inventory.add("Bucket");
        }
        
        else {
            speech = "Alexander sees you trying to grab his bucket... He grows suspicious and stops your evil plan.";
            fireQuest.fail();
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
