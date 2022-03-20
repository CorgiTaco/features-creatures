package com.github.retroPacifist.featurescreatures.common.registry;

@FunctionalInterface
public interface Registrant<T> {

    void register(String name, T t);
}
