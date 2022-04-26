package com.github.retroPacifist.fc.common

import net.minecraft.resources.ResourceLocation

object FeaturesAndCreatures {
    const val modId = "features_and_creatures"

    fun createResourceLocation(value: String): ResourceLocation {
        return ResourceLocation(modId, value)
    }
}