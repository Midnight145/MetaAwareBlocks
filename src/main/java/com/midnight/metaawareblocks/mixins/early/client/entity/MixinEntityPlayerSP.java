package com.midnight.metaawareblocks.mixins.early.client.entity;

import net.minecraft.block.Block;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.authlib.GameProfile;

@Mixin(value = EntityPlayerSP.class, priority = 1001)
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer {

    public MixinEntityPlayerSP(World p_i45074_1_, GameProfile p_i45074_2_) {
        super(p_i45074_1_, p_i45074_2_);
    }

    @Redirect(
        method = "isBlockTranslucent",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean isBlockTranslucent(Block block, @Local(argsOnly = true, ordinal = 0) int x,
        @Local(argsOnly = true, ordinal = 1) int y, @Local(argsOnly = true, ordinal = 2) int z) {
        return block.isNormalCube(this.worldObj, x, y, z);
    }
}
