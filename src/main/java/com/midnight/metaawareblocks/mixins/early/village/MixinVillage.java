package com.midnight.metaawareblocks.mixins.early.village;

import net.minecraft.block.Block;
import net.minecraft.village.Village;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = Village.class)
public class MixinVillage {

    @Shadow
    private World worldObj;

    @WrapOperation(
        method = "isValidIronGolemSpawningLocation",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinIsValidIronGolemSpawningLocation(Block instance, Operation<Boolean> original,
        @Local(name = "i2") int x, @Local(name = "j2") int y, @Local(name = "k2") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.worldObj, x, y, z)
            : original.call(instance);
    }
}
