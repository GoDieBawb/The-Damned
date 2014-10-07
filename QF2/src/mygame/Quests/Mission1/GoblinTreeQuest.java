/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class GoblinTreeQuest extends Quest {
    
  public GoblinTreeQuest(AppStateManager stateManager, Node holder) {
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
      speech = "A tree in the Goblin Forest...";
      }
    
    else if (goblinQuest.step.equals("GetWood")) {
      speech           = "You chop down the tree, retrieving the wood.";
      goblinQuest.step = "FixGate";
      Node in          = holder.getParent();
      holder.removeFromParent();
      
      //Move the Goblins Into The House
      
      for (int i = 0; i < in.getQuantity(); i++) {
          
        Node ci = (Node) ((Interactable)in.getChild(i)).model;
        
        if (ci.getUserData("Name").equals("Goblin"))
        ci.setLocalTranslation(new Vector3f(-66,3.6f,-71));  
        
        }
      
      }
    
    else {
      speech = "A tree in the Goblin Forest...";
      }
    
    gui.showAlert(holder.getName(), speech);
    
    }
    
  }