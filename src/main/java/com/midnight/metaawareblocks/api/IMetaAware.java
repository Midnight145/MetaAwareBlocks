package com.midnight.metaawareblocks.api;

import net.minecraft.world.IBlockAccess;

public interface IMetaAware {
    default boolean renderAsNormalBlock(IBlockAccess world, int x, int y, int z) {
        return this.renderAsNormalBlock(world.getBlockMetadata(x, y, z));
    }

    boolean renderAsNormalBlock(int meta);

    boolean isBlockNormalCube(IBlockAccess world, int x, int y, int z);
}
