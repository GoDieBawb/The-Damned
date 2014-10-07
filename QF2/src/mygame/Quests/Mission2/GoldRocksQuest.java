/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class GoldRocksQuest extends Quest {
   
  public GoldRocksQuest(AppStateManager stateManager, Node holder) {
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
    
    if (mineQuest.step.equals("Start")) {
      speech = "A dark force rips your face off";
      super.fail();
      }
    
    else if (mineQuest.step.equals("GetGold")) {
      speech = "Using the shovel you dig the gold from the ground...";
      ((Interactable) holder).model.getChild("Gold").removeFromParent();
      mineQuest.step = "HasGold";
      }
    
    else if (mineQuest.step.equals("HasGold")) {
      speech = "Empty Goldless Rocks... The gold is all yours! GOLD GOLD GOLD!";
      }
    
    else {
        
      speech = "Rocks.... full of gold!";
      
      }
    
    gui.showAlert(holder.getName(), speech);
    
    }  
  
  }
