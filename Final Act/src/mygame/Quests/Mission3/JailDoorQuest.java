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
public class JailDoorQuest extends Quest {
    
    public JailDoorQuest(AppStateManager stateManager, Node holder) {
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
        
        switch (jailQuest.step) {
            case "Start":
                speech = "This door is locked tightly";
                break;
            case "GiveBottle":
                speech = "You hold the bottle outside the cell door... The gaurd approaches takes the bottle and drinks it immediately.";
                jailQuest.step = "GaveBottle";
                break;
            case "GaveBottle":
                speech = "You hear the guard drunkenly snoring in the hall outside your cell.";
                break;
            default:
                speech = "The door is locked tightly";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
