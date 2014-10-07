/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission6;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class FireWellQuest extends Quest {
  
  public FireWellQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "FireQuest";
    }
  
  @Override
  public void act(){
    
    String speech;
    Quest fireQuest = player.questList.getQuest("FireQuest");
    
    if (fireQuest == null) {
      fireQuest = new FireQuest(stateManager, holder);
      player.questList.add(fireQuest);
      fireQuest.step = "Start";
      }
    
    if (player.inventory.contains("Water")) {
      speech = "Your bucket is already full of water.";
      }
    
    else if (player.inventory.contains("Bucket")) {
      speech = "You use the bucket to get water from the well.";
      player.inventory.add("Water");
      }
    
    else {
      speech = "The well... The town's only source of water.";
      }
      
    gui.showAlert(holder.getName(), speech);
    
    }    
    
  }
