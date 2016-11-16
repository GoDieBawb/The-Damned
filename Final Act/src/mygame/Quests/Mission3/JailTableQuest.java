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
    
    if (jailQuest.step.equals("Start")) {
      speech = "";  
      }
    
    else if (jailQuest.step.equals("FindKnife")) {
      speech = "You remove the knife from the loaf of bread.";
      ((Interactable) holder).model.getChild("Knife").removeFromParent();
      jailQuest.step = "HasKnife";
      }
    
    else if (jailQuest.step.equals("HasKnife")) {
      speech = "Now isn't the time to eat... You have to get the key from the warden";
      }
    
    else if (jailQuest.step.equals("HasKey")) {
      speech = "Now isn't the time to eat... You need toe escape.";
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);
  
    }

  }
