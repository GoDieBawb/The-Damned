/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
*
* @author Bob
*/
public class JailYardDoorQuest extends Quest {
    
    public JailYardDoorQuest(AppStateManager stateManager, Node holder) {
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
        
        String doorName = ((Interactable) holder).model.getUserData("Name");
        
        switch (doorName) {
            
            case "JailYardExit":
                switch (jailQuest.step) {
                    
                    case "FindBottle":
                        speech = "As soon as you open the door the guard spots you and kills you.";
                        jailQuest.fail();
                        break;
                    case "HasBottle":
                        speech = "As soon as you open the door the guard spots you and kills you.";
                        jailQuest.fail();
                        break;
                    case "KillGuard":
                        speech = "You open the door and walk inside";
                        player.phys.warp(new Vector3f(-9,0,-30));
                        break;
                    default:
                        speech = "You open the door and walk inside.";
                        break;
                        
                }   
                break;
                
            case "JailYardEnter":
                switch (jailQuest.step) {
                    
                    case "Start":
                        speech = "As soon as you open the door the guard spots you and kills you.";
                        jailQuest.fail();
                        break;
                    case "FindBottle":
                        speech = "As soon as you open the door the guard spots you and kills you.";
                        jailQuest.fail();
                        break;
                    case "HasBottle":
                        speech = "As soon as you open the door the guard spots you and kills you.";
                        jailQuest.fail();
                        break;
                    case "GaveBottle":
                        speech = "You need to escape... That door goes back to the yard.";
                        break;
                    default:
                        speech = "You need to escape... That leads back into the yard";
                        break;
                        
                }   
                break;
                
            default:
                speech = "I am broken";
                break;
                
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
