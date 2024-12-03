package com.midnight.metaawareblocks.mixins.early.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = EntityLeashKnot.class)
public abstract class MixinEntityLeashKnot extends EntityHanging {

    public MixinEntityLeashKnot(World worldIn) {
        super(worldIn);
    }

    @Redirect(
        method = "onValidSurface",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I"))
    private int redirectOnValidSurface(Block block) {
        return ((IMetaAware) block)
            .getRenderType(this.worldObj, this.field_146063_b, this.field_146064_c, this.field_146062_d);
    }
}
