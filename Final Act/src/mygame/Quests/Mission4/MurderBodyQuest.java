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
public class MurderBodyQuest extends Quest {
  
  public MurderBodyQuest(AppStateManager stateManager, Node holder) {
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
    
    if (murderQuest.step.equals("Start")) {
      speech = "The Inspector sees you trying to pull the knife out of the body and arrests you immediately";  
      murderQuest.fail();
      }
    
    else {
    
    if (player.inventory.contains("Knife")) {
      speech = "You put the knife back into the body.";
      player.inventory.remove("Knife");
      ((Interactable) holder).model.getChild("Knife").move(0,5,0);
      }
    
    else {
      speech = "You take the knife from the body";
      player.inventory.add("Knife");
      ((Interactable) holder).model.getChild("Knife").move(0,-5,0);
      }
    
    if (!player.inventory.contains("Blood")) {
      player.inventory.add("Blood");
      }
    
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
