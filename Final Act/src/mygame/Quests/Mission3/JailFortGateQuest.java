/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class JailFortGateQuest extends Quest {
    
    public JailFortGateQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "JailQuest";
    }
    
    @Override
    public void act(){
        
        Quest jailQuest = player.questList.getQuest("JailQuest");
        String speech;
        
        if (jailQuest == null) {
            jailQuest      = new JailQuest(stateManager, player);
            jailQuest.step = "Start";
            player.questList.add(jailQuest);
        }
        
        if (jailQuest.step.equals("HasKey")) {
            speech = "You unlock the door and escape into the darkness...";
            super.finish();
        }
        
        else {
            speech = "The door is locked tightly... Only the warden has the key.";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
