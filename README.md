# MetaAwareBlocks

This is a library used to add meta-aware functionality for several (primarily rendering) functions inside of net.minecraft.block.Block.

Usage:

Creating a new block:

```java
class NewBlock implements IMetaAware {
  ...

  @Override
  public boolean renderAsNormalBlock(IBlockAccess world, int x, int y, int z) {
    return world.getBlockMetadata(world, x, y, z) != 0;
  }

  ...
}
```

Mixin into a preexisting block:

```java
@Mixin(NewBlock.class)
public abstract class MixinNewBlock implements IMetaAware {
  @Override
  public boolean renderAsNormalBlock(IBlockAccess world, int x, int y, int z) {
    return world.getBlockMetadata(world, x, y, z) != 0;
  }
}
```
