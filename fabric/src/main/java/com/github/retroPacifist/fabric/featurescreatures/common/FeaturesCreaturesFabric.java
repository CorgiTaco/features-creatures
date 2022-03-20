package com.github.retroPacifist.fabric.featurescreatures.common;

import com.github.retroPacifist.featurescreatures.common.FeaturesCreatures;
import com.github.retroPacifist.featurescreatures.common.registry.block.FeaturesCreaturesBlocks;
import com.github.retroPacifist.featurescreatures.common.registry.blockentity.FeaturesCreaturesBlockEntities;
import com.github.retroPacifist.featurescreatures.common.registry.entity.FeaturesCreaturesEntities;
import com.github.retroPacifist.featurescreatures.common.registry.item.FeaturesCreaturesItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;

public final class FeaturesCreaturesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        FeaturesCreaturesBlocks.register((name, block) -> register(Registry.BLOCK, name, block));
        FeaturesCreaturesBlockEntities.register((name, blockEntityType) -> register(Registry.BLOCK_ENTITY_TYPE, name, blockEntityType));
        FeaturesCreaturesEntities.register((name, entityType) -> register(Registry.ENTITY_TYPE, name, entityType));
        FeaturesCreaturesItems.register((name, item) -> register(Registry.ITEM, name, item));
    }

    private static <T> void register(Registry<T> registry, String name, T t) {
        Registry.register(registry, FeaturesCreatures.createResourceLocation(name), t);
    }
}
