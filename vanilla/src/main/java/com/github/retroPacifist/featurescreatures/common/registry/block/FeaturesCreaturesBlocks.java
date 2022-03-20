package com.github.retroPacifist.featurescreatures.common.registry.block;

import com.github.retroPacifist.featurescreatures.common.registry.Registrant;
import lombok.experimental.UtilityClass;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

@UtilityClass
public class FeaturesCreaturesBlocks {
    public final Block SUNSET_ORE = new Block(Properties.copy(Blocks.DIAMOND_ORE));
    public final Block DAWN_ORE = new Block(Properties.copy(Blocks.DIAMOND_ORE));
    public final Block MIDNIGHT_ORE = new Block(Properties.copy(Blocks.DIAMOND_ORE));

    public final Block SUNSET_CRYSTAL_BLOCK = new Block(Properties.copy(Blocks.DIAMOND_BLOCK));
    public final Block DAWN_CRYSTAL_BLOCK = new Block(Properties.copy(Blocks.DIAMOND_BLOCK));
    public final Block MIDNIGHT_CRYSTAL_BLOCK = new Block(Properties.copy(Blocks.DIAMOND_BLOCK));

    public void register(Registrant<Block> registrant) {
        registrant.register("sunset_ore", SUNSET_ORE);
        registrant.register("dawn_ore", DAWN_ORE);
        registrant.register("midnight_ore", MIDNIGHT_ORE);
        registrant.register("sunset_crystal_block", SUNSET_CRYSTAL_BLOCK);
        registrant.register("dawn_crystal_block", DAWN_CRYSTAL_BLOCK);
        registrant.register("midnight_crystal_block", MIDNIGHT_CRYSTAL_BLOCK);
    }
}
