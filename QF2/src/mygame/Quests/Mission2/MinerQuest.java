/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class MinerQuest extends Quest {
  
  public MinerQuest(AppStateManager stateManager, Node holder) {
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
      speech = "I'm leaving this place now... If you're wise you should too traveler.";
      }
    
    else if (mineQuest.step.equals("FindMiner")) {
      speech = "Of course I'm leaving this Devil's Mine! Jerome however... has gone back into the mine, muttering about gold.";
      mineQuest.step = "FindBody";
      }
    
    else {    
      speech = "Apparently Jerome couldn't stay out of that mine... You'd be wise not to follow him.";
      }
    
    gui.showAlert(holder.getName(), speech);
    
    }
  
  }
