package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockRedstoneWire.class)
public abstract class MixinBlockRedstoneWire {

    @Shadow
    protected abstract void func_150172_m(World p_150172_1_, int p_150172_2_, int p_150172_3_, int p_150172_4_);

    @Shadow
    private boolean field_150181_a;

    @Shadow
    public static boolean func_150176_g(IBlockAccess p_150176_0_, int p_150176_1_, int p_150176_2_, int p_150176_3_,
        int p_150176_4_) {
        return false;
    }

    @WrapOperation(
        method = "func_150175_a",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 0))
    private boolean isNormalCube0(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(name = "k2") int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(name = "l2") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(world, x, y, z) : original.call(instance);
    }

    @WrapOperation(
        method = "func_150175_a",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 1))
    private boolean isNormalCube1(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(name = "k2") int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(name = "l2") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(world, x, y + 1, z) : original.call(instance);
    }

    @WrapOperation(
        method = "func_150175_a",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 2))
    private boolean isNormalCube2(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(name = "k2") int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(name = "l2") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(world, x, y, z) : original.call(instance);
    }

    @Inject(
        method = "onBlockAdded",
        at = @At(
            value = "INVOKE_ASSIGN",
            target = "Lnet/minecraft/block/BlockRedstoneWire;func_150172_m(Lnet/minecraft/world/World;III)V",
            ordinal = 3),
        cancellable = true)
    private void mixinOnBlockAdded(World world, int x, int y, int z, CallbackInfo ci) {
        tf$updateNeighbors(world, x, y, z);
        ci.cancel();
    }

    @Inject(
        method = "breakBlock",
        at = @At(
            value = "INVOKE_ASSIGN",
            target = "Lnet/minecraft/block/BlockRedstoneWire;func_150172_m(Lnet/minecraft/world/World;III)V",
            ordinal = 3),
        cancellable = true)
    private void mixinBreakBlock(World world, int x, int y, int z, Block blockBroken, int meta, CallbackInfo ci) {
        tf$updateNeighbors(world, x, y, z);
        ci.cancel();
    }

    @Unique
    private void tf$updateNeighbors(World world, int x, int y, int z) {
        tf$updateNeighbor(world, x - 1, y, z);
        tf$updateNeighbor(world, x + 1, y, z);
        tf$updateNeighbor(world, x, y, z - 1);
        tf$updateNeighbor(world, x, y, z + 1);
    }

    @Unique
    private void tf$updateNeighbor(World world, int x, int y, int z) {
        int dy = world.getBlock(x, y, z)
            .isNormalCube(world, x, y, z) ? 1 : -1;
        this.func_150172_m(world, x, y + dy, z);
    }

    /**
     * @author Midnight145
     * @reason no way was I writing nine redirects for the same function, I'll overwrite it instead
     */
    @Overwrite
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side) {
        if (!this.field_150181_a) {
            return 0;
        }

        int metadata = world.getBlockMetadata(x, y, z);
        if (metadata == 0) {
            return 0;
        }

        if (side == 1) {
            return metadata;
        }

        boolean canPowerLeft = tf$canPowerSide(world, x - 1, y, z, 1) || tf$canPowerBelow(world, x - 1, y, z);
        boolean canPowerRight = tf$canPowerSide(world, x + 1, y, z, 3) || tf$canPowerBelow(world, x + 1, y, z);
        boolean canPowerBack = tf$canPowerSide(world, x, y, z - 1, 2) || tf$canPowerBelow(world, x, y, z - 1);
        boolean canPowerFront = tf$canPowerSide(world, x, y, z + 1, 0) || tf$canPowerBelow(world, x, y, z + 1);

        if (!world.getBlock(x, y + 1, z)
            .isNormalCube()) {
            canPowerLeft |= tf$canPowerAbove(world, x - 1, y, z);
            canPowerRight |= tf$canPowerAbove(world, x + 1, y, z);
            canPowerBack |= tf$canPowerAbove(world, x, y, z - 1);
            canPowerFront |= tf$canPowerAbove(world, x, y, z + 1);
        }

        if (side >= 2 && side <= 5) {
            if ((side == 2 && canPowerBack) || (side == 3 && canPowerFront)
                || (side == 4 && canPowerLeft)
                || (side == 5 && canPowerRight)) {
                return metadata;
            }
        }

        return 0;
    }

    @Unique
    private boolean tf$canPowerSide(IBlockAccess world, int x, int y, int z, int side) {
        return func_150176_g(world, x, y, z, side);
    }

    @Unique
    private boolean tf$canPowerBelow(IBlockAccess world, int x, int y, int z) {
        return !world.getBlock(x, y, z)
            .isNormalCube(world, x, y, z) && func_150176_g(world, x, y - 1, z, -1);
    }

    @Unique
    private boolean tf$canPowerAbove(IBlockAccess world, int x, int y, int z) {
        return world.getBlock(x, y, z)
            .isNormalCube(world, x, y, z) && func_150176_g(world, x, y + 1, z, -1);
    }

}
