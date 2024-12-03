package com.midnight.metaawareblocks.mixins.early.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = EntityAIControlledByPlayer.class)
public class MixinEntityAIControlledByPlayer {

    @Shadow
    @Final
    private EntityLiving thisEntity;

    @Redirect(
        method = "updateTask",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/entity/ai/EntityAIControlledByPlayer;func_151498_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 0))
    private boolean redirectUpdateTask0(EntityAIControlledByPlayer instance, Block p_151498_1_,
        @Local(name = "i") int x, @Local(name = "j") int y, @Local(name = "k") int z) {
        return ((IMetaAware) p_151498_1_).getRenderType(this.thisEntity.worldObj, x, y, z) == 10
            || p_151498_1_ instanceof BlockSlab;
    }
}
