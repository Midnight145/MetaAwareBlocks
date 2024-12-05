package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockRedstoneOre.class)
public class MixinBlockRedstoneOre {

    @WrapOperation(
        method = "func_150186_m",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 0))
    private boolean redirectIsOpaqueCube0(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isOpaqueCube(world, x, y + 1, z) : original.call(instance);
    }

    @WrapOperation(
        method = "func_150186_m",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 1))
    private boolean redirectIsOpaqueCube1(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isOpaqueCube(world, x, y - 1, z) : original.call(instance);
    }

    @WrapOperation(
        method = "func_150186_m",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 2))
    private boolean redirectIsOpaqueCube2(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isOpaqueCube(world, x, y, z + 1) : original.call(instance);
    }

    @WrapOperation(
        method = "func_150186_m",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 3))
    private boolean redirectIsOpaqueCube3(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isOpaqueCube(world, x, y, z - 1) : original.call(instance);
    }

    @WrapOperation(
        method = "func_150186_m",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 4))
    private boolean redirectIsOpaqueCube4(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isOpaqueCube(world, x + 1, y, z) : original.call(instance);
    }

    @WrapOperation(
        method = "func_150186_m",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 5))
    private boolean redirectIsOpaqueCube5(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isOpaqueCube(world, x - 1, y, z) : original.call(instance);
    }

}
