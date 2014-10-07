/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission5;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class BoatQuest extends Quest {
  
  public BoatQuest(AppStateManager stateManager, Node holder) {
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
    
    if (player.inventory.contains("CuredMeat") && player.inventory.contains("Water")) {
      speech = "You place the cured meat and water into the boat and set off for the mainland... Never to return.";
      boatQuest.finish();
      }
    
    else if (player.inventory.contains("KilledGuard")) {
      speech = "More supplies are necessary if you're going to survive the voyage.";
      }
    
    else {
      speech = "As you attempt to climb into the boat the Guard strikes you down immediately... No one leaves the island";
      boatQuest.fail();
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
