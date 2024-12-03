package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;

@Mixin(value = BlockPortal.class)
public class MixinBlockPortal {

    @Redirect(method = "updateTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean isNormalCube(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(name = "x") int x, @Local(name = "l") int y, @Local(name = "z") int z) {
        return block.isNormalCube(world, x, y + 1, z);
    }
}
