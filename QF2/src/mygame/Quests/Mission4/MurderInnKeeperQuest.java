/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class MurderInnKeeperQuest extends Quest {
    
  
  public MurderInnKeeperQuest(AppStateManager stateManager, Node holder) {
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
    
    if (player.inventory.contains("Ring")) {
      speech = "The InnKeeper spots you with the victim's ring and calls the inspector who arrests you immediately.";
      murderQuest.fail();
      }
    
    else if (player.inventory.contains("Axe")) {
      speech = "The InnKeeper spots you with the axe and calls the inspector who arrests you immediately.";
      murderQuest.fail();
      }
      
    else if (player.inventory.contains("Bottle")) {
      speech = "The InnKeeper sees you with the stolen bottle and calls the inspector who arrests the immediately.";
      murderQuest.fail();
      }
    
    else if (player.inventory.contains("Blood")) {
      speech = "The InnKeeper sees you covered in blood and calls the inspector who arrests you immediately.";
      murderQuest.fail();
      }
    
   else if (!murderQuest.step.equals("HasFramed")) {
    
      speech = "I can't believe there's been a murder...";
    
      }
    
    else {
      speech = "I didn't murder anyone I've been framed!";  
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
