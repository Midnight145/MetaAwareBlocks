package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockRedstoneComparator.class)
public class MixinBlockRedstoneComparator {

    @WrapOperation(
        method = "getInputStrength",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinGetInputStrength(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(name = "k1") int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(name = "l1") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(world, x, y, z) : original.call(instance);
    }
}
