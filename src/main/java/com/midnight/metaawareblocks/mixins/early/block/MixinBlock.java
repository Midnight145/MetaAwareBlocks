package com.midnight.metaawareblocks.mixins.early.block;

import com.midnight.metaawareblocks.api.IMetaAware;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(Block.class)
public abstract class MixinBlock implements IMetaAware {

    @Shadow public abstract boolean renderAsNormalBlock();

    @Shadow public abstract boolean isBlockNormalCube();

    @Shadow public abstract Material getMaterial();

    @Shadow public abstract boolean canProvidePower();

    @Shadow private ThreadLocal<Integer> silk_check_meta;

    @SuppressWarnings("DeprecatedIsStillUsed")
    @Shadow @Deprecated public abstract boolean hasTileEntity(int meta);

    @Override
    public boolean renderAsNormalBlock(int meta) {
        return this.renderAsNormalBlock();
    }

    @Override
    public boolean isBlockNormalCube(IBlockAccess world, int x, int y, int z) {
        return this.isBlockNormalCube();
    }

    /**
     * @author Midnight145
     * @reason Easier this than injecting and redirecting for a one-line method
     */
    @Overwrite(remap=false)
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
        return this.getMaterial().isOpaque() && this.renderAsNormalBlock(world, x, y ,z) && !this.canProvidePower();
    }

    /**
     * @author Midnight145
     * @reason Short method, is easier to overwrite than inject
     */
    @Overwrite
    public boolean canSilkHarvest() {
        Integer meta = this.silk_check_meta.get();
        if (meta == null) {
            meta = 0;
        }
        return this.renderAsNormalBlock(meta) && !this.hasTileEntity(meta);
    }

    /**
     * @author Midnight
     * @reason Short method, easier to rewrite
     */
    @Overwrite
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int meta) {
        return this.isNormalCube(world, x, y, z);
    }
}
