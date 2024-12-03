package com.midnight.metaawareblocks.mixins.early.entity.ai;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityAIFollowOwner.class)
public abstract class MixinEntityAIFollowOwner extends EntityAIBase {
    @Shadow
    World theWorld;

    @Redirect(method="updateTask", at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 0))
    private boolean mixinFirstRedirect(Block instance, @Local(name="i") int x, @Local(name="l") int dx, @Local(name="k") int y, @Local(name="j") int z, @Local(name="i1") int dz) {
        return instance.isNormalCube(this.theWorld, x + dx, y, z+dz);
    }

    @Redirect(method="updateTask", at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 1))
    private boolean mixinSecondRedirect(Block instance, @Local(name="i") int x, @Local(name="l") int dx, @Local(name="k") int y, @Local(name="j") int z, @Local(name="i1") int dz) {
        return instance.isNormalCube(this.theWorld, x + dx, y + 1, z+dz);
    }
}
