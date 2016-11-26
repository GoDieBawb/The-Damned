/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class RichardTableQuest extends Quest {
    
    public RichardTableQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "MineQuest";
    }
    
    @Override
    public void act() {
        
        Quest mineQuest = player.questList.getQuest("MineQuest");
        String speech;
        
        if (mineQuest == null) {
            mineQuest      = new MineQuest(stateManager, player);
            mineQuest.step = "Start";
            player.questList.add(mineQuest);
        }
        
        switch (mineQuest.step) {
            case "Start":
                speech = "A table with what seems to be records of an old mining company...";
                break;
            case "FindPaper":
                speech = "The document reads: Today a miner fled the mine speaking of a large find of gold. He claimed an attack by a Demon in the mine before dying.";
                mineQuest.step = "FoundPaper";
                break;
            default:
                speech = "A paper talking of gold deep in the mine, and a dark force uncovered that shouldn't be released.";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
