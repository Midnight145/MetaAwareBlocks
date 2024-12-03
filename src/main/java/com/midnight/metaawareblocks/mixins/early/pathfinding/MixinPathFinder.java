package com.midnight.metaawareblocks.mixins.early.pathfinding;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathFinder;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = PathFinder.class)
public class MixinPathFinder {

    @Redirect(
        method = "func_82565_a",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I", ordinal = 0))
    private static int getRenderType0(Block block, @Local(ordinal = 0, argsOnly = true) Entity entity,
        @Local(name = "l") int x, @Local(name = "i1") int y, @Local(name = "j1") int z) {
        return ((IMetaAware) block).getRenderType(entity.worldObj, x, y, z);
    }

    @Redirect(
        method = "func_82565_a",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I", ordinal = 1))
    private static int getRenderType1(Block block, @Local(ordinal = 0, argsOnly = true) Entity entity,
        @Local(name = "l") int x, @Local(name = "i1") int y, @Local(name = "j1") int z) {
        return ((IMetaAware) block).getRenderType(entity.worldObj, x, y, z);
    }

    @Redirect(
        method = "func_82565_a",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I", ordinal = 2))
    private static int getRenderType2(Block block, @Local(ordinal = 0, argsOnly = true) Entity entity,
        @Local(name = "j2") int x, @Local(name = "l1") int y, @Local(name = "i2") int z) {
        return ((IMetaAware) block).getRenderType(entity.worldObj, x, y, z);
    }

    @Redirect(
        method = "func_82565_a",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I", ordinal = 3))
    private static int getRenderType3(Block block, @Local(ordinal = 0, argsOnly = true) Entity entity,
        @Local(name = "j2") int x, @Local(name = "l1") int y, @Local(name = "i2") int z) {
        return ((IMetaAware) block).getRenderType(entity.worldObj, x, y - 1, z);
    }
}
