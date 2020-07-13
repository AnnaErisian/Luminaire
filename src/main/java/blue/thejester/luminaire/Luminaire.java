package blue.thejester.luminaire;

import blue.thejester.luminaire.core.CommonProxy;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Luminaire.MODID, name = Luminaire.NAME, version = Luminaire.VERSION)
public class Luminaire
{
    public static final String MODID = "luminaire";
    public static final String NAME = "Luminaire";
    public static final String VERSION = "1.0";

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="blue.thejester.luminaire.core.ClientOnlyProxy", serverSide="blue.thejester.luminaire.core.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }

    @EventHandler
    public void registerModels(ModelRegistryEvent event)
    {
        proxy.registerModels(event);
    }
}
