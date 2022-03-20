package com.github.retroPacifist.featurescreatures.common;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

@UtilityClass
public class Util {

    public <T> void ifPresent(@Nullable T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
        }
    }
}
