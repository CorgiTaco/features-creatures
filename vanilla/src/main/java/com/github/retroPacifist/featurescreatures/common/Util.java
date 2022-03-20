package com.github.retroPacifist.featurescreatures.common;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Consumer;

@UtilityClass
public class Util {

    public <K, V> void ifFilled(Map<K, V> map, Consumer<Map<K, V>> consumer) {
        if (!map.isEmpty()) {
            consumer.accept(map);
        }
    }

    public <T> void ifPresent(@Nullable T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
        }
    }
}
