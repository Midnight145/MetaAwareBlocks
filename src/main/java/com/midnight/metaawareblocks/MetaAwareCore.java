package com.midnight.metaawareblocks;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        return new ArrayList<>();
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
