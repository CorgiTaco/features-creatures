package com.github.retroPacifist.geckolib.file;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import lombok.experimental.Delegate;
import software.bernie.geckolib3.core.builder.Animation;

import java.util.Map;

public final class AnimationFile {
    @Delegate
    private final Map<String, Animation> map = new Object2ObjectOpenHashMap<>();
}
