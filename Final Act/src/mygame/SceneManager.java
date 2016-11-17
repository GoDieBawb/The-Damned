package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.SceneGraphVisitor;
import com.jme3.scene.Spatial;
import com.jme3.texture.Texture;

/**
 *
 * @author Bob
 */
public class SceneManager extends AbstractAppState {

  private SimpleApplication   app;
  private AppStateManager     stateManager;
  private AssetManager        assetManager;
  public  Node                scene;
  private BulletAppState      physics;
  private Player              player;
  private NpcManager          npcManager;
  private InteractableManager interactableManager;
  private Node                rootNode;
  
  @Override
  public void initialize(AppStateManager stateManager, Application app){
    super.initialize(stateManager, app);
    this.app            = (SimpleApplication) app;
    this.stateManager   = this.app.getStateManager();
    this.assetManager   = this.app.getAssetManager();
    npcManager          = this.stateManager.getState(NpcManager.class);
    interactableManager = this.stateManager.getState(InteractableManager.class);
    player              = this.stateManager.getState(PlayerManager.class).player;
    rootNode            = this.app.getRootNode();
    scene               = new Node();
    physics             = this.stateManager.getState(PlayerManager.class).physics;
    }
  
  public void initScene(String scenePath){
    
    stateManager.attach(physics);
    
    physics.getPhysicsSpace().add(player.phys);
    player.inventory.clear();
    this.app.getRootNode().attachChild(player);

    rootNode.detachChild(scene);
    physics.getPhysicsSpace().removeAll(scene);

    scene = (Node) assetManager.loadModel(scenePath);
    addPhys();

    stateManager.getState(AudioManager.class).playSong();
    
    Vector3f startSpot = scene.getChild("StartSpot").getLocalTranslation();
    player.phys.warp(startSpot.add(0,1,0));
    player.phys.setGravity(new Vector3f(0, -50, 0));
    
    npcManager.setEnabled(true);
    interactableManager.setEnabled(true);
    
    rootNode.attachChild(scene);
    
    interactableManager.initInteractables(scene);
    npcManager.initNpcs(scene);
    
    makeUnshaded(app.getRootNode());
    
    }
  
  public void removeScene(){
    //app.getViewPort().removeProcessor(processor);
    physics.getPhysicsSpace().removeAll(scene);
    npcManager.setEnabled(false);
    interactableManager.setEnabled(false);
    stateManager.getState(AudioManager.class).stopSong();
    rootNode.detachAllChildren();
    stateManager.detach(physics);
    scene = new Node();
    }
  
  public void addPhys() {
    physics.getPhysicsSpace().removeAll(scene);
    
    RigidBodyControl phys  = new RigidBodyControl(0f);
    RigidBodyControl phys1 = new RigidBodyControl(0f);
    
    scene.getChild("SceneNode").removeControl(RigidBodyControl.class);
    scene.getChild("InteractableNode").removeControl(RigidBodyControl.class);
    scene.getChild("SceneNode").addControl(phys);
    scene.getChild("InteractableNode").addControl(phys1);
    
    physics.getPhysicsSpace().add(phys);
    physics.getPhysicsSpace().add(phys1);      
    }

  public void makeUnshaded(Node node) {
      
    SceneGraphVisitor sgv = new SceneGraphVisitor() {
 
    public void visit(Spatial spatial) {
        
      if (spatial instanceof Geometry) {
        
        Geometry geom = (Geometry) spatial;
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material tat = new Material(assetManager, "Common/MatDefs/Terrain/Terrain.j3md");

        if (geom.getParent().getParent().getName().equalsIgnoreCase("Stairhelper")){}  
        
        else if (geom.getMaterial().getTextureParam("DiffuseMap_1") != null) {
            
          String     alTexPath  = geom.getMaterial().getTextureParam("AlphaMap").getTextureValue().getName().substring(1);
          TextureKey alkey      = new TextureKey(alTexPath, false);
          Texture    alTex      = assetManager.loadTexture(alkey);  
          tat.setTexture("Alpha", alTex);            
            
          //tat.setTexture("Alpha", geom.getMaterial().getTextureParam("AlphaMap").getTextureValue());
          
          if (geom.getMaterial().getTextureParam("DiffuseMap") != null) {
           
          tat.setTexture("Tex1", geom.getMaterial().getTextureParam("DiffuseMap").getTextureValue());
          tat.getTextureParam("Tex1").getTextureValue().setWrap(Texture.WrapMode.Repeat);
          tat.setFloat("Tex1Scale", Float.valueOf(geom.getMaterial().getParam("DiffuseMap_0_scale").getValueAsString()));
          
          }
        
          if (geom.getMaterial().getTextureParam("DiffuseMap_1") != null) {
              
          tat.setTexture("Tex2", geom.getMaterial().getTextureParam("DiffuseMap_1").getTextureValue());
          tat.getTextureParam("Tex2").getTextureValue().setWrap(Texture.WrapMode.Repeat);
          tat.setFloat("Tex2Scale", Float.valueOf(geom.getMaterial().getParam("DiffuseMap_1_scale").getValueAsString()));
          
          }
        
          if (geom.getMaterial().getTextureParam("DiffuseMap_2") != null) {
              
          tat.setTexture("Tex3", geom.getMaterial().getTextureParam("DiffuseMap_2").getTextureValue());
          tat.getTextureParam("Tex3").getTextureValue().setWrap(Texture.WrapMode.Repeat);
          tat.setFloat("Tex3Scale", Float.valueOf(geom.getMaterial().getParam("DiffuseMap_2_scale").getValueAsString()));
          
          }

          geom.setMaterial(tat);
          
          }
        
        else if (geom.getMaterial().getTextureParam("DiffuseMap") != null) {
          mat.setTexture("ColorMap", geom.getMaterial().getTextureParam("DiffuseMap").getTextureValue());
          geom.setMaterial(mat);
          }
       
        }
      
      }
    
    };
    
  node.depthFirstTraversal(sgv);
    
  }
  
}
