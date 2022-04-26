package com.github.retroPacifist.fc.common.item

import com.github.retroPacifist.fc.common.Registrant
import net.minecraft.world.item.Item

object FeaturesAndCreaturesItems: Registrant<Item> {

    override fun invoke(function: (name: String, entry: Item) -> Unit) {
    }
}