package blue.thejester.luminaire.block;

/**
 * Code here mostly from Biomes o Plenty
 */

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.block.BlockBOPGrass;
import blue.thejester.luminaire.Luminaire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlowFlower extends BlockBush {
    private final LumiFlowers flowerType;

    public static Block[] makeFlowers() {
        return new Block[] {
                new BlockGlowFlower("gf_dandelion", LumiFlowers.DANDELION),
                new BlockGlowFlower("gf_poppy", LumiFlowers.POPPY),
                new BlockGlowFlower("gf_orchid", LumiFlowers.ORCHID),
                new BlockGlowFlower("gf_allium", LumiFlowers.ALLIUM),
                new BlockGlowFlower("gf_houstonia", LumiFlowers.HOUSTONIA),
                new BlockGlowFlower("gf_red_tulip", LumiFlowers.RED_TULIP),
                new BlockGlowFlower("gf_orange_tulip", LumiFlowers.ORANGE_TULIP),
                new BlockGlowFlower("gf_white_tulip", LumiFlowers.WHITE_TULIP),
                new BlockGlowFlower("gf_pink_tulip", LumiFlowers.PINK_TULIP),
                new BlockGlowFlower("gf_daisy", LumiFlowers.DAISY),
                new BlockGlowFlower("gf_clover", LumiFlowers.CLOVER),
                new BlockGlowFlower("gf_swampflower", LumiFlowers.SWAMPFLOWER),
                new BlockGlowFlower("gf_glowflower", LumiFlowers.GLOWFLOWER),
                new BlockGlowFlower("gf_blue_hydrangea", LumiFlowers.BLUE_HYDRANGEA),
                new BlockGlowFlower("gf_orange_cosmos", LumiFlowers.ORANGE_COSMOS),
                new BlockGlowFlower("gf_pink_daffodil", LumiFlowers.PINK_DAFFODIL),
                new BlockGlowFlower("gf_wildflower", LumiFlowers.WILDFLOWER),
                new BlockGlowFlower("gf_violet", LumiFlowers.VIOLET),
                new BlockGlowFlower("gf_white_anemone", LumiFlowers.WHITE_ANEMONE),
                new BlockGlowFlower("gf_pink_hibiscus", LumiFlowers.PINK_HIBISCUS),
                new BlockGlowFlower("gf_lily_of_the_valley", LumiFlowers.LILY_OF_THE_VALLEY),
                new BlockGlowFlower("gf_lavender", LumiFlowers.LAVENDER),
                new BlockGlowFlower("gf_goldenrod", LumiFlowers.GOLDENROD),
                new BlockGlowFlower("gf_bluebells", LumiFlowers.BLUEBELLS),
                new BlockGlowFlower("gf_icy_iris", LumiFlowers.ICY_IRIS),
                new BlockGlowFlower("gf_rose", LumiFlowers.ROSE),
                new BlockGlowFlower("gf_bromeliad", LumiFlowers.BROMELIAD),
                new BlockGlowFlower("gf_miners_delight", LumiFlowers.MINERS_DELIGHT)
        };
    }

    public BlockGlowFlower(String name, LumiFlowers flowerType)
    {
        super(Material.PLANTS);
        this.flowerType = flowerType;
        this.setTickRandomly(true);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        setLightLevel(1);
        setTranslationKey(name);
        setRegistryName(new ResourceLocation(Luminaire.MODID, name));
        setCreativeTab(CreativeTabs.DECORATIONS);
        this.setDefaultState( this.blockState.getBaseState() );
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && canBlockStay(worldIn, pos, getDefaultState());
    }

    // different variants have different sizes
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        LumiFlowers flower = (LumiFlowers) flowerType;
        switch (flower)
        {
            case CLOVER:
                return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.09375D, 0.9375D);
            case SWAMPFLOWER: case VIOLET: case WHITE_ANEMONE: case BLUEBELLS:
            return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.4000000357627869D, 0.9375D);
            case BROMELIAD: case PINK_HIBISCUS: case LILY_OF_THE_VALLEY: case LAVENDER:
            return new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
            default:
                return new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);
        }
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        switch (flowerType)
        {
            case GOLDENROD:
                return MapColor.YELLOW;

            case LAVENDER:
                return MapColor.MAGENTA;

            default:
                return this.blockMapColor;
        }
    }

    // which types of flower can live on which types of block
    @Override
    public boolean canBlockStay(World world, BlockPos pos, IBlockState state)
    {
        IBlockState groundState = world.getBlockState(pos.down());
        Block groundBlock = groundState.getBlock();

        boolean onFertile = (groundBlock == Blocks.DIRT || groundBlock == Blocks.FARMLAND || groundBlock == BOPBlocks.farmland_0 || groundBlock == BOPBlocks.farmland_1 || groundBlock == BOPBlocks.dirt || groundBlock == Blocks.GRASS);
        boolean onDry = (groundBlock == Blocks.HARDENED_CLAY || groundBlock == BOPBlocks.sand || groundBlock == Blocks.SAND || groundBlock == BOPBlocks.white_sand);
        boolean onNetherrack = (groundBlock == Blocks.NETHERRACK);
        boolean onStone = (groundBlock == Blocks.STONE);
        boolean onDriedSand = (groundBlock == BOPBlocks.dried_sand);
        boolean onSpectralMoss = false;

        if (groundBlock instanceof BlockBOPGrass)
        {
            switch ((BlockBOPGrass.BOPGrassType) groundState.getValue(BlockBOPGrass.VARIANT))
            {

                case SPECTRAL_MOSS:
                    onSpectralMoss = true;
                    break;
                case OVERGROWN_NETHERRACK:
                    onFertile = true;
                    onNetherrack = true;
                    break;
                case MYCELIAL_NETHERRACK:
                    onNetherrack = true;
                    break;
                case LOAMY: case SANDY: case SILTY: case ORIGIN: default:
                onFertile = true;
                break;
            }
        }

        switch (flowerType)
        {
            case BROMELIAD:
                return onDry;
            case MINERS_DELIGHT:
                return onStone;
            default:
                return onFertile;
        }

    }


    // not opaque
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    // not full cube
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    //decoration should be randomly offset by default
    @Override
    @SideOnly(Side.CLIENT)
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing)
    {
        return BlockFaceShape.UNDEFINED;
    }
}
