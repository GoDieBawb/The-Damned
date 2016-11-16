package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
    this.setShowSettings(false);
    this.setDisplayFps(false);
    this.setDisplayStatView(false);        
    this.stateManager.attach(new PlayerManager());
    this.stateManager.attach(new NpcManager());
    this.stateManager.attach(new InteractableManager());
    this.stateManager.attach(new SceneManager());
    this.stateManager.attach(new CameraManager());
    this.stateManager.attach(new InteractionManager());
    this.stateManager.attach(new GuiManager());
    this.stateManager.attach(new AudioManager());
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
