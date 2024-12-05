package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockTrapDoor.class)
public class MixinBlockTrapDoor {

    @WrapOperation(
        method = "canPlaceBlockOnSide",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockTrapDoor;func_150119_a(Lnet/minecraft/block/Block;)Z"))
    private boolean mixinFunc_150119_a(Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return block instanceof IMetaAware ? metaAware$func_150119_a(block, world, x, y, z) : original.call(block);
    }

    @WrapOperation(
        method = "onNeighborBlockChange",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;canProvidePower()Z"))
    private boolean mixinOnNeighborBlockChange(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.canProvidePower(world, x, y, z) : original.call(instance);
    }

    @Unique
    private boolean metaAware$func_150119_a(Block block, IBlockAccess world, int x, int y, int z) {
        return block.getMaterial()
            .isOpaque() && ((IMetaAware) block).renderAsNormalBlock(world, x, y, z) || block == Blocks.glowstone
            || block instanceof BlockSlab
            || block instanceof BlockStairs;
    }
}
