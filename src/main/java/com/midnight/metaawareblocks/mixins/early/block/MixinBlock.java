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

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(value = Block.class)
public abstract class MixinBlock implements IMetaAware {

    @Shadow
    public abstract boolean renderAsNormalBlock();

    @Shadow
    @SideOnly(Side.CLIENT)
    public abstract boolean isBlockNormalCube();

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
    public abstract boolean isOpaqueCube();

    @Shadow
    public abstract int getMobilityFlag();

    @Shadow
    public abstract int getRenderType();

    @Shadow
    protected double minY, minZ, minX, maxY, maxZ, maxX;

    /**
     * @author Midnight145
     * @reason I couldn't get a Redirect to work
     */
    @Overwrite
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return side == 0 && this.minY > 0.0D || (side == 1 && this.maxY < 1.0D || (side == 2 && this.minZ > 0.0D
            || (side == 3 && this.maxZ < 1.0D || (side == 4 && this.minX > 0.0D || (side == 5 && this.maxX < 1.0D
                || !((IMetaAware) world.getBlock(x, y, z)).isOpaqueCube(world, x, y, z))))));
    }

    /**
     * @author Midnight145
     * @reason Easier this than injecting and redirecting for a one-line method
     */
    @Overwrite(remap = false)
    public boolean isNormalCube(IBlockAccess world, int x, int y, int z) {
        return this.getMaterial()
            .isOpaque() && this.renderAsNormalBlock(world, x, y, z)
            && !this.canProvidePower(world, x, y, z);
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
    @Overwrite(remap = false)
    public boolean shouldCheckWeakPower(IBlockAccess world, int x, int y, int z, int meta) {
        return this.isNormalCube(world, x, y, z);
    }

    /**
     * @author Midnight145
     * @reason Short method, easier to rewrite
     */
    @Overwrite(remap = false)
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
        return canProvidePower(world, x, y, z) && side != -1;
    }

    // IMetaAware Overrides

    @Override
    public boolean renderAsNormalBlock(int meta) {
        return this.renderAsNormalBlock();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isBlockNormalCube(IBlockAccess world, int x, int y, int z) {
        return this.isBlockNormalCube();
    }

    @Override
    public int getRenderType(IBlockAccess world, int x, int y, int z) {
        return this.getRenderType();
        // return -1;
    }

    @Override
    public boolean isOpaqueCube(IBlockAccess world, int x, int y, int z) {
        return this.isOpaqueCube();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass(IBlockAccess world, int x, int y, int z) {
        return 0;
    }

    @Override
    public int getMobilityFlag(IBlockAccess world, int x, int y, int z) {
        return this.getMobilityFlag();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getAmbientOcclusionLightValue(IBlockAccess world, int x, int y, int z) {
        return this.isBlockNormalCube(world, x, y, z) ? 0.2F : 1.0F;
    }

    @Override
    public boolean canProvidePower(IBlockAccess world, int x, int y, int z) {
        return this.canProvidePower();
    }
}
