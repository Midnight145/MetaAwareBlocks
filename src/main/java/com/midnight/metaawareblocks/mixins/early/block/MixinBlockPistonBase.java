package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockPistonBase.class)
public class MixinBlockPistonBase {

    @Redirect(
        method = "onBlockEventReceived",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMobilityFlag()I"))
    private int redirectGetMobilityFlag(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(name = "j1") int x, @Local(name = "k1") int y, @Local(name = "l1") int z) {
        return ((IMetaAware) block).getMobilityFlag(world, x, y, z);
    }

    @Redirect(
        method = "canPushBlock",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMobilityFlag()I"))
    private static int getMobilityFlag(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).getMobilityFlag(world, x, y, z);
    }

    @Redirect(
        method = "canExtend",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMobilityFlag()I"))
    private static int redirectCanExtend(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(name = "j1") int x, @Local(name = "k1") int y, @Local(name = "l1") int z) {
        return ((IMetaAware) block).getMobilityFlag(world, x, y, z);
    }

    @Redirect(
        method = "tryExtend",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMobilityFlag()I"))
    private int redirectTryExtend(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(name = "j1") int x, @Local(name = "k1") int y, @Local(name = "l1") int z) {
        return ((IMetaAware) block).getMobilityFlag(world, x, y, z);
    }
}
