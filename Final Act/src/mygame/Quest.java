/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;

public abstract class Quest {
    
    public AppStateManager stateManager;
    public GuiManager gui;
    public Player     player;
    public String     step;
    public String     name;
    public Node       holder;
    
    public Quest(AppStateManager stateManager, Node holder){
        this.stateManager = stateManager;
        this.player       = stateManager.getState(PlayerManager.class).player;
        this.gui          = stateManager.getState(GuiManager.class);
        this.holder       = holder;
    }
    
    public abstract void act();
    
    public void finish(){
        
        if (player.currentLevel > player.bestLevel) {
            player.saveScore(player.currentLevel, stateManager);
            player.bestLevel = player.currentLevel;
        }
        
        player.inventory.clear();
        player.questList.remove(this);
        
        stateManager.getState(SceneManager.class).removeScene();
        stateManager.getState(GuiManager.class).showMenu();
        
    }
    
    public void fail(){
        stateManager.getState(SceneManager.class).removeScene();
        stateManager.getState(GuiManager.class).showMenu();
        player.inventory.clear();
        player.questList.clear();
    }
    
}
