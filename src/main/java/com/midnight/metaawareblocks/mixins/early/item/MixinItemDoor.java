package com.midnight.metaawareblocks.mixins.early.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = ItemDoor.class)
public class MixinItemDoor {

    @WrapOperation(
        method = "placeDoorBlock",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private static boolean mixinPlaceDoorBlock(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(world, x, y, z) : original.call(instance);
    }
}
