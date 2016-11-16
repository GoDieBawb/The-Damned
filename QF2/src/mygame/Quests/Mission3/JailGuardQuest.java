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
public class JailGuardQuest extends Quest {

  public JailGuardQuest(AppStateManager stateManager, Node holder) {
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
    
    if (jailQuest.step.equals("KillGuard")) {
      speech = "You quietly approach the sleeping guard and smash him over the head with the bottle... Then strangle him";
      ((Npc) holder).die();
      jailQuest.step = "FindKnife";
      }
    
    else {
      speech = "The Guard's body lies at your feet...";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
