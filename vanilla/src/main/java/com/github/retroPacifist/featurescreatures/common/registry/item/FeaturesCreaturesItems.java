package com.github.retroPacifist.featurescreatures.common.registry.item;

import com.github.retroPacifist.featurescreatures.common.registry.Registrant;
import com.github.retroPacifist.featurescreatures.common.registry.block.FeaturesCreaturesBlocks;
import lombok.experimental.UtilityClass;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

@UtilityClass
public class FeaturesCreaturesItems {
    public final Item SUNSET_ORE = new BlockItem(FeaturesCreaturesBlocks.SUNSET_ORE, createProperties());
    public final Item DAWN_ORE = new BlockItem(FeaturesCreaturesBlocks.DAWN_ORE, createProperties());
    public final Item MIDNIGHT_ORE = new BlockItem(FeaturesCreaturesBlocks.MIDNIGHT_ORE, createProperties());

    public final Item SUNSET_CRYSTAL_BLOCK = new BlockItem(FeaturesCreaturesBlocks.SUNSET_CRYSTAL_BLOCK, createProperties());
    public final Item DAWN_CRYSTAL_BLOCK = new BlockItem(FeaturesCreaturesBlocks.DAWN_CRYSTAL_BLOCK, createProperties());
    public final Item MIDNIGHT_CRYSTAL_BLOCK = new BlockItem(FeaturesCreaturesBlocks.MIDNIGHT_CRYSTAL_BLOCK, createProperties());

    //public final Item MEGA_POTION = new Item(createProperties());

    //public final Item JOCKEY_SPAWN_EGG = new Item(createProperties());
    //public final Item BOAR_SPAWN_EGG = new Item(createProperties());
    //public final Item SABERTOOTH_SPAWN_EGG = new Item(createProperties());
    //public final Item JACKALOPE_SPAWN_EGG = new Item(createProperties());
    //public final Item BLACK_FOREST_SPIRIT_SPAWN_EGG = new Item(createProperties());
    //public final Item GUP_SPAWN_EGG = new Item(createProperties());
    //public final Item BRIMSTONE_GOLEM_SPAWN_EGG = new Item(createProperties());

    public void register(Registrant<Item> registrant) {
        registrant.register("sunset_ore", SUNSET_ORE);
        registrant.register("dawn_ore", DAWN_ORE);
        registrant.register("midnight_ore", MIDNIGHT_ORE);
        registrant.register("sunset_crystal_block", SUNSET_CRYSTAL_BLOCK);
        registrant.register("dawn_crystal_block", DAWN_CRYSTAL_BLOCK);
        registrant.register("midnight_crystal_block", MIDNIGHT_CRYSTAL_BLOCK);
        //registrant.register("jockey_spawn_egg", JOCKEY_SPAWN_EGG);
        //registrant.register("boar_spawn_egg", BOAR_SPAWN_EGG);
        //registrant.register("sabertooth_spawn_egg", SABERTOOTH_SPAWN_EGG);
        //registrant.register("jackalope_spawn_egg", JACKALOPE_SPAWN_EGG);
        //registrant.register("black_forest_spirit_spawn_egg", BLACK_FOREST_SPIRIT_SPAWN_EGG);
        //registrant.register("gup_spawn_egg", GUP_SPAWN_EGG);
        //registrant.register("brimstone_golem_spawn_egg", BRIMSTONE_GOLEM_SPAWN_EGG);
    }

    private Item.Properties createProperties() {
        return new Item.Properties();
    }
}
