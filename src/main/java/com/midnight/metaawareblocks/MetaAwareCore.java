package com.midnight.metaawareblocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;

import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.Side;

public class MetaAwareCore extends DummyModContainer implements IEarlyMixinLoader, IFMLLoadingPlugin {

    private static final ModMetadata modMetadata = new ModMetadata();

    static {
        modMetadata.modId = "metaawareblocks";
        modMetadata.name = "MetaAwareBlocks";
        modMetadata.version = Tags.VERSION;
    }

    public MetaAwareCore() {
        this(modMetadata);
    }

    public MetaAwareCore(ModMetadata metadata) {
        super(metadata);
    }

    @Override
    public String getMixinConfig() {
        return "mixins.metaawareblocks.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        ArrayList<String> mixins = new ArrayList<>();
        Collections.addAll(
            mixins,
            "block.MixinBlockRedstoneDiode",
            "block.MixinBlockRedstoneComparator",
            "block.MixinBlockFenceGate",
            "block.MixinBlockWall",
            "block.MixinBlockLiquid",
            "block.MixinBlockChest",
            "block.MixinBlockSnow",
            "block.MixinBlockPortal",
            "block.MixinBlockPistonBase",
            "block.MixinBlockGrass",
            "block.MixinBlockEnderChest",
            "block.MixinBlockRedstoneOre",
            "block.MixinBlock",
            "block.MixinBlockRedstoneWire",
            "block.MixinBlockTrapDoor",
            "block.MixinBlockFence",
            "block.MixinBlockDoor",
            "block.MixinBlockRail",
            "block.MixinBlockVine",
            "village.MixinVillage",
            "minecraftforge.MixinBlockFluidBase",
            "world.MixinSpawnerAnimals",
            "entity.ai.MixinEntityAIFollowOwner",
            "entity.passive.MixinEntityBat",
            "entity.MixinEntity",
            "entity.monster.MixinEntityEnderman",
            "entity.item.MixinEntityMinecart",
            "item.MixinItemDoor");
        if (FMLLaunchHandler.side() == Side.CLIENT) {
            Collections.addAll(
                mixins,
                "client.renderer.MixinRenderBlocks",
                "client.renderer.MixinItemRenderer",
                "client.renderer.entity.MixinRender",
                "client.entity.MixinEntityPlayerSP");
        }

        return mixins;
    }

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return "com.midnight.metaawareblocks.MetaAwareCore";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
