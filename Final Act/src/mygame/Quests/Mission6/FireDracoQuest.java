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
public class FireDracoQuest extends Quest {
    
    public FireDracoQuest(AppStateManager stateManager, Node holder) {
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
        
        if (player.inventory.contains("Bucket")) {
            speech = "Seeing you with the murdered Alexander's bucket, he stops you before you can complete your plan.";
            fireQuest.fail();
        }
        
        else if (player.inventory.contains("Axe")) {
            speech = "I can't believe Velor is sending you out at night... We must be desperate.";
        }
        
        else if (player.inventory.contains("BurnedTale")) {
            speech = "That table was all I had left to burn... What are we going to do?";
        }
        
        else if (player.inventory.contains("Table")) {
            speech = "Quickly burn that table before the fire goes out.";
        }
        
        else {
            speech = "All I have left in my house to burn is that table... Quickly thrown it in the fire.";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
