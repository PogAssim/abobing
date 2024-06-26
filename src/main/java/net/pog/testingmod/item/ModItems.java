package net.pog.testingmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pog.testingmod.TestingMod;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RUBY_PIECE = registerItem("ruby_piece", new Item(new FabricItemSettings()));
    private static void addItemsToIngridientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RUBY_PIECE);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TestingMod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        TestingMod.LOGGER.info("Registering Mod Items for " + TestingMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngridientItemGroup);
    }
}
