package com.github.retroPacifist.fc.common

import com.github.retroPacifist.fc.common.block.FeaturesAndCreaturesBlocks
import com.github.retroPacifist.fc.common.entity.FeaturesAndCreaturesEntities
import com.github.retroPacifist.fc.common.item.FeaturesAndCreaturesItems
import net.minecraft.core.Registry
import net.minecraft.resources.ResourceLocation

object FeaturesAndCreatures {
    const val modId = "features_and_creatures"

    // Fabric and Quilt only.
    fun register() {
        FeaturesAndCreaturesBlocks.invoke { name, entry -> register(Registry.BLOCK, name, entry) }
        FeaturesAndCreaturesEntities.invoke { name, entry -> register(Registry.ENTITY_TYPE, name, entry) }
        FeaturesAndCreaturesItems.invoke { name, entry -> register(Registry.ITEM, name, entry) }
    }

    private fun <T> register(registry: Registry<T>, name: String, t: T) {
        Registry.register(registry, createResourceLocation(name), t);
    }

    fun createResourceLocation(value: String): ResourceLocation = ResourceLocation(modId, value)
}