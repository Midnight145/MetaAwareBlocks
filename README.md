# MetaAwareBlocks

## As of now this only transforms Minecraft's code, and currently that is all that is planned due to other mods being a compatibility nightmare without any great way to go about things automatically. I'd have to write mixins for every single mod, and it's just not practical. If someone wants to create pull requests adding support for a mod, that's great, but for now it only supports Minecraft's native code.

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
