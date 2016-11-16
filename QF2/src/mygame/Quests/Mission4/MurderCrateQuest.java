/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class MurderCrateQuest extends Quest {
    
  public MurderCrateQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "MurderQuest";
    }
  
  @Override
  public void act(){
    
    Quest murderQuest = player.questList.getQuest("MurderQuest");
    String speech;
    
    if (murderQuest == null) {
      murderQuest = new MurderQuest(stateManager, player);
      player.questList.add(murderQuest);
      murderQuest.step = "Start";
      }
    
    if (murderQuest.step.equals("PlacedRing") || murderQuest.step.equals("HasFramed")) {
      speech = "You have already placed the ring into the InnKeepers Jewelry Box.";  
      }
    
    else if (player.inventory.contains("Ring")) {
      speech = "You put the ring into the crate";
      player.inventory.remove("Ring");
      }
    
    else {
      speech = "You take the ring from the crate";
      player.inventory.add("Ring");
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
