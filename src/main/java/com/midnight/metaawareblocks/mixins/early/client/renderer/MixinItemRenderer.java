package com.midnight.metaawareblocks.mixins.early.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;

@Mixin(value = ItemRenderer.class)
public class MixinItemRenderer {

    @Shadow
    private Minecraft mc;

    @Redirect(
        method = "renderOverlays",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 0))
    private boolean doFirstRedirect(Block block, @Local(name = "i") int x, @Local(name = "j") int y,
        @Local(name = "k") int z) {
        return block.isNormalCube(this.mc.theWorld, x, y, z);
    }

    @Redirect(
        method = "renderOverlays",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 1))
    private boolean doSecondRedirect(Block block, @Local(name = "i1") int x, @Local(name = "j1") int y,
        @Local(name = "k1") int z) {
        return block.isNormalCube(this.mc.theWorld, x, y, z);
    }
}
