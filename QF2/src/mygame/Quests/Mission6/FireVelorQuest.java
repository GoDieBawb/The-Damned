/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission6;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class FireVelorQuest extends Quest {
    
  public FireVelorQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "FireQuest";
    }
  
  @Override
  public void act(){
    
    String speech;
    Quest fireQuest = player.questList.getQuest("FireQuest");
    
    if (fireQuest == null) {
      fireQuest = new FireQuest(stateManager, holder);
      player.questList.add(fireQuest);
      fireQuest.step = "Start";
      }
    
    if (player.inventory.contains("Bucket")) {
      speech = "Seeing you with the murdered Alexander's bucket, he stops you before you can complete your plan.";
      fireQuest.fail();
      }
    
    else if (player.inventory.contains("Axe")) {
      speech = "I wouldn't send you out at night if we weren't desperate... We need that wood.";
      }
    
    else if (player.inventory.contains("BurnedTable")) {
      speech = "That table was the last of the wood? We only have one chance... You need to take the axe and cut down a tree. It's our only hope.";
      }
    
    else {
      speech = "The fire is burning low... Look around town for something to burn. There has to be something.";
      }
      
    gui.showAlert(holder.getName(), speech);
    
    }      
    
  }
