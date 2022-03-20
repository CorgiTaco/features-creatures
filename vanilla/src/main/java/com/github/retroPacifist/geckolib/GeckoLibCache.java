package com.github.retroPacifist.geckolib;

import com.eliotlash.molang.MolangParser;
import com.github.retroPacifist.featurescreatures.common.Util;
import com.github.retroPacifist.geckolib.file.AnimationFile;
import com.github.retroPacifist.geckolib.file.AnimationFileLoader;
import com.google.common.base.Suppliers;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class GeckoLibCache {
    private static final Supplier<GeckoLibCache> SUPPLIER = Suppliers.memoize(GeckoLibCache::new);

    @Getter
    private final Map<ResourceLocation, AnimationFile> animations = Object2ObjectMaps.emptyMap();
    @Getter
    private final Map<ResourceLocation, Object> models = Object2ObjectMaps.emptyMap();

    private final MolangParser parser = new MolangParser();

    private GeckoLibCache() {
    }

    public CompletableFuture<Void> reload(PreparableReloadListener.PreparationBarrier barrier, ResourceManager manager, ProfilerFiller filler, ProfilerFiller reloadFiller, Executor executor, Executor gameExecutor) {
        Util.ifPresent(animations, Map::clear);
        Util.ifPresent(models, Map::clear);
        return CompletableFuture.allOf(
                load(executor, manager, "animations", animation -> AnimationFileLoader.createAnimationFile(parser, animation, manager), animations::put),
                load(executor, manager, "geo", geo -> {

                    return null;
                }, models::put)
        );
    }

    private <T> CompletableFuture<Void> load(Executor executor, ResourceManager manager, String type, Function<ResourceLocation, T> function, BiConsumer<ResourceLocation, T> consumer) {
        return CompletableFuture.supplyAsync(() -> {
            return manager.listResources(type, name -> name.endsWith(".json"));
        }, executor).thenApplyAsync(resources -> {
            Object2ObjectMap<ResourceLocation, CompletableFuture<T>> map = new Object2ObjectOpenHashMap<>();
            for (ResourceLocation location : resources) {
                Util.ifPresent(map.put(location, CompletableFuture.supplyAsync(() -> function.apply(location), executor)), future -> {
                    GeckoLib.LOGGER.warn("Duplicate resource '{}'", location);
                    future.cancel(false);
                });
            }
            return Object2ObjectMaps.unmodifiable(map);
        }, executor).thenAcceptAsync(map -> map.forEach((location, future) -> {
            consumer.accept(location, future.join());
        }), executor);
    }

    public static GeckoLibCache getInstance() {
        return SUPPLIER.get();
    }
}
