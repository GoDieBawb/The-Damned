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
public class BoatPoisonQuest extends Quest {
  
  public BoatPoisonQuest(AppStateManager stateManager, Node holder) {
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
    
    if (player.inventory.contains("FoodKnowledge")) {
      
      if (player.inventory.contains("Poison")) {
        speech = "You place the bottle of poison back on the table";
        player.inventory.remove("Poison");
        ((Interactable) holder).model.getChild("Bottle").move(0,5,0);
        }
      
      else if (player.inventory.contains("Bread")) {
        speech = "You grab the poison bottle from the table and pour it onto the bread.";
        ((Interactable) holder).model.getChild("Bottle").move(0,-5,0);
        player.inventory.add("Poison");
        player.inventory.add("PoisonedBread");
        }
      
      else {
        speech = "You grab the poison from the table.";
        ((Interactable) holder).model.getChild("Bottle").move(0,-5,0);
        player.inventory.add("Poison");
        }
        
      }
    
    else {
      speech = "A strange bottle of liquid sits on this table.";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
