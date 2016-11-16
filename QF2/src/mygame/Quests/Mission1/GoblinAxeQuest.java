/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class GoblinAxeQuest extends Quest {
 
  public GoblinAxeQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "GoblinQuest";
    }
  
  @Override
  public void act() {
      
    Quest goblinQuest = player.questList.getQuest("GoblinQuest");
    String speech;
    
    if (goblinQuest == null) {
      goblinQuest      = new GoblinQuest(stateManager, player);
      goblinQuest.step = "Start";
      player.questList.add(goblinQuest);
      }
    
    if (goblinQuest.step.equals("Start")) {
      speech = "An Axe is here on the wall";
      }
    
    else if (goblinQuest.step.equals("FindAxe")) {
      goblinQuest.step = "GetWood";
      speech = "You grab the axe of the wall.";
      holder.removeFromParent();
      }
    
    else {
      speech = "An Axe is here on the wall";
      }
    
    gui.showAlert(holder.getName(), speech);
    
    }
    
  }
