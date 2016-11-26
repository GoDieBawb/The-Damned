/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.Quest;

/**
*
* @author Bob
*/
public class JailWardenQuest extends Quest {
    
    public JailWardenQuest(AppStateManager stateManager, Node holder) {
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
                speech = "Keep it down in there prisoner";
                break;
            case "HasKnife":
                speech = "You use the knife and immediately stab the Warden to death... You retrieve a key from his body.";
                ((Npc)holder).die();
                jailQuest.step = "HasKey";
                break;
            case "HasKey":
                speech = "The murdered Warden's dead eyes stare blankly at the ceiling";
                break;
            default:
                speech = "The Warden spots you and immediately kills you for attempting to escape";
                jailQuest.fail();
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
