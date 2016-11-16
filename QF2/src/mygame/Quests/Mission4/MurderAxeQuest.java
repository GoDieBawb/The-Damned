/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class MurderAxeQuest extends Quest {
  
  public MurderAxeQuest(AppStateManager stateManager, Node holder) {
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
    
    if (player.inventory.contains("Axe")) {
      speech = "You place the axe back into the chopping block";
      player.inventory.remove("Axe");
      ((Interactable) holder).model.getChild("Axe").move(0,5,0);
      }
    
    else {
      speech = "You take the axe from the chopping block";
      player.inventory.add("Axe");
      ((Interactable) holder).model.getChild("Axe").move(0,-5,0);
      }
    
    gui.showAlert(holder.getName(), speech);  
      
    }
    
  }
