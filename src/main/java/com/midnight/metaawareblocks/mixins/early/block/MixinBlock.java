package com.midnight.metaawareblocks.mixins.early.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.midnight.metaawareblocks.api.IMetaAware;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mixin(value = Block.class)
public abstract class MixinBlock {

    @Shadow
    public abstract boolean renderAsNormalBlock();

    @Shadow
    public abstract Material getMaterial();

    @Shadow
    public abstract boolean canProvidePower();

    @Shadow(remap = false)
    private ThreadLocal<Integer> silk_check_meta;

    @SuppressWarnings("DeprecatedIsStillUsed")
    @Shadow(remap = false)
    @Deprecated
    public abstract boolean hasTileEntity(int meta);

    @Shadow
    protected double minY, minZ, minX, maxY, maxZ, maxX;

    @Shadow
    public abstract boolean isNormalCube();

    /**
     * @author Midnight145
     * @reason I couldn't get a Redirect to work
     */
    @Overwrite
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return side == 0 && this.minY > 0.0D || (side == 1 && this.maxY < 1.0D || (side == 2 && this.minZ > 0.0D
            || (side == 3 && this.maxZ < 1.0D || (side == 4 && this.minX > 0.0D || (side == 5 && this.maxX < 1.0D
                || !(world.getBlock(x, y, z) instanceof IMetaAware aware ? aware.isOpaqueCube(world, x, y, z)
                    : world.getBlock(x, y, z)
                        .isOpaqueCube()))))));
    }

    /**
     * @author Midnight145
     * @reason Easier this than injecting and redirecting for a one-line method
     */
    @Overwrite(remap = false)
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
        if (this instanceof IMetaAware aware) {
            return this.getMaterial()
                .isOpaque() && aware.renderAsNormalBlock(world, x, y, z)
                && !aware.canProvidePower(world, x, y, z);
        }
        return this.getMaterial()
            .isOpaque() && this.renderAsNormalBlock()
            && !this.canProvidePower();
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
        return (this instanceof IMetaAware aware ? aware.renderAsNormalBlock(meta) : this.renderAsNormalBlock())
            && !this.hasTileEntity(meta);
    }

    /**
     * @author Midnight
     * @reason Short method, easier to rewrite
     */
    @Overwrite(remap = false)
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int meta) {
        return this instanceof IMetaAware ? this.isNormalCube(world, x, y, z) : this.isNormalCube();
    }

}
