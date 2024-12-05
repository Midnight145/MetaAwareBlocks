package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockPortal.class)
public class MixinBlockPortal {

    @WrapOperation(
        method = "updateTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinUpdateTick(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(name = "x") int x, @Local(name = "l") int y,
        @Local(name = "z") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(world, x, y + 1, z) : original.call(instance);
    }
}
