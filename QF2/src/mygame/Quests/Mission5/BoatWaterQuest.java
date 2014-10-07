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
public class BoatWaterQuest extends Quest {
    
  private boolean dug;  
  
  public BoatWaterQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "BoatQuest";
    dug  = false;
    }
  
  @Override
  public void act(){
    
    String speech;
    Quest  boatQuest = player.questList.getQuest("BoatQuest");
    
    if (boatQuest == null) {
      boatQuest = new BoatQuest(stateManager, player);
      player.questList.add(boatQuest);
      boatQuest.step = "Start";
      dug            = false;
      }
    
    if (dug) {
      
      if (player.inventory.contains("Water")) {
        speech = "You place the small keg of water back into the hole";
        player.inventory.remove("Water");
        ((Interactable) holder).model.getChild("Water").move(0,5,0);
        }
      
      else {
        speech = "You take the small keg of water from the hole.";
        ((Interactable) holder).model.getChild("Water").move(0,-5,0);
        player.inventory.add("Water");
        }
        
      }
    
    else if (player.inventory.contains("FoodKnowledge")) {
      
      if (player.inventory.contains("Shovel")) {  
        speech = "Using the shovel you dig up a small keg of water.";
        ((Interactable) holder).model.getChild("Water").move(0,5,0);
        dug = true;
        }
    
      else {
        speech = "This is where the note said the water was buried...";
        }
      
      }
    
    else {
      speech = "The ground seems strangely soft here...";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
