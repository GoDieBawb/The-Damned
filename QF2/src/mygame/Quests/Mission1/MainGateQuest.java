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
public class MainGateQuest extends Quest {
  
  public MainGateQuest(AppStateManager stateManager, Node holder) {
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
      speech = "A strong gate meant to keep out goblins.";
      }
    
    else {
      speech = "Let's hope this gate can hold off Goblins better than the other one.";
      }
    
    gui.showAlert(holder.getName(), speech);
    
    }
    
  }    
