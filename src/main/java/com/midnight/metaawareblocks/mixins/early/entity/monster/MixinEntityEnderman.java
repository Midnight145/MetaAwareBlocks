package com.midnight.metaawareblocks.mixins.early.entity.monster;

import com.llamalad7.mixinextras.sugar.Local;
import com.midnight.metaawareblocks.api.IMetaAware;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityEnderman.class)
public class MixinEntityEnderman extends EntityMob {

    public MixinEntityEnderman(World p_i1738_1_) {
        super(p_i1738_1_);
    }

    @Redirect(method="onLivingUpdate()V", at=@At(value="INVOKE", target="Lnet/minecraft/block/Block;renderAsNormalBlock()Z"))
    public boolean mixinOnLivingUpdate(Block instance, @Local(name="k") int x, @Local(name="i") int y, @Local(name="j") int z) {
        return ((IMetaAware) instance).renderAsNormalBlock(this.worldObj, x, y, z);
    }
}
