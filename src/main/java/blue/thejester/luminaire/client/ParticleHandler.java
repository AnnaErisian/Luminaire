package blue.thejester.luminaire.client;

import blue.thejester.luminaire.Luminaire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ParticleHandler {

    private static Minecraft mc = Minecraft.getMinecraft();

    public static Particle spawnColoredFlame(World worldIn, double posX, double posY, double posZ, double xVel, double yVel, double zVel, EnumDyeColor color) {
        if(spawnPatricleChecks(posX, posY, posZ)) {
            Particle particle = new ParticleColoredFlame(worldIn, posX, posY, posZ, xVel, yVel, zVel, color);
            mc.effectRenderer.addEffect(particle);
            return particle;
        }
        return null;
    }


        public static boolean spawnPatricleChecks(double posX, double posY, double posZ) {
        if (mc != null && mc.getRenderViewEntity() != null && mc.effectRenderer != null)
        {
            int particleSetting = mc.gameSettings.particleSetting;

            if (particleSetting == 1 && mc.world.rand.nextInt(3) == 0)
            {
                particleSetting = 2;
            }

            double var15 = mc.getRenderViewEntity().posX - posX;
            double var17 = mc.getRenderViewEntity().posY - posY;
            double var19 = mc.getRenderViewEntity().posZ - posZ;
            double var22 = 16.0D;

            return !(var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22) && particleSetting <= 1;
        }
        return false;
    }
}
