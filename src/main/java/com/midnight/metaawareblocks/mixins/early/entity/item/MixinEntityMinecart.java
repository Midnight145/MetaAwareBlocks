package com.midnight.metaawareblocks.mixins.early.entity.item;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = EntityMinecart.class)
public abstract class MixinEntityMinecart extends Entity {

    public MixinEntityMinecart(World worldIn) {
        super(worldIn);
    }

    @WrapOperation(
        method = "func_145821_a(IIIDDLnet/minecraft/block/Block;I)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 0))
    private boolean mixinFunc_145821_a0(Block instance, Operation<Boolean> original, @Local(name = "p_145821_1_") int x,
        @Local(name = "p_145821_2_") int y, @Local(name = "p_145821_3_") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.worldObj, x - 1, y, z)
            : original.call(instance);
    }

    @WrapOperation(
        method = "func_145821_a(IIIDDLnet/minecraft/block/Block;I)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 1))
    private boolean mixinFunc_145821_a1(Block instance, Operation<Boolean> original, @Local(name = "p_145821_1_") int x,
        @Local(name = "p_145821_2_") int y, @Local(name = "p_145821_3_") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.worldObj, x + 1, y, z)
            : original.call(instance);
    }

    @WrapOperation(
        method = "func_145821_a(IIIDDLnet/minecraft/block/Block;I)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 2))
    private boolean mixinFunc_145821_a2(Block instance, Operation<Boolean> original, @Local(name = "p_145821_1_") int x,
        @Local(name = "p_145821_2_") int y, @Local(name = "p_145821_3_") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.worldObj, x, y, z - 1)
            : original.call(instance);
    }

    @WrapOperation(
        method = "func_145821_a(IIIDDLnet/minecraft/block/Block;I)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 3))
    private boolean mixinFunc_145821_a3(Block instance, Operation<Boolean> original, @Local(name = "p_145821_1_") int x,
        @Local(name = "p_145821_2_") int y, @Local(name = "p_145821_3_") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.worldObj, x, y, z + 1)
            : original.call(instance);
    }
}
