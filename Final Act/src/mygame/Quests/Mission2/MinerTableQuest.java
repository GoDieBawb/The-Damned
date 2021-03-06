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
public class MinerTableQuest extends Quest{
    
    public MinerTableQuest(AppStateManager stateManager, Node holder) {
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
                speech = "What seems to be a Miner's Diary";
                break;
            case "FindPaper":
                speech = "What seems to be a Miner's Diary";
                break;
            case "FoundPaper":
                speech = "What seems to be a Miner's Diary";
                break;
            case "FindMiner":
                speech = "What seems to be a Miner's Diary";
                break;
            default:
                speech = "Jerome's Diary: GOLD! The voice... It knows where the gold is. Tonight, TONIGHT. The gold is MINE";
                break;
        }
        
    }
    
}
