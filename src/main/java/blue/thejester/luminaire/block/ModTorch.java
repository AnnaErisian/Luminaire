package blue.thejester.luminaire.block;

import blue.thejester.luminaire.Luminaire;
import blue.thejester.luminaire.client.ParticleHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModTorch extends BlockTorch implements IHasOreDict {

    protected EnumDyeColor flameColor = EnumDyeColor.ORANGE;

    protected float yFlameOffset = 0;
    protected float upFlameOffset = 0;
    private boolean doParticles;
    private String orename;

    public ModTorch(String name) {
        super();
        this.setHardness(0);
        this.setResistance(0);
        this.setSoundType(SoundType.WOOD);
        this.setLightLevel(1);
        setTranslationKey(name);
        setRegistryName(new ResourceLocation(Luminaire.MODID, name));
        setCreativeTab(CreativeTabs.DECORATIONS);
    }

    public ModTorch(String name, EnumDyeColor color) {
        this(name);
        this.flameColor = color;
    }

    public static Block[] makeTorches(String name, float yFlameOffset, float upFlameOffset) {
        return makeTorches(name, true, yFlameOffset, upFlameOffset);
    }

    public static Block[] makeTorches(String name) {
        return makeTorches(name, true, 0, 0);
    }

    public static Block[] makeTorches(String name, boolean doParticles) {
        return makeTorches(name, doParticles, 0, 0);
    }

    public static Block[] makeTorches(String name, boolean doParticles, float yFlameOffset, float upFlameOffset) {
        List<Block> blocks = new ArrayList<Block>(16);
        for(EnumDyeColor color : EnumDyeColor.values()) {
            ModTorch torch = new ModTorch(name + "_" + color.getName(), color);
            torch.yFlameOffset = yFlameOffset;
            torch.upFlameOffset = upFlameOffset;
            torch.setTickRandomly(doParticles);
            torch.doParticles = doParticles;
            blocks.add(torch);
            torch.orename = "lumi_" + name;
        }
        return blocks.toArray(new Block[0]);
    }

    public static Block[] makeTorchesSansOrange(String name, boolean doParticles, float yFlameOffset, float upFlameOffset) {
        List<Block> blocks = new ArrayList<Block>(15);
        for(EnumDyeColor color : EnumDyeColor.values()) {
            if(color != EnumDyeColor.ORANGE) {
                ModTorch torch = new ModTorch(name + "_" + color.getName(), color);
                torch.yFlameOffset = yFlameOffset;
                torch.upFlameOffset = upFlameOffset;
                torch.setTickRandomly(doParticles);
                torch.doParticles = doParticles;
                blocks.add(torch);
                torch.orename = "lumi_" + name;
            }
        }
        return blocks.toArray(new Block[0]);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if(!doParticles) return;

        EnumFacing enumfacing = (EnumFacing)stateIn.getValue(FACING);
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.7D + upFlameOffset;
        double d2 = (double)pos.getZ() + 0.5D;

        if (enumfacing.getAxis().isHorizontal())
        {
            EnumFacing enumfacing1 = enumfacing.getOpposite();
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + 0.27D * (double)enumfacing1.getXOffset(), d1 + 0.22D, d2 + 0.27D * (double)enumfacing1.getZOffset(), 0.0D, 0.0D, 0.0D);
            ParticleHandler.spawnColoredFlame(worldIn,d0 + (0.27D - yFlameOffset * 0.7D) * (double)enumfacing1.getXOffset(), d1 + 0.22D + yFlameOffset, d2 + (0.27D - yFlameOffset * 0.7D) * (double)enumfacing1.getZOffset(), 0.0D, 0.0D, 0.0D, flameColor);
        }
        else
        {
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
            ParticleHandler.spawnColoredFlame(worldIn, d0, d1 + yFlameOffset, d2, 0.0D, 0.0D, 0.0D, flameColor);
        }
    }

    @Override
    public String getOreName() {
        return orename;
    }
}
