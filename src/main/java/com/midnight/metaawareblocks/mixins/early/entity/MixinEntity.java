package com.midnight.metaawareblocks.mixins.early.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = Entity.class)
public class MixinEntity {

    @Shadow
    public World worldObj;

    @WrapOperation(
        method = "isEntityInsideOpaqueBlock",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinIsEntityInsideOpaqueBlock(Block instance, Operation<Boolean> original,
        @Local(name = "j") int x, @Local(name = "k") int y, @Local(name = "l") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.worldObj, x, y, z)
            : original.call(instance);
    }
}
