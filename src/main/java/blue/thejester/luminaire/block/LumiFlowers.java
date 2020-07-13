package blue.thejester.luminaire.block;

import biomesoplenty.api.enums.IPagedVariants;
import biomesoplenty.core.BiomesOPlenty;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum LumiFlowers implements IStringSerializable, IPagedVariants {
    DANDELION, 
    POPPY,
    ORCHID,
    ALLIUM,
    HOUSTONIA,
    RED_TULIP, 
    ORANGE_TULIP, 
    WHITE_TULIP, 
    PINK_TULIP,
    DAISY,
    CLOVER, 
    SWAMPFLOWER, 
    GLOWFLOWER,
    BLUE_HYDRANGEA,
    ORANGE_COSMOS, 
    PINK_DAFFODIL, 
    WILDFLOWER, 
    VIOLET, 
    WHITE_ANEMONE, 
    PINK_HIBISCUS, 
    LILY_OF_THE_VALLEY,
    LAVENDER,
    GOLDENROD, 
    BLUEBELLS, 
    ICY_IRIS, 
    ROSE, 
    BROMELIAD, 
    MINERS_DELIGHT;

    public static String getModId(LumiFlowers state) {
        switch (state) {
            case DANDELION:
            case POPPY:
            case ORCHID:
            case ALLIUM:
            case HOUSTONIA:
            case RED_TULIP:
            case ORANGE_TULIP:
            case WHITE_TULIP:
            case PINK_TULIP:
            case DAISY:
                return "minecraft";
            default:
                return BiomesOPlenty.MOD_ID;
        }
    }

    @Override
    public String getName() {
        return this.name().toLowerCase(Locale.ENGLISH);
    }
    @Override
    public String toString()
    {
        return this.getName();
    }
}
