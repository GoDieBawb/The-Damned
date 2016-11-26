/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission3;

import com.jme3.app.state.AppStateManager;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class JailDrainQuest extends Quest {
    
    public JailDrainQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "JailQuest";
    }
    
    @Override
    public void act(){
        
        Quest jailQuest = player.questList.getQuest("JailQuest");
        String speech;
        
        if (jailQuest == null) {
            jailQuest      = new JailQuest(stateManager, player);
            jailQuest.step = "Start";
            player.questList.add(jailQuest);
        }
        
        switch (jailQuest.step) {
            case "Start":
                speech = "The drain is loose... With some effort you manage to pry it open enough to squeeze through.";
                player.phys.warp(new Vector3f(-7,0,-20));
                jailQuest.step = "FindBottle";
                break;
            case "FindBottle":
                speech = "You have to escape... You don't want to go back in there.";
                break;
            case "HasBottle":
                speech = "Holding onto the bottle you crawl back through into the jail cell.";
                player.phys.warp(new Vector3f(-9,0,-20));
                jailQuest.step = "GiveBottle";
                break;
            case "GiveBottle":
                speech = "As you attempt to crawl back through the drain the Guard catches you and kills you for trying to escape.";
                super.fail();
                break;
            case "GaveBottle":
                speech = "You crawl back outside through the drain.";
                jailQuest.step = "KillGuard";
                player.phys.warp(new Vector3f(-7,0,-20));
                break;
            case "KillGuard":
                speech = "You have to escape... Time is running out. You don't want to go back into your cell.";
                break;
            default:
                speech = "You don't want to go back inside. Time is running out";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
