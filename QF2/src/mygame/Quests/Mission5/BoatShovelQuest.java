/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class BoatShovelQuest extends Quest {
    
  public BoatShovelQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "BoatQuest";
    }
  
  @Override
  public void act(){
    
    String speech;
    Quest  boatQuest = player.questList.getQuest("BoatQuest");
    
    if (boatQuest == null) {
      boatQuest = new BoatQuest(stateManager, player);
      player.questList.add(boatQuest);
      boatQuest.step = "Start";  
      }
    
    if (player.inventory.contains("Shovel")) {
      speech = "You put the shovel back where you found it.";
      ((Interactable) holder).model.getChild("Shovel").move(0,5,0);
      player.inventory.remove("Shovel");
      }
    
    else {
      speech = "You take the shovel.";  
      ((Interactable) holder).model.getChild("Shovel").move(0,-5,0);
      player.inventory.add("Shovel");
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }  
    
  }
