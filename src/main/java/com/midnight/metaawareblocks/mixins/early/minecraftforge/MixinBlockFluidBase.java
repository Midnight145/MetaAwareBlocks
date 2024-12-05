package com.midnight.metaawareblocks.mixins.early.minecraftforge;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidBase;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockFluidBase.class)
public class MixinBlockFluidBase {

    @WrapOperation(
        method = "shouldSideBeRendered",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z"))
    private boolean mixinShouldSideBeRendered(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) IBlockAccess world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isOpaqueCube(world, x, y, z) : original.call(instance);
    }
}
