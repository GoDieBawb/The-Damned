/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission6;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class FireQuest extends Quest {
  
  private boolean killedPlayer;  
    
  public FireQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "FireQuest";
    }
  
  public void playerTrack(){
      
    if (player.getLocalTranslation().distance(holder.getLocalTranslation()) > 32 && !killedPlayer) {
      
      killedPlayer = true;
      gui.showAlert("Darkness", "As you travel too far into the darkness you are grabbed by the evil within and dragged into the forest.");
      Quest fireQuest = player.questList.getQuest("FireQuest");
      player.setLocalTranslation(new Vector3f(0,0,0));
      
      if (fireQuest == null) {
        fireQuest =  new FireQuest(stateManager, player);
        player.questList.add(fireQuest);
        }
      
      player.questList.getQuest("FireQuest").fail();
      
      }
    
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
    
    if (player.inventory.contains("Water")) {
      speech = "As you extinguish the fire the people of The Village realize it's too late... The End has come.";
      fireQuest.finish();
      }
    
    else if (player.inventory.contains("Table")) {
      speech = "You place the table into the fire... You'll survive... For now.";
      ((Interactable) holder).model.getChild("Table").move(0,5,0);
      player.inventory.remove("Table");
      player.inventory.add("BurnedTable");
      }
    
    else {
      speech = "The fire that keeps the goblins away.... The Village is safe.";
      }
      
    gui.showAlert(holder.getName(), speech);
    
    }
    
  }
