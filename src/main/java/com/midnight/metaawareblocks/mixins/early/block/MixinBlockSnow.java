package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSnow;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockSnow.class, priority = 1001)
public class MixinBlockSnow {

    @Redirect(
        method = "canPlaceBlockAt",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z"))
    private boolean redirectCanPlaceBlockAt(Block block, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(world, x, y, z);
    }
}
