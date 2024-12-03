package com.midnight.metaawareblocks.api;

import net.minecraft.world.IBlockAccess;

import org.apache.commons.lang3.NotImplementedException;

public interface IMetaAware {

    default boolean renderAsNormalBlock(IBlockAccess world, int x, int y, int z) {
        return this.renderAsNormalBlock(world.getBlockMetadata(x, y, z));
    }

    boolean renderAsNormalBlock(int meta);

    float getAmbientOcclusionLightValue(IBlockAccess world, int x, int y, int z);

    boolean isBlockNormalCube(IBlockAccess world, int x, int y, int z);

    int getRenderType(IBlockAccess world, int x, int y, int z); // some not doable

    boolean isOpaqueCube(IBlockAccess world, int x, int y, int z);

    default int getRenderBlockPass(IBlockAccess world, int x, int y, int z) {
        throw new NotImplementedException("Not implemented yet");
    }

    int getMobilityFlag(IBlockAccess world, int x, int y, int z);

    // Other useful overridable methods in Block
    // public int getLightOpacity(IBlockAccess world, int x, int y, int z)

}
