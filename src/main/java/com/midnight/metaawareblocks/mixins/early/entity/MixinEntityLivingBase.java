package com.midnight.metaawareblocks.mixins.early.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = EntityLivingBase.class)
public abstract class MixinEntityLivingBase extends Entity {

    public MixinEntityLivingBase(World p_i1595_1_) {
        super(p_i1595_1_);
    }

    @Redirect(
        method = "updateFallState",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I"))
    private int redirectUpdateFallState(Block block, @Local(name = "i") int x, @Local(name = "j") int y,
        @Local(name = "k") int z) {
        return ((IMetaAware) block).getRenderType(this.worldObj, x, y, z);
    }
}
