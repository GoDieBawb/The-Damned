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
public class FireTableQuest extends Quest{
    
  public FireTableQuest(AppStateManager stateManager, Node holder) {
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
    
    speech = "You grab the table... The house is now completely barren";
    player.inventory.add("Table");
    holder.removeFromParent();
      
    gui.showAlert(holder.getName(), speech);
    
    }  
    
  }
