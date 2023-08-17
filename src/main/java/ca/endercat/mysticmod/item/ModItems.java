package ca.endercat.mysticmod.item;

import ca.endercat.mysticmod.MysticMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item STARDUST = registerItem("stardust", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientsGroup(FabricItemGroupEntries entries) {
        entries.add(STARDUST);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MysticMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MysticMod.LOGGER.info("Registering Mod Items for " + MysticMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsGroup);
    }
}
