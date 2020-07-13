package blue.thejester.luminaire.core;

import blue.thejester.luminaire.block.BlocksRegistrar;
import net.minecraftforge.client.event.ModelRegistryEvent;

public class CommonProxy {


    /**
     * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
     */
    public void preInit() {
        BlocksRegistrar.init();
    }

    /**
     * Do your mod setup. Build whatever data structures you care about. Register recipes,
     * send FMLInterModComms messages to other mods.
     */
    public void init() {
    }

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    public void postInit() {
    }

    /**
     * is this a dedicated server?
     *
     * @return true if this is a dedicated server, false otherwise
     */
    public boolean isDedicatedServer() {
        return true;
    }

    public void registerModels(ModelRegistryEvent event) {

    }
}
