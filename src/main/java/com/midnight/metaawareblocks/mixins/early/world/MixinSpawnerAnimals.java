package com.midnight.metaawareblocks.mixins.early.world;

import net.minecraft.block.Block;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = SpawnerAnimals.class)
public class MixinSpawnerAnimals {

    @WrapOperation(
        method = "findChunksForSpawning",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinFindChunksForSpawning(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) WorldServer world, @Local(name = "j1") int x, @Local(name = "k1") int y,
        @Local(name = "l1") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(world, x, y, z) : original.call(instance);
    }

    @WrapOperation(
        method = "canCreatureTypeSpawnAtLocation",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private static boolean mixinCanCreatureTypeSpawnAtLocation(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(world, x, y, z) : original.call(instance);
    }
}
