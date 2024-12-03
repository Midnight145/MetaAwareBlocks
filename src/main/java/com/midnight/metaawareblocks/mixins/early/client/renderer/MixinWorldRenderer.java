package com.midnight.metaawareblocks.mixins.early.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = WorldRenderer.class, priority = 1001)
public class MixinWorldRenderer {

    @Shadow
    public World worldObj;

    @Redirect(
        method = "updateRenderer",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I"))
    private int redirectUpdateRenderer(Block block, @Local(name = "j3") int x, @Local(name = "l2") int y,
        @Local(name = "i3") int z) {
        return ((IMetaAware) block).getRenderType(this.worldObj, x, y, z);
    }
}
