package com.midnight.metaawareblocks.mixins.early.entity;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Entity.class)
public class MixinEntity {
    @Shadow
    public World worldObj;

    @Redirect(method="isEntityInsideOpaqueBlock", at= @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean mixinRedirect(Block block, @Local(name="j") int x, @Local(name="k") int y, @Local(name="l") int z) {
        return block.isNormalCube(this.worldObj, x, y, z);
    }
}
