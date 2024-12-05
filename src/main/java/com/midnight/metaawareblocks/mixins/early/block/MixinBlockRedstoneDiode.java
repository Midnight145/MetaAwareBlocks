package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.world.IBlockAccess;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(BlockRedstoneDiode.class)
public class MixinBlockRedstoneDiode {

    @WrapOperation(
        method = "func_149913_i",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockRedstoneDiode;func_149908_a(Lnet/minecraft/block/Block;)Z"))
    private boolean mixinFunc_149913_i(BlockRedstoneDiode instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) IBlockAccess world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.canProvidePower(world, x, y, z)
            : original.call(instance, block);
    }
}
