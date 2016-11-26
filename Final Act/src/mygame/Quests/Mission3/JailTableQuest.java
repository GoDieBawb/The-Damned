/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class JailTableQuest extends Quest {
    
    public JailTableQuest(AppStateManager stateManager, Node holder) {
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
                speech = "";
                break;
            case "FindKnife":
                speech = "You remove the knife from the loaf of bread.";
                ((Interactable) holder).model.getChild("Knife").removeFromParent();
                jailQuest.step = "HasKnife";
                break;
            case "HasKnife":
                speech = "Now isn't the time to eat... You have to get the key from the warden";
                break;
            case "HasKey":
                speech = "Now isn't the time to eat... You need toe escape.";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
