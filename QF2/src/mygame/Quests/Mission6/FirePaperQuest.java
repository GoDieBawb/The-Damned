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
public class FirePaperQuest extends Quest {
  
  public FirePaperQuest(AppStateManager stateManager, Node holder) {
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
    
    speech = "Your writings... 'The darkness has been calling me... The fire hurts my eyes, I just can't take it anymore... I NEED THE DARKNESS";
      
    gui.showAlert(holder.getName(), speech);
    
    }    
    
  }
