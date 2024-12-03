package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;

@Mixin(value = BlockRedstoneComparator.class)
public class MixinBlockRedstoneComparator {

    @Redirect(
        method = "getInputStrength",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean isNormalCube(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(name = "k1") int x, @Local(ordinal = 1, argsOnly = true) int y, @Local(name = "l1") int z) {
        return block.isNormalCube(world, x, y, z);
    }
}
