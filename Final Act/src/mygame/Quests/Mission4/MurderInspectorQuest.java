/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission4;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Npc;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class MurderInspectorQuest extends Quest {
    
  private boolean atSmith;  

  public MurderInspectorQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "MurderQuest";
    atSmith = false;
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
    
    if (player.inventory.contains("Bottle")) {
      speech = "The inspector spots you with the stolen bottle and arrests you immediately.";
      murderQuest.fail();
      }
    
    else if (player.inventory.contains("Blood")) {
      speech = "The Inspector spots you covered in blood and arrests you immediately.";
      murderQuest.fail();
      }
    
    else if (player.inventory.contains("Ring")) {
      speech = "The Inspector spots you with the victim's ring and arrests you immediately.";
      murderQuest.fail();
      }
    
    else if (player.inventory.contains("Axe")) {
      speech = "The Inspector spots you with the axe and arrests you immediately.";
      murderQuest.fail();
      }
    
    else if (!atSmith) {
    
    if (player.inventory.contains("Knife")) {
      speech = "The Inspector spots you with the knife and arrests you immediately.";
      murderQuest.fail();
      }
    
    else if (murderQuest.step.equals("KilledSmith")) {
      speech = "The BlackSmith has been murdered?! I must go investigate immediately!";
      ((Npc) holder).phys.warp(new Vector3f(16,.2f,-26));
      atSmith = true;
      }
    
    else {
      speech = "Do not disturb my investigation...";
      }
    
    }
    
    else if (murderQuest.step.equals("HasFramed")) {
        
      if (player.inventory.contains("Knife")) {
        speech = "Confident the Inspector has caught the murderer he doesn't see you coming when you stab him with the knife";
        murderQuest.finish();
        }
      
      else {
        speech = "I've arrested the InnKeeper... I found the victims ring in their Jewelry Box. Open and shut case";
        }
      
      }
    
    else {
      
      if (murderQuest.step.equals("PlacedRing")) {
        speech = "This bottle of Vodka belonged to the InnKeeper... Time to go check the InnKeepers home for clues.";
        ((Npc) holder).phys.warp(new Vector3f(-1,.2f,15));
        ((Npc) holder.getParent().getChild("InnKeeper")).phys.warp(new Vector3f(1.5f,.2f,13));
        murderQuest.step = "HasFramed";
        }
      
      else {
        speech = "Do not disturb my investigation!";
        }
        
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }    
    
  }
