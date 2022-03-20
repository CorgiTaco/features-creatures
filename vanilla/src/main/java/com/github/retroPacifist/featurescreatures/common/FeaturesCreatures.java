package com.github.retroPacifist.featurescreatures.common;

import lombok.experimental.UtilityClass;
import net.minecraft.resources.ResourceLocation;

@UtilityClass
public class FeaturesCreatures {
    public final String MOD_ID = "featurescreatures";

    public ResourceLocation createResourceLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
