package com.tuesday.tuesdaysmod.block;

import com.tuesday.tuesdaysmod.TuesdaysMod;
import com.tuesday.tuesdaysmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

//创建寄存器
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TuesdaysMod.MODID);


    //实例
    public static final DeferredBlock<Block> LAVA_BLOCK = registerBlock("lava_block",
            () ->new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> LAVA_ORE = registerBlock("lava_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,9),BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_LAVA_ORE = registerBlock("deepslate_lava_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
                    .strength(9f)
                    .requiresCorrectToolForDrops()));



    //关联BlockItem
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;

    }
    //BlockItem
    private static <T extends Block> void registerBlockItem(String name,DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    //注册事件总线
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
