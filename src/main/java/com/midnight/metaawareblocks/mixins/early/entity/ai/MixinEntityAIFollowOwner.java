package com.midnight.metaawareblocks.mixins.early.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = EntityAIFollowOwner.class)
public abstract class MixinEntityAIFollowOwner extends EntityAIBase {

    @Shadow
    World theWorld;

    @WrapOperation(
        method = "updateTask",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 0))
    private boolean mixinUpdateTask0(Block instance, Operation<Boolean> original, @Local(name = "i") int x,
        @Local(name = "l") int dx, @Local(name = "k") int y, @Local(name = "j") int z, @Local(name = "i1") int dz) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.theWorld, x + dx, y, z + dz)
            : original.call(instance);
    }

    @WrapOperation(
        method = "updateTask",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 1))
    private boolean mixinSecondRedirect(Block instance, Operation<Boolean> original, @Local(name = "i") int x,
        @Local(name = "l") int dx, @Local(name = "k") int y, @Local(name = "j") int z, @Local(name = "i1") int dz) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.theWorld, x + dx, y + 1, z + dz)
            : original.call(instance);
    }
}
