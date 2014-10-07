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
public class JailBottleQuest extends Quest {
    
  public JailBottleQuest(AppStateManager stateManager, Node holder) {
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
      speech = "You shouldn't be out here.";
      }
    
    else if (jailQuest.step.equals("FindBottle")) {
      speech = "Reaching through the fence you grab a bottle of vodka...";
      jailQuest.step = "HasBottle";
      holder.removeFromParent();
      }
    
    else {
      speech = "";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
