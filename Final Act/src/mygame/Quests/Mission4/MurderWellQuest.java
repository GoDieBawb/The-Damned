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
public class MurderWellQuest extends Quest {
  
  public MurderWellQuest(AppStateManager stateManager, Node holder) {
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
    
    if (player.inventory.contains("Blood")) {
      speech = "You use the well to wash the blood off your hands...";
      player.inventory.remove("Blood");
      }
    
    else {
      speech = "You have already cleaned the blood from your hands...";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
