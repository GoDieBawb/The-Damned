/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class JailDrainQuest extends Quest {  
    
  public JailDrainQuest(AppStateManager stateManager, Node holder) {
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
      speech = "The drain is loose... With some effort you manage to pry it open enough to squeeze through.";
      player.phys.warp(new Vector3f(-7,0,-20));
      jailQuest.step = "FindBottle";
      }
    
    else if (jailQuest.step.equals("FindBottle")) {
      speech = "You have to escape... You don't want to go back in there.";
      }
    
    else if (jailQuest.step.equals("HasBottle")) {
      speech = "Holding onto the bottle you crawl back through into the jail cell.";
      player.phys.warp(new Vector3f(-9,0,-20));
      jailQuest.step = "GiveBottle";
      }
    
    else if (jailQuest.step.equals("GiveBottle")) {
      speech = "As you attempt to crawl back through the drain the Guard catches you and kills you for trying to escape.";
      super.fail();
      }
    
    else if (jailQuest.step.equals("GaveBottle")) {
      speech = "You crawl back outside through the drain.";
      jailQuest.step = "KillGuard";
      player.phys.warp(new Vector3f(-7,0,-20));
      }
    
    else if (jailQuest.step.equals("KillGuard")) {
      speech = "You have to escape... Time is running out. You don't want to go back into your cell.";
      }
    
    else {
      speech = "You don't want to go back inside. Time is running out";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }  
    
  }
