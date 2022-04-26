package com.github.retroPacifist.fc.common.entity

import com.github.retroPacifist.fc.common.Registrant
import net.minecraft.world.entity.EntityType

object FeaturesAndCreaturesEntities: Registrant<EntityType<*>> {

    override fun invoke(function: (name: String, entry: EntityType<*>) -> Unit) {
    }
}