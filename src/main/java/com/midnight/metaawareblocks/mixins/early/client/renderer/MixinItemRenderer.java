package com.midnight.metaawareblocks.mixins.early.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;

@Mixin(value = ItemRenderer.class)
public class MixinItemRenderer {

    @Shadow
    private Minecraft mc;

    @WrapOperation(
        method = "renderOverlays",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 0))
    private boolean mixinRenderOverlays0(Block instance, Operation<Boolean> original, @Local(name = "i") int x,
        @Local(name = "j") int y, @Local(name = "k") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.mc.theWorld, x, y, z)
            : original.call(instance);
    }

    @WrapOperation(
        method = "renderOverlays",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;isNormalCube()Z", ordinal = 1))
    private boolean mixinRenderOverlays1(Block instance, Operation<Boolean> original, @Local(name = "i1") int x,
        @Local(name = "j1") int y, @Local(name = "k1") int z) {
        return instance instanceof IMetaAware aware ? aware.isNormalCube(this.mc.theWorld, x, y, z)
            : original.call(instance);
    }
}
