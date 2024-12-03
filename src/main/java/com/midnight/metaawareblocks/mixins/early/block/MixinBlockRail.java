package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(BlockRail.class)
public class MixinBlockRail {

    @Redirect(
        method = "func_150048_a",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;canProvidePower()Z"))
    private boolean redirectCanProvidePower(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(ordinal = 1, argsOnly = true) int x, @Local(ordinal = 2, argsOnly = true) int y,
        @Local(ordinal = 3, argsOnly = true) int z) {
        return ((IMetaAware) block).canProvidePower(world, x, y, z);
    }
}
