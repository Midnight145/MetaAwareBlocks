package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = BlockVine.class)
public class MixinBlockVine {

    @WrapOperation(
        method = "updateTick",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;renderAsNormalBlock()Z"))
    private boolean mixinUpdateTick(Block instance, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return instance instanceof IMetaAware aware ? aware.renderAsNormalBlock(world, x, y, z)
            : original.call(instance);
    }

    @WrapOperation(
        method = "canPlaceBlockOnSide",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z"))
    private boolean mixinCanPlaceBlockOnSide(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z,
        @Local(ordinal = 3, argsOnly = true) int side) {
        if (!(block instanceof IMetaAware)) {
            return original.call(instance, block);
        }
        switch (side) {
            case 1:
                y += 1;
                break;
            case 2:
                z += 1;
                break;
            case 3:
                z -= 1;
                break;
            case 4:
                x += 1;
                break;
            case 5:
                x -= 1;
                break;
            default:
                return false;
        }
        return metaAware$func_150093_a(block, world, x, y, z);
    }

    @WrapOperation(
        method = "setBlockBoundsBasedOnState",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z"))
    private boolean mixinSetBlockBoundsBasedOnState(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) IBlockAccess world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return block instanceof IMetaAware ? metaAware$func_150093_a(block, world, x, y + 1, z)
            : original.call(instance, block);
    }

    @WrapOperation(
        method = "func_150094_e",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 0))
    private boolean mixinFunc_150094_e0(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z,
        @Local(name = "j1") int j1) {
        return block instanceof IMetaAware
            ? metaAware$func_150093_a(block, world, x + Direction.offsetX[j1], y, z + Direction.offsetZ[j1])
            : original.call(instance, block);
    }

    @WrapOperation(
        method = "func_150094_e",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 1))
    private boolean mixinFunc_150094_e1(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return block instanceof IMetaAware ? metaAware$func_150093_a(block, world, x, y + 1, z)
            : original.call(instance, block);
    }

    @WrapOperation(
        method = "updateTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 0))
    private boolean mixinUpdateTick0(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z,
        @Local(name = "l1") int l1) {
        return block instanceof IMetaAware
            ? metaAware$func_150093_a(block, world, x + Direction.offsetX[l1], y + 1, z + Direction.offsetZ[l1])
            : original.call(instance, block);
    }

    @WrapOperation(
        method = "updateTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 1))
    private boolean mixinUpdateTick1(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z,
        @Local(name = "l1") int l1, @Local(name = "k1") int k1) {
        return block instanceof IMetaAware
            ? metaAware$func_150093_a(
                block,
                world,
                x + Direction.offsetX[l1] + Direction.offsetX[k1],
                y,
                z + Direction.offsetZ[l1] + Direction.offsetZ[k1])
            : original.call(instance, block);
    }

    @WrapOperation(
        method = "updateTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 2))
    private boolean mixinUpdateTick2(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z,
        @Local(name = "k1") int k1, @Local(name = "i2") int i2) {
        return block instanceof IMetaAware
            ? metaAware$func_150093_a(
                block,
                world,
                x + Direction.offsetX[k1] + Direction.offsetX[i2],
                y,
                z + Direction.offsetZ[k1] + Direction.offsetZ[i2])
            : original.call(instance, block);

    }

    @WrapOperation(
        method = "updateTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 3))
    private boolean mixinUpdateTick3(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z,
        @Local(name = "l1") int l1) {
        return block instanceof IMetaAware
            ? metaAware$func_150093_a(block, world, x + Direction.offsetX[l1], y, z + Direction.offsetZ[l1])
            : original.call(instance, block);
    }

    @WrapOperation(
        method = "updateTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 4))
    private boolean mixinUpdateTick4(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z,
        @Local(name = "i2") int i2) {
        return block instanceof IMetaAware
            ? metaAware$func_150093_a(block, world, x + Direction.offsetX[i2], y, z + Direction.offsetZ[i2])
            : original.call(instance, block);
    }

    @WrapOperation(
        method = "updateTick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/BlockVine;func_150093_a(Lnet/minecraft/block/Block;)Z",
            ordinal = 5))
    private boolean mixinUpdateTick5(BlockVine instance, Block block, Operation<Boolean> original,
        @Local(ordinal = 0, argsOnly = true) World world, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z,
        @Local(name = "k1") int k1) {
        return block instanceof IMetaAware
            ? metaAware$func_150093_a(block, world, x + Direction.offsetX[k1], y + 1, z + Direction.offsetZ[k1])
            : original.call(instance, block);
    }

    @Unique
    private boolean metaAware$func_150093_a(Block block, IBlockAccess world, int x, int y, int z) {
        return ((IMetaAware) block).renderAsNormalBlock(world, x, y, z) && block.getMaterial()
            .blocksMovement();
    }
}
