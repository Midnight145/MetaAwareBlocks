package com.midnight.metaawareblocks.mixins.early.entity.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = EntityBat.class, priority = 1001)
public abstract class MixinEntityBat extends Entity {

    public MixinEntityBat(World worldIn) {
        super(worldIn);
    }

    @Redirect(
        method = "updateAITasks",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinRedirect(Block block) {
        return block.isNormalCube(this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
    }
}
