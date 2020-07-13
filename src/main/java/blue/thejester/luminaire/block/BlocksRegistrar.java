package blue.thejester.luminaire.block;

import biomesoplenty.common.block.IBOPBlock;
import biomesoplenty.common.util.block.BlockStateUtils;
import blue.thejester.luminaire.Luminaire;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = Luminaire.MODID)
public class BlocksRegistrar {

    public static Block[] basalt_torch;
    public static Block[] bone_torch;
    public static Block[] colored_flame;
    public static Block[] jasper_torch;
    public static Block[] marble_torch;
    public static Block[] slate_torch;

    public static Block[] bone_flame_chalice;
    public static Block[] bone_orb_chalice;
    public static Block[] gold_flame_chalice;
    public static Block[] gold_orb_chalice;
    public static Block[] shadow_flame_chalice;
    public static Block[] shadow_orb_chalice;
    public static Block[] silver_flame_chalice;
    public static Block[] silver_orb_chalice;

    public static Block[] lanterns;
    public static Block[] lantern_blocks;
    public static Block[] chains;

    public static Block[] flowers;

    public static ArrayList<Block[]> blockSets = new ArrayList<>();

    public static void init() {
        basalt_torch = add(ModTorch.makeTorches("basalt_torch"));
        bone_torch = add(ModTorch.makeTorches("bone_torch"));
        colored_flame = add(ModTorch.makeTorchesSansOrange("colored_flame", true, 0, 0));
        jasper_torch = add(ModTorch.makeTorches("jasper_torch"));
        marble_torch = add(ModTorch.makeTorches("marble_torch"));
        slate_torch = add(ModTorch.makeTorches("slate_torch"));

        bone_flame_chalice = add(ModTorch.makeTorches("bone_flame_chalice", 0.8f, -0.5f));
        bone_orb_chalice = add(ModTorchHangable.makeTorches("bone_orb_chalice", false));
        gold_flame_chalice = add(ModTorch.makeTorches("gold_flame_chalice", 0.45f, -0.5f));
        gold_orb_chalice = add(ModTorchHangable.makeTorches("gold_orb_chalice", false));
        shadow_flame_chalice = add(ModTorch.makeTorches("shadow_flame_chalice", 0.45f, -0.5f));
        shadow_orb_chalice = add(ModTorchHangable.makeTorches("shadow_orb_chalice", false));
        silver_flame_chalice = add(ModTorch.makeTorches("silver_flame_chalice", 0.45f, -0.5f));
        silver_orb_chalice = add(ModTorchHangable.makeTorches("silver_orb_chalice", false));

        lanterns = BlockLumiLantern.makeLanterns();

        lantern_blocks = add(LanternBlock.makeLanternBlocks());

        chains = add(ChainBlock.makeChains());

        flowers = add(BlockGlowFlower.makeFlowers());
    }

    @SubscribeEvent
    public static void onBlockRegistry(RegistryEvent.Register<Block> e) {
        for(Block[] blocks : blockSets) {
            e.getRegistry().registerAll(blocks);
        }
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> e) {
        for(Block[] blocks : blockSets) {
            registerItemBlock(e, blocks);
        }
    }

    private static void registerItemBlock(RegistryEvent.Register<Item> e, Block... blocks) {
        for(Block b : blocks) {
            e.getRegistry().registerAll(new ItemBlock(b).setRegistryName(b.getRegistryName()));
            if(b instanceof IHasOreDict) {
                OreDictionary.registerOre(((IHasOreDict) b).getOreName(), b);
            }
        }
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        for(Block[] blocks : blockSets) {
            registerRender(getItemsFromBlock(blocks));
        }
    }

    private static Item[] getItemsFromBlock(Block... blocks) {
        List<Item> list = new ArrayList<>(blocks.length);
        for(Block block : blocks) {
            list.add(Item.getItemFromBlock(block));
        }
        return list.toArray(new Item[0]);
    }

    public static void registerRender(Item... items) {
        for(Item item : items) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

    private static Block[] add(Block[] blocks) {
        blockSets.add(blocks);
        return blocks;
    }

    private static Block[] add(Block block) {
        return add(new Block[]{block});
    }
}
