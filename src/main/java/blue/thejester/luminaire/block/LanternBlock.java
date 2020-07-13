package blue.thejester.luminaire.block;

import blue.thejester.luminaire.Luminaire;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class LanternBlock extends Block {
    public LanternBlock(String name, Material mat, float hardness, float resistance, int miningLevel, String toolClass, SoundType sounds) {
        super(mat);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass, miningLevel);
        this.setSoundType(sounds);
        this.setLightLevel(1);
        setTranslationKey(name);
        setRegistryName(new ResourceLocation(Luminaire.MODID, name));
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public static Block[] makeLanternBlocks() {
        return new Block[] {
                new LanternBlock("acacia_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("ethereal_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("magic_planks_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("red_sandstone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("andesite_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("eucalyptus_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("mahogany_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("redwood_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("betweenstone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("fir_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("mangrove_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("runestone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("birch_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("granite_lantern_block", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("marble_lantern_block", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("sacred_oak_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("black_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("hellbark_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("midori_lantern_block", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("sandstone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("blue_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("holystone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("oak_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("slate_lantern_block", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("cherry_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("jacaranda_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("orange_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("spruce_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("cyan_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("jasper_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("palm_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("stone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("dark_oak_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("jungle_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("permafrost_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("umbran_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("diorite_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("lavender_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("pine_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("white_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("ebony_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("limestone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("pitstone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("willow_lantern", Material.WOOD, 2f, 4.5f, 0, "axe", SoundType.WOOD),
                new LanternBlock("endstone_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("magenta_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE),
                new LanternBlock("red_lantern", Material.ROCK, 2f, 8f, 0, "pickaxe", SoundType.STONE)
        };
    }
}
