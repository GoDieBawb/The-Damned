/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class MineDoorQuest extends Quest {
    
  public MineDoorQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "MineQuest";
    }
  
  @Override
  public void act() {
      
    Quest mineQuest = player.questList.getQuest("MineQuest");
    String speech;
    
    if (mineQuest == null) {
      mineQuest      = new MineQuest(stateManager, player);
      mineQuest.step = "Start";
      player.questList.add(mineQuest);
      }
    
    String doorType = ((Interactable) holder).model.getUserData("Name");
    
    if (doorType.equals("MineDoor")) {
        
      if (mineQuest.step.equals("FindBody")) {  
        player.phys.warp(new Vector3f(-5,1,-6));
        speech = "You enter the mine...";
        gui.showAlert(holder.getName(), speech);
        }
      
      else {
        speech = "You don't want to go in that mine...";
        gui.showAlert(holder.getName(), speech);
        }
      
      }
    
    else {
        
      if (mineQuest.step.equals("FindBody")) {
        speech = "A voice calls from within the mine... GOLD. The gold is here... I'VE FOUND THE GOLD.";
        gui.showAlert(holder.getName(), speech);
        }
      
      else if (mineQuest.step.equals("FindGold")) {
        speech = "YOU'VE COME SO FAR.... THE GOLD.... YOU CAN'T LEAVE WITHOUT GOLD";
        gui.showAlert(holder.getName(), speech);
        }
      
      else if (mineQuest.step.equals("HasGold")) {
        speech = "As you attempt you leave the mine with the gold, you are grabbed from behind.... And dragged back into the darkness.";  
        super.finish();
        gui.showAlert(holder.getName(), speech);
        }
      
      else {    
        player.phys.warp(new Vector3f(7,2,6));
        }
      
      
      }
    
    }
  
  }  
