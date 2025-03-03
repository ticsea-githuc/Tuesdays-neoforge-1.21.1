package com.tuesday.tuesdaysmod.item;

import com.tuesday.tuesdaysmod.TuesdaysMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TuesdaysMod.MODID);

    public static final DeferredItem<Item> LAVA_INGOT = ITEMS.register("lava_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PROK_INGOT = ITEMS.register("pork_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_LAVA = ITEMS.register("raw_lava",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
