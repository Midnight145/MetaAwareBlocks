package com.midnight.metaawareblocks.mixins.early.entity.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;

@Mixin(value = EntityMinecart.class, priority = 1001)
public abstract class MixinEntityMinecart extends Entity {

    public MixinEntityMinecart(World worldIn) {
        super(worldIn);
    }

    @Redirect(
        method = "func_145821_a(IIIDDLnet/minecraft/block/Block;I)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 0))
    private boolean mixinRedirect1(Block block, @Local(name = "p_145821_1_") int x, @Local(name = "p_145821_2_") int y,
        @Local(name = "p_145821_3_") int z) {
        return block.isNormalCube(this.worldObj, x - 1, y, z);
    }

    @Redirect(
        method = "func_145821_a(IIIDDLnet/minecraft/block/Block;I)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 1))
    private boolean mixinRedirect2(Block block, @Local(name = "p_145821_1_") int x, @Local(name = "p_145821_2_") int y,
        @Local(name = "p_145821_3_") int z) {
        return block.isNormalCube(this.worldObj, x + 1, y, z);
    }

    @Redirect(
        method = "func_145821_a(IIIDDLnet/minecraft/block/Block;I)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 2))
    private boolean mixinRedirect3(Block block, @Local(name = "p_145821_1_") int x, @Local(name = "p_145821_2_") int y,
        @Local(name = "p_145821_3_") int z) {
        return block.isNormalCube(this.worldObj, x, y, z - 1);
    }

    @Redirect(
        method = "func_145821_a(IIIDDLnet/minecraft/block/Block;I)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 3))
    private boolean mixinRedirect4(Block block, @Local(name = "p_145821_1_") int x, @Local(name = "p_145821_2_") int y,
        @Local(name = "p_145821_3_") int z) {
        return block.isNormalCube(this.worldObj, x, y, z + 1);
    }
}
