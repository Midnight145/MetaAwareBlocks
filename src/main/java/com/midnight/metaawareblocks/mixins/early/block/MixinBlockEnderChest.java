package com.midnight.metaawareblocks.mixins.early.block;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockEnderChest.class)
public class MixinBlockEnderChest {
    @Redirect(method="onBlockActivated", at= @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean isNormalCube(Block block, @Local(ordinal=0, argsOnly = true) World world, @Local(ordinal=0, argsOnly = true) int x, @Local(ordinal=1, argsOnly = true) int y, @Local(ordinal=2, argsOnly = true) int z) {
        return block.isNormalCube(world, x, y, z);
    }
}
