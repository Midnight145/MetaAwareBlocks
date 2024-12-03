package com.midnight.metaawareblocks.mixins.early.world;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SpawnerAnimals.class)
public class MixinSpawnerAnimals {
    @Redirect(method="findChunksForSpawning", at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinFindChunksForSpawning(Block block, @Local(ordinal = 0, argsOnly = true) WorldServer world, @Local(name="j1") int x, @Local(name="k1") int y, @Local(name="l1") int z) {
        return block.isNormalCube(world, x, y, z);
    }

    @Redirect(method = "canCreatureTypeSpawnAtLocation", at = @At(value="INVOKE",target="Lnet/minecraft/block/Block;isNormalCube()Z"))
    private static boolean mixinCanCreatureTypeSpawnAtLocation(Block block, @Local(ordinal=0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return block.isNormalCube(world, x, y, z);
    }
}
