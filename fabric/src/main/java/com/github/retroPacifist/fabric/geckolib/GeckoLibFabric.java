package com.github.retroPacifist.fabric.geckolib;

import com.github.retroPacifist.geckolib.GeckoLibCache;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public final class GeckoLibFabric implements ClientModInitializer {
    private static final ResourceLocation FABRIC_ID = new ResourceLocation("geckolib", "models");

    @Override
    public void onInitializeClient() {
        ResourceManagerHelper.get(PackType.CLIENT_RESOURCES).registerReloadListener(new IdentifiableResourceReloadListener() {
            @Override
            public ResourceLocation getFabricId() {
                return FABRIC_ID;
            }

            @ParametersAreNonnullByDefault
            @Override
            public CompletableFuture<Void> reload(PreparationBarrier preparationBarrier, ResourceManager resourceManager, ProfilerFiller profilerFiller, ProfilerFiller profilerFiller2, Executor executor, Executor executor2) {
                return GeckoLibCache.getInstance().reload(preparationBarrier, resourceManager, profilerFiller, profilerFiller2, executor, executor2);
            }
        });
    }
}
