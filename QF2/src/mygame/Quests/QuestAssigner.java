package mygame.Quests;

import mygame.Quests.Mission1.*;
import mygame.Quests.Mission2.*;
import mygame.Quests.Mission3.*;
import mygame.Quests.Mission4.*;
import mygame.Quests.Mission5.*;
import mygame.Quests.Mission6.*;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.scene.Node;
import com.jme3.texture.Texture;
import mygame.Interactable;
import mygame.Npc;
import mygame.Quest;

/**
 *
 * @author Bob
 */
public class QuestAssigner {
  
  private AppStateManager stateManager;
    
  public QuestAssigner(AppStateManager stateManager) {
    this.stateManager = stateManager;
    }  
    
  public Quest assignQuest(Node holder) {
    
    Quest quest;
    String name;
    
    try {
      name = ((Interactable) holder).model.getUserData("Name");
      }
    
    catch (ClassCastException e) {
      name = ((Npc) holder).model.getUserData("Name");  
      }
    
    //Init the BillyQuest Stuff

    if (name.equals("Goblin")) {
      quest = new GoblinQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "You get eaten by the Goblin";
      }
    
    //Used BillyTree for convienence
    else if (name.equals("BillyTree")) {
      quest = new GoblinTreeQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A tree stands here";
      }
    
    else if (name.equals("GoblinAxe")) {
      quest = new GoblinAxeQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "An axe on the wall";
      }
    
    else if (name.equals("BrokenGate")) {
      quest = new BrokeGateQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A broken gate lies here";
      }

    else if (name.equals("TownGate")) {
      quest = new MainGateQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A sturdy and hopefully goblin proof gate";
      }
    
    else if (name.equals("OldGate")) {
      quest = new OldGateQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "This gate is old and rusted...";
      }
    
    else if (name.equals("Lago")) {
      quest = new LagoQuest(stateManager, holder);  
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/CheckeredShirt.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("Edmund")) {
     quest = new EdmundQuest(stateManager, holder);   
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/GreenShirt.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("Andy")) {
      quest = new AndyQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/RedShirt.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    //Quest Two Will Start Here
    else if (name.equals("MineDoor") || (name.equals("MineExit"))) {
      quest = new MineDoorQuest(stateManager,holder);
      if (name.equals("MineExit"))
      ((Interactable) holder).contactMessage = "The exit from hell...";
      else
      ((Interactable) holder).contactMessage = "The enterance to an old mine...";
      }
    
    else if (name.equals("DeadMiner")) {
      quest= new DeadMinerQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A dead body lies here...";
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/BlackSmith.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Interactable) holder).model.setMaterial(mat); 
      }
    
    else if (name.equals("RichardTable")) {
      quest = new RichardTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A table with a document";
      }
    
    else if (name.equals("MinerTable")) {
      quest =  new MinerTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A small book lies on this table";
      }
    
    else if (name.equals("GoldRocks")) {
      quest =  new GoldRocksQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Some rocks seem to be on the ground here.";
      }
    
    else if (name.equals("Miner")) {
      quest = new MinerQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/BlackSmith.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("Richard")) {
      quest = new RichardQuest(stateManager, holder);         
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Tuxedo.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    //Mission Three Items
    else if (name.equals("JailGuard")) {
      quest = new JailGuardQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Suspenders.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("JailWarden")) {
      quest = new JailWardenQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Sheriff.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("JailDrain")) {
      quest =  new JailDrainQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A drain is here at the bottom of the wall.";
      }
    
    else if (name.equals("JailDoor")) {
      quest =  new JailDoorQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "The door to the cell.";
      }
    
    else if (name.equals("JailBottle")) {
      quest =  new JailBottleQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A bottle lies just outside the fence.";
      }
    
    else if (name.equals("JailFortGate")) {
      quest =  new JailFortGateQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "The main door to the fort.";
      }
    
    else if (name.equals("JailGallows")) {
      quest =  new JailGallowsQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Gallows for prisoners to be executed.";
      }
    
    else if (name.equals("JailYardEnter") || name.equals("JailYardExit")) {
      quest =  new JailYardDoorQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Door to the Jail.";
      }
    
    else if (name.equals("JailTable")) {
      quest =  new JailTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A table sits here.";
      }
    
    //Mission Four Stuff
    else if (name.equals("MurderInspector")) {
      quest =  new MurderInspectorQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Sheriff.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("MurderSmith")) {
      quest =  new MurderSmithQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/BlackSmith.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("MurderInnKeeper")) {
      quest =  new MurderInnKeeperQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/ShopKeeper.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("MurderBody")) {
      quest =  new MurderBodyQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A dead body lies on the floor.";
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Body.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Interactable) holder).model.setMaterial(mat);  
      }
    
    else if (name.equals("MurderWell")) {
      quest =  new MurderWellQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A well in the middle of town.";
      }

    else if (name.equals("MurderInnKeepersTable")) {
      quest =  new MurderInnKeepersTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A table sits here.";
      }

    else if (name.equals("MurderInspectorsTable")) {
      quest =  new MurderInspectorsTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A table sits here.";
      }
    
    else if (name.equals("MurderCrate")) {
      quest =  new MurderCrateQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A crate sits here.";
      }

    else if (name.equals("MurderBottle")) {
      quest =  new MurderBottleQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A bottle sits here on the counter.";
      }
    
    else if (name.equals("MurderAxe")) {
      quest =  new MurderAxeQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A block for chopping wood.";
      }
    
    //Mission 5 Stuff
    else if (name.equals("Boat")) {
      quest =  new BoatQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A boat floats by the dock";
      }
    
    else if (name.equals("BoatFarmer")) {
      quest =  new BoatFarmerQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/CheckeredShirt.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat); 
      }

    else if (name.equals("BoatGuard")) {
      quest =  new BoatGuardQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/Suspenders.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat); 
      }

    else if (name.equals("BoatAxe")) {
      quest =  new BoatAxeQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A table sits here...";
      }
    
    else if (name.equals("BoatShovel")) {
      quest =  new BoatShovelQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A shovel leans against the wall.";
      }
    
    else if (name.equals("BoatSaltBarrels")) {
      quest =  new BoatSaltBarrelsQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A few barrels for storage.";
      }
    
    else if (name.equals("BoatFire")) {
      quest =  new BoatFireQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A fire burns in the fire place.";
      }
    
    else if (name.equals("BoatWater")) {
      quest =  new BoatWaterQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "The ground seems softer here.";
      }
    
    else if (name.equals("BoatCrates")) {
      quest =  new BoatCratesQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "Some crates for storage.";
      }
    
    else if (name.equals("BoatGuardsTable")) {
      quest =  new BoatGuardsTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A table with a note on it...";
      }
    
    else if (name.equals("BoatPoison")) {
      quest =  new BoatPoisonQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A bottle sits on the table...";
      }
    
    //Mission Six Stuffs
    else if (name.equals("Fire")) {
      quest =  new FireQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A fire burns brightly here...";
      }

    else if (name.equals("FireTable")) {
      quest =  new FireTableQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A table sits here...";
      }

    else if (name.equals("FireBucket")) {
      quest =  new FireBucketQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A bucket sits on the floor...";
      }

    else if (name.equals("FireWell")) {
      quest =  new FireWellQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A well has been built here...";
      }

    else if (name.equals("FireAxe")) {
      quest =  new FireAxeQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "An axe leans against the wall...";
      }
    
    else if (name.equals("FirePaper")) {
      quest =  new FirePaperQuest(stateManager, holder);
      ((Interactable) holder).contactMessage = "A handwritten paper sits on the floor...";
      }
    
    else if (name.equals("FireVelor")) {
      quest =  new FireVelorQuest(stateManager, holder);
      }
    
    else if (name.equals("FireDraco")) {
      quest =  new FireDracoQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/RedShirt.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat); 
      }
    
    else if (name.equals("FireAlexander")) {
      quest =  new FireAlexanderQuest(stateManager, holder);
      Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
      TextureKey key = new TextureKey("Models/Person/GreenShirt.png", true);
      Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);    
      mat.setTexture("ColorMap", tex);    
      ((Npc) holder).model.setMaterial(mat); 
      }
    
    else {
      return null;
      }
    
    return quest;
    }  
    
  }
