package com.midnight.metaawareblocks.mixins.early.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = ItemMonsterPlacer.class, priority = 1001)
public class MixinItemMonsterPlacer {

    @Redirect(method = "onItemUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I"))
    private int redirectOnItemUse(Block instance, @Local(ordinal = 0, argsOnly = true) World world,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getRenderType(world, x, y, z);
    }
}
