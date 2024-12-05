package com.midnight.metaawareblocks.api;

import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public interface IMetaAware {

    default boolean renderAsNormalBlock(IBlockAccess world, int x, int y, int z) {
        return this.renderAsNormalBlock(world.getBlockMetadata(x, y, z));
    }

    default boolean renderAsNormalBlock(int meta) {
        return this.renderAsNormalBlock();
    };

    default float getAmbientOcclusionLightValue(IBlockAccess world, int x, int y, int z) {
        return this.getAmbientOcclusionLightValue();
    }

    default boolean isBlockNormalCube(IBlockAccess world, int x, int y, int z) {
        return this.isBlockNormalCube();
    }

    default boolean isOpaqueCube(IBlockAccess world, int x, int y, int z) {
        return this.isOpaqueCube();
    }

    default int getMobilityFlag(IBlockAccess world, int x, int y, int z) {
        return this.getMobilityFlag();
    }

    default boolean canProvidePower(IBlockAccess world, int x, int y, int z) {
        return this.canProvidePower();
    }

    // Already exists in Block, but the parameterless version is normally used originally, so this is here for clarity.
    default boolean isNormalCube(World world, int x, int y, int z) {
        return this.isNormalCube();
    }

    // Other useful overridable methods in Block
    // public int getLightOpacity(IBlockAccess world, int x, int y, int z)

    // Overrides from Block

    boolean renderAsNormalBlock();

    float getAmbientOcclusionLightValue();

    boolean isBlockNormalCube();

    boolean isOpaqueCube();

    int getMobilityFlag();

    boolean canProvidePower();

    boolean isNormalCube();
}
