package blue.thejester.luminaire.block;

import blue.thejester.luminaire.Luminaire;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ChainBlock extends Block {

    protected static final AxisAlignedBB AXIS_ALIGNED_BB = new AxisAlignedBB(0.4, 0, 0.4, 0.6, 1, 0.6);

    public ChainBlock(String name, Material mat, float hardness, float resistance, int miningLevel, String toolClass, SoundType sounds) {
        super(mat);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(toolClass, miningLevel);
        this.setSoundType(sounds);
        setTranslationKey(name);
        setRegistryName(new ResourceLocation(Luminaire.MODID, name));
        setCreativeTab(CreativeTabs.DECORATIONS);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AXIS_ALIGNED_BB;
    }

    public static Block[] makeChains() {
        return new Block[] {
                new ChainBlock("chain_iron", Material.IRON, 3f, 10f, 0, "pickaxe", SoundType.METAL),
                new ChainBlock("chain_gold", Material.IRON, 3f, 10f, 0, "pickaxe", SoundType.METAL),
                new ChainBlock("chain_obsidian", Material.IRON, 3f, 1200f, 0, "pickaxe", SoundType.METAL),
                new ChainBlock("chain_emerald", Material.IRON, 3f, 20f, 0, "pickaxe", SoundType.METAL),
                new ChainBlock("chain_diamond", Material.IRON, 3f, 20f, 0, "pickaxe", SoundType.METAL),
                new ChainBlock("chain_redstone", Material.IRON, 3f, 10f, 0, "pickaxe", SoundType.METAL),
                new ChainBlock("chain_bone", Material.IRON, 3f, 10f, 0, "pickaxe", SoundType.METAL)
        };
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @SuppressWarnings("deprecation")
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return getBoundingBox(blockState, worldIn, pos);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
}
