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
public class MurderInspectorsTableQuest extends Quest {
  
  public MurderInspectorsTableQuest(AppStateManager stateManager, Node holder) {
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
    
    speech = "The Inspectors Log Reads: A murder has been commited. There's only Three Possible Suspects... The Smith, The InnKeeper, and the Town Stranger.";
    
    gui.showAlert(holder.getName(), speech);
      
    }  
    
  }
