package com.github.retroPacifist.fc.common

interface Registrant<T> {

    fun invoke(function: (name: String, entry: T) -> Unit);
}