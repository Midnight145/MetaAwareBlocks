package com.midnight.metaawareblocks.mixins.early.entity.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = EntityBat.class)
public abstract class MixinEntityBat extends Entity {

    public MixinEntityBat(World worldIn) {
        super(worldIn);
    }

    @WrapOperation(
        method = "updateAITasks",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinUpdateAITasks(Block instance, Operation<Boolean> original) {
        return instance instanceof IMetaAware aware
            ? aware.isNormalCube(this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ)
            : original.call(instance);
    }
}
