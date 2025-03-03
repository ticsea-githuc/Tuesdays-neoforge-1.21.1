package com.tuesday.tuesdaysmod.item;

import com.tuesday.tuesdaysmod.TuesdaysMod;
import com.tuesday.tuesdaysmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TuesdaysMod.MODID);

    public static final Supplier<CreativeModeTab> CREATIVE_MODE_TAB_ITEMS = CREATIVE_MODE_TAB.register("tuesdays_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.LAVA_INGOT.get()))
                    .title(Component.translatable("creativetab.tuesdaysmod.lava_ingot_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LAVA_INGOT);
                        output.accept(ModItems.PROK_INGOT);
                        output.accept(ModItems.RAW_LAVA);
                    }).build());

    public static final Supplier<CreativeModeTab> CREATIVE_MODE_TAB_BLOCKS = CREATIVE_MODE_TAB.register("tuesdays_blocs_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TuesdaysMod.MODID,"tuesdays_items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.LAVA_BLOCK))
                    .title(Component.translatable("creativetab.tuesdaysmod.lava_ingot_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.LAVA_BLOCK);
                        output.accept(ModBlocks.LAVA_ORE);
                        output.accept(ModBlocks.DEEPSLATE_LAVA_ORE);
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
