package blue.thejester.luminaire.block;

import blue.thejester.luminaire.Luminaire;
import net.minecraft.block.Block;
import svenhjol.charm.crafting.block.BlockLantern;

public class BlockLumiLantern extends BlockLantern {
    public BlockLumiLantern(String variant) {
        super(variant);
        this.setLightLevel(1);
    }

    @Override
    public String getModId() {
        return Luminaire.MODID;
    }

    public static Block[] makeLanterns() {
        return new Block[]{
                new BlockLumiLantern("lapis"),
                new BlockLumiLantern("granite"),
                new BlockLumiLantern("marble"),
                new BlockLumiLantern("lapis_marble"),
                new BlockLumiLantern("lapis_gold"),
                new BlockLumiLantern("midori"),
                new BlockLumiLantern("lapis_midori"),
                new BlockLumiLantern("lapis_granite"),
                new BlockLumiLantern("slate"),
                new BlockLumiLantern("lapis_slate")
        };
    }
}
