package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockPistonBase.class)
public class MixinBlockPistonBase {

    @WrapOperation(
        method = "onBlockEventReceived",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMobilityFlag()I"))
    private int mixinOnBlockEventReceived(Block instance, Operation<Integer> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(name = "j1") int x, @Local(name = "k1") int y,
        @Local(name = "l1") int z) {
        return instance instanceof IMetaAware aware ? aware.getMobilityFlag(world, x, y, z) : original.call(instance);
    }

    @WrapOperation(
        method = "canPushBlock",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMobilityFlag()I"))
    private static int mixinCanPushBlock(Block instance, Operation<Integer> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.getMobilityFlag(world, x, y, z) : original.call(instance);
    }

    @WrapOperation(
        method = "canExtend",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMobilityFlag()I"))
    private static int mixinCanExtend(Block instance, Operation<Integer> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(name = "j1") int x, @Local(name = "k1") int y,
        @Local(name = "l1") int z) {
        return instance instanceof IMetaAware aware ? aware.getMobilityFlag(world, x, y, z) : original.call(instance);
    }

    @WrapOperation(
        method = "tryExtend",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getMobilityFlag()I"))
    private int mixinTryExtend(Block instance, Operation<Integer> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(name = "j1") int x, @Local(name = "k1") int y,
        @Local(name = "l1") int z) {
        return instance instanceof IMetaAware aware ? aware.getMobilityFlag(world, x, y, z) : original.call(instance);
    }
}
