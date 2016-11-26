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
import com.jme3.material.RenderState;
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
        switch (name) {
            case "Goblin":
                quest = new GoblinQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "You get eaten by the Goblin";
                break;
            case "BillyTree":
                quest = new GoblinTreeQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A tree stands here";
                break;
            case "GoblinAxe":
                quest = new GoblinAxeQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "An axe on the wall";
                break;
            case "BrokenGate":
                quest = new BrokeGateQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A broken gate lies here";
                break;
            case "TownGate":
                quest = new MainGateQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A sturdy and hopefully goblin proof gate";
                break;
            case "OldGate":
                quest = new OldGateQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "This gate is old and rusted...";
                break;
            case "Lago":
                {
                    quest = new LagoQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/CheckeredShirt.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "Edmund":
                {
                    quest = new EdmundQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/GreenShirt.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "Andy":
                {
                    quest = new AndyQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/RedShirt.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "MineDoor":
                quest = new MineDoorQuest(stateManager,holder);
                if (name.equals("MineExit"))
                    ((Interactable) holder).contactMessage = "The exit from hell...";
                else
                    ((Interactable) holder).contactMessage = "The enterance to an old mine...";
                break;
            case "MineExit":
                quest = new MineDoorQuest(stateManager,holder);
                if (name.equals("MineExit"))
                    ((Interactable) holder).contactMessage = "The exit from hell...";
                else
                    ((Interactable) holder).contactMessage = "The enterance to an old mine...";
                break;
            case "DeadMiner":
                {
                    quest= new DeadMinerQuest(stateManager, holder);
                    ((Interactable) holder).contactMessage = "A dead body lies here...";
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/BlackSmith.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Interactable) holder).model.setMaterial(mat);
                    break;
                }
            case "RichardTable":
                quest = new RichardTableQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A table with a document";
                break;
            case "MinerTable":
                quest =  new MinerTableQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A small book lies on this table";
                break;
            case "GoldRocks":
                quest =  new GoldRocksQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "Some rocks seem to be on the ground here.";
                break;
            case "Miner":
                {
                    quest = new MinerQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/BlackSmith.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "Richard":
                {
                    quest = new RichardQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/Tuxedo.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "JailGuard":
                {
                    quest = new JailGuardQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/Suspenders.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "JailWarden":
                {
                    quest = new JailWardenQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/Sheriff.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "JailDrain":
                quest =  new JailDrainQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A drain is here at the bottom of the wall.";
                break;
            case "JailDoor":
                quest =  new JailDoorQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "The door to the cell.";
                break;
            case "JailBottle":
                quest =  new JailBottleQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A bottle lies just outside the fence.";
                break;
            case "JailFortGate":
                quest =  new JailFortGateQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "The main door to the fort.";
                break;
            case "JailGallows":
                quest =  new JailGallowsQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "Gallows for prisoners to be executed.";
                break;
            case "JailYardEnter":
                quest =  new JailYardDoorQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "Door to the Jail.";
                break;
            case "JailYardExit":
                quest =  new JailYardDoorQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "Door to the Jail.";
                break;
            case "JailTable":
                quest =  new JailTableQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A table sits here.";
                break;
            case "MurderInspector":
                {
                    quest =  new MurderInspectorQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/Sheriff.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "MurderSmith":
                {
                    quest =  new MurderSmithQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/BlackSmith.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "MurderInnKeeper":
                {
                    quest =  new MurderInnKeeperQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/ShopKeeper.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "MurderBody":
                {
                    quest =  new MurderBodyQuest(stateManager, holder);
                    ((Interactable) holder).contactMessage = "A dead body lies on the floor.";
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/Body.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Interactable) holder).model.setMaterial(mat);
                    break;
                }
            case "MurderWell":
                quest =  new MurderWellQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A well in the middle of town.";
                break;
            case "MurderInnKeepersTable":
                quest =  new MurderInnKeepersTableQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A table sits here.";
                break;
            case "MurderInspectorsTable":
                quest =  new MurderInspectorsTableQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A table sits here.";
                break;
            case "MurderCrate":
                quest =  new MurderCrateQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A crate sits here.";
                break;
            case "MurderBottle":
                quest =  new MurderBottleQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A bottle sits here on the counter.";
                break;
            case "MurderAxe":
                quest =  new MurderAxeQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A block for chopping wood.";
                break;
            case "Boat":
                quest =  new BoatQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A boat floats by the dock";
                break;
            case "BoatFarmer":
                {
                    quest =  new BoatFarmerQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/CheckeredShirt.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "BoatGuard":
                {
                    quest =  new BoatGuardQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/Suspenders.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "BoatAxe":
                quest =  new BoatAxeQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A table sits here...";
                break;
            case "BoatShovel":
                quest =  new BoatShovelQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A shovel leans against the wall.";
                break;
            case "BoatSaltBarrels":
                quest =  new BoatSaltBarrelsQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A few barrels for storage.";
                break;
            case "BoatFire":
                quest =  new BoatFireQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A fire burns in the fire place.";
                break;
            case "BoatWater":
                quest =  new BoatWaterQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "The ground seems softer here.";
                break;
            case "BoatCrates":
                quest =  new BoatCratesQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "Some crates for storage.";
                break;
            case "BoatGuardsTable":
                quest =  new BoatGuardsTableQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A table with a note on it...";
                break;
            case "BoatPoison":
                quest =  new BoatPoisonQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A bottle sits on the table...";
                break;
            case "Fire":
                quest =  new FireQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A fire burns brightly here...";
                break;
            case "FireTable":
                quest =  new FireTableQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A table sits here...";
                break;
            case "FireBucket":
                quest =  new FireBucketQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A bucket sits on the floor...";
                break;
            case "FireWell":
                quest =  new FireWellQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A well has been built here...";
                break;
            case "FireAxe":
                quest =  new FireAxeQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "An axe leans against the wall...";
                break;
            case "FirePaper":
                quest =  new FirePaperQuest(stateManager, holder);
                ((Interactable) holder).contactMessage = "A handwritten paper sits on the floor...";
                break;
            case "FireVelor":
                {
                    quest =  new FireVelorQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/CheckeredShirt.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "FireDraco":
                {
                    quest =  new FireDracoQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/RedShirt.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            case "FireAlexander":
                {
                    quest =  new FireAlexanderQuest(stateManager, holder);
                    Material mat   = new Material(stateManager.getApplication().getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
                    TextureKey key = new TextureKey("Models/Person/GreenShirt.png", true);
                    Texture tex    = stateManager.getApplication().getAssetManager().loadTexture(key);
                    mat.setTexture("ColorMap", tex);
                    mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
                    mat.setFloat("AlphaDiscardThreshold", .5f);
                    ((Npc) holder).model.setMaterial(mat);
                    break;
                }
            default:
                quest = null;
                break;
        }
        
        return quest;
    }
    
}
