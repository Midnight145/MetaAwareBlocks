package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.world.IBlockAccess;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockWall.class)
public class MixinBlockWall {

    @WrapOperation(
        method = "canConnectWallTo",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;renderAsNormalBlock()Z"))
    private boolean mixinCanConnectWallTo(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) IBlockAccess world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.renderAsNormalBlock(world, x, y, z)
            : original.call(instance);
    }
}
