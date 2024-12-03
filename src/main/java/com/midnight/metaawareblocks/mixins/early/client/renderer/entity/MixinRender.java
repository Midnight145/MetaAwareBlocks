package com.midnight.metaawareblocks.mixins.early.client.renderer.entity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = Render.class)
public abstract class MixinRender {

    @Shadow
    protected abstract World getWorldFromRenderManager();

    @Redirect(
        method = "func_147907_a(Lnet/minecraft/block/Block;DDDIIIFFDDD)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;renderAsNormalBlock()Z"))
    public boolean redirectRenderAsNormalBlock(Block instance, @Local(ordinal = 0, argsOnly = true) int x,
        @Local(ordinal = 1, argsOnly = true) int y, @Local(ordinal = 2, argsOnly = true) int z) {
        return ((IMetaAware) instance).renderAsNormalBlock(this.getWorldFromRenderManager(), x, y, z);
    }
}
