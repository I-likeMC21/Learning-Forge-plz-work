package net.noah.tutorialmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.noah.tutorialmod.TutorialMod;
import net.noah.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static RegistryObject<Block> GEM_BLOCK = RegisterBlock("gem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));



    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        RegisterBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> Block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(Block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }
}
