package com.midnight.metaawareblocks.mixins.early.village;

import net.minecraft.block.Block;
import net.minecraft.village.Village;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;

@Mixin(value = Village.class)
public class MixinVillage {

    @Shadow
    private World worldObj;

    @Redirect(
        method = "isValidIronGolemSpawningLocation",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z"))
    private boolean redirect(Block instance, @Local(name = "i2") int x, @Local(name = "j2") int y,
        @Local(name = "k2") int z) {
        return instance.isNormalCube(this.worldObj, x, y, z);
    }
}
