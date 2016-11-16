/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.Quests.Mission1;
import com.jme3.animation.AnimControl;
import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Interactable;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class GoblinQuest extends Quest {
  
  public GoblinQuest(AppStateManager stateManager, Node holder) {
    super(stateManager, holder);
    name = "GoblinQuest";
    if (holder instanceof Interactable)
    animate();
    }
  
  private void animate(){
    Node gob = (Node) ((Node)((Interactable) holder).model.getChild(0)).getChild(0);
    gob.getControl(AnimControl.class).createChannel().setAnim("idleA");
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
      goblinQuest.fail();
      speech = "As you approach, the goblin spots you. He eats you on the spot.";
      }
    
    else if (goblinQuest.step.equals("BurnHouse")) {
      speech = "The Goblins are gathered upstairs feasting on the bodies of the Villagers... They have no chance of escape as you start the fire.";
      goblinQuest.finish();
      }
    
    else {
      goblinQuest.fail();
      speech = "As you approach, the goblin spots you. He eats you on the spot.";
      }
    
    gui.showAlert(holder.getName(), speech);
      
    }
    
  }
