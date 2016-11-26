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
public class JailQuest extends Quest {
    
    public JailQuest(AppStateManager stateManager, Node holder) {
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
        
        if (jailQuest.step.equals("Start")) {
            speech = "";
        }
        
        else {
            speech = "";
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
