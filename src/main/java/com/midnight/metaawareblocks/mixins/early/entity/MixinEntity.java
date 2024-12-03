package com.midnight.metaawareblocks.mixins.early.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = Entity.class)
public class MixinEntity {

    @Shadow
    public World worldObj;

    @Redirect(
        method = "isEntityInsideOpaqueBlock",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinRedirect(Block block, @Local(name = "j") int x, @Local(name = "k") int y,
        @Local(name = "l") int z) {
        return block.isNormalCube(this.worldObj, x, y, z);
    }

    @Redirect(method = "moveEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I"))
    private int redirectMoveEntity(Block block, @Local(ordinal = 0, argsOnly = true) double x,
        @Local(ordinal = 1, argsOnly = true) double y, @Local(ordinal = 2, argsOnly = true) double z) {
        return ((IMetaAware) block).getRenderType(this.worldObj, (int) x, (int) y, (int) z);
    }
}
