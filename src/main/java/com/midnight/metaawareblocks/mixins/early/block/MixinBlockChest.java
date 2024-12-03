package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.BlockChest;
import net.minecraft.world.IBlockAccess;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(BlockChest.class)
public class MixinBlockChest {

    @Redirect(
        method = "isProvidingWeakPower",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockChest;canProvidePower()Z"))
    private boolean redirectCanProvidePower(BlockChest chest, @Local(ordinal = 0, argsOnly = true) IBlockAccess world,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) chest).canProvidePower(world, x, y, z);
    }
}
