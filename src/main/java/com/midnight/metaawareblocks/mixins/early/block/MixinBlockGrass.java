package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;

@Mixin(value = BlockGrass.class, priority = 1001)
public class MixinBlockGrass {

    @Redirect(
        method = "func_149853_b",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean isNormalCube(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(name = "i1") int x, @Local(name = "j1") int y, @Local(name = "k1") int z) {
        return block.isNormalCube(world, x, y, z);
    }
}
