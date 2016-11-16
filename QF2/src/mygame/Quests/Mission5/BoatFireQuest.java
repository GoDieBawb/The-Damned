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
public class BoatFireQuest extends Quest {
  
  public BoatFireQuest(AppStateManager stateManager, Node holder) {
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
    
    if (player.inventory.contains("RawMeat")) {
      speech = "You sear the Guard's flesh on the fire... Cooking it.";
      player.inventory.remove("RawMeat");
      player.inventory.add("Meat");
      }
    
    else if (player.inventory.contains("Meat")) {
      speech = "Cooking this meat won't preserve it any further...";
      }
    
    else {
      speech = "The only source of warmth on this island.";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
