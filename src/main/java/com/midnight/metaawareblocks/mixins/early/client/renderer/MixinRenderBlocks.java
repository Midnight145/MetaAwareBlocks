package com.midnight.metaawareblocks.mixins.early.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = RenderBlocks.class, priority = 1001)
public class MixinRenderBlocks {

    @Shadow
    public IBlockAccess blockAccess;

    @Redirect(
        method = "renderBlockByRenderType",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I"))
    private int mixinRenderBlockByRenderType(Block instance, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getRenderType(this.blockAccess, x, y, z);
    }

    @Redirect(
        method = "renderBlockFlowerpot",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRenderType()I"))
    private int mixinRenderBlockFlowerpot(Block instance, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getRenderType(this.blockAccess, x, y, z);
    }

    @Redirect(
        method = "renderBlockVine",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z"))
    private boolean mixinRenderBlockVine(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 0))
    private boolean mixinRenderBlockRedstoneWire0(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 1))
    private boolean mixinRenderBlockRedstoneWire1(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 2))
    private boolean mixinRenderBlockRedstoneWire2(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 3))
    private boolean mixinRenderBlockRedstoneWire3(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 4))
    private boolean mixinRenderBlockRedstoneWire4(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 5))
    private boolean mixinRenderBlockRedstoneWire5(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 6))
    private boolean mixinRenderBlockRedstoneWire6(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 7))
    private boolean mixinRenderBlockRedstoneWire7(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 8))
    private boolean mixinRenderBlockRedstoneWire8(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 9))
    private boolean mixinRenderBlockRedstoneWire9(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 10))
    private boolean mixinRenderBlockRedstoneWire10(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 11))
    private boolean mixinRenderBlockRedstoneWire11(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 12))
    private boolean mixinRenderBlockRedstoneWire12(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderBlockRedstoneWire",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isBlockNormalCube()Z", ordinal = 13))
    private boolean mixinRenderBlockRedstoneWire13(Block block, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isBlockNormalCube(blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 0))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue0(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 1))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue1(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 2))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue2(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 3))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue3(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 4))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue4(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 5))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue5(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 6))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue6(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 7))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue7(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 8))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue8(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 9))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue9(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 10))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue10(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 11))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue11(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 12))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue12(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 13))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue13(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 14))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue14(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 15))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue15(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 16))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue16(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 17))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue17(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 18))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue18(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 19))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue19(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 20))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue20(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 21))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue21(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 22))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue22(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 23))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue23(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 24))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue24(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 25))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue25(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 26))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue26(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 27))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue27(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 28))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue28(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 29))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue29(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 30))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue30(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 31))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue31(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 32))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue32(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 33))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue33(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 34))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue34(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 35))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue35(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 36))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue36(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 37))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue37(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 38))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue38(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 39))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue39(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 40))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue40(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 41))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue41(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 42))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue42(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 43))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue43(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 44))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue44(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 45))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue45(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 46))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue46(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 47))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue47(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 48))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue48(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 49))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue49(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 50))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue50(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 51))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue51(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 52))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue52(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 53))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValue53(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 0))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial0(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 1))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial1(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 2))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial2(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 3))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial3(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 4))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial4(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 5))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial5(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 6))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial6(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 7))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial7(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 8))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial8(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F", ordinal = 9))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial9(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 10))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial10(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 11))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial11(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 12))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial12(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 13))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial13(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 14))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial14(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 15))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial15(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 16))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial16(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 17))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial17(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 18))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial18(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 19))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial19(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 20))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial20(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 21))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial21(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 22))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial22(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 23))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial23(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 24))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial24(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 25))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial25(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 26))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial26(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 27))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial27(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 28))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial28(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 29))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial29(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 30))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial30(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 31))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial31(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 32))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial32(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 33))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial33(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 34))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial34(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 35))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial35(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 36))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial36(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 37))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial37(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 38))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial38(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 39))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial39(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 40))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial40(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 41))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial41(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 42))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial42(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 43))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial43(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 44))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial44(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x - 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 45))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial45(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 46))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial46(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 47))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial47(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 48))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial48(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 49))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial49(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 50))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial50(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y - 1, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 51))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial51(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z - 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 52))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial52(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x, y + 1, z + 1);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/block/Block;getAmbientOcclusionLightValue()F",
            ordinal = 53))
    private float mixinRenderStandardBlockWithAmbientOcclusionLightValuePartial53(Block instance,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).getAmbientOcclusionLightValue(this.blockAccess, x + 1, y, z);

    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 0))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCube0(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 1))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCube1(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 2))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCube2(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 3))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCube3(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 4))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCube4(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusion",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 5))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCube5(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x + 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 0))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCubePartial0(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x, y - 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 1))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCubePartial1(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x, y + 1, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 2))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCubePartial2(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x, y, z - 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 3))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCubePartial3(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x, y, z + 1);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 4))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCubePartial4(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x - 1, y, z);
    }

    @Redirect(
        method = "renderStandardBlockWithAmbientOcclusionPartial",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isOpaqueCube()Z", ordinal = 5))
    private boolean redirectRenderStandardBlockWithAmbientOcclusionOpaqueCubePartial5(Block block,
        @Local(ordinal = 0, argsOnly = true) int x, @Local(ordinal = 1, argsOnly = true) int y,
        @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) block).isOpaqueCube(this.blockAccess, x + 1, y, z);
    }

}
