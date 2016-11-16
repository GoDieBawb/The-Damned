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
    
    if (doorName.equals("JailYardExit")) {
    
      if (jailQuest.step.equals("FindBottle")) {
        speech = "As soon as you open the door the guard spots you and kills you.";
        jailQuest.fail();
        }
      
      else if (jailQuest.step.equals("HasBottle")) {
        speech = "As soon as you open the door the guard spots you and kills you.";
        jailQuest.fail();
        }
      
      else if (jailQuest.step.equals("KillGuard")) {
        speech = "You open the door and walk inside";
        player.phys.warp(new Vector3f(-9,0,-30));
        }
    
      else {
        speech = "You open the door and walk inside.";
        }
      
      }
    
    else if (doorName.equals("JailYardEnter")) {
        
      if (jailQuest.step.equals("Start")) {
        speech = "As soon as you open the door the guard spots you and kills you.";
        jailQuest.fail();
        }
      
      else if (jailQuest.step.equals("FindBottle")) {
        speech = "As soon as you open the door the guard spots you and kills you.";
        jailQuest.fail();
        }
      
      else if (jailQuest.step.equals("HasBottle")) {
        speech = "As soon as you open the door the guard spots you and kills you.";
        jailQuest.fail();
        }      
      
      else if (jailQuest.step.equals("GaveBottle")) {
        speech = "You need to escape... That door goes back to the yard.";
        }
      
      else {
        speech = "You need to escape... That leads back into the yard";
        }
      
      }
    
    else {
      speech = "I am broken";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
