package aqario.symphonic.item;

import aqario.symphonic.Symphonic;
import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.registry.SymphonicRegistries;
import aqario.symphonic.tag.SymphonicInstrumentTags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class SymphonicItems {
    public static final Item COPPER_HORN = register("copper_horn", new CopperHornItem(new Item.Settings().maxCount(1), SymphonicInstrumentTags.COPPER_HORNS));

    private static Item register(String id, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            for(RegistryEntry<SymphonicInstrument> instrument : SymphonicRegistries.INSTRUMENT.iterateEntries(SymphonicInstrumentTags.COPPER_HORNS)) {
                entries.add(CopperHornItem.addInstrument(COPPER_HORN, instrument), ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
            }
        });
        return Registry.register(Registries.ITEM, new Identifier(Symphonic.ID, id), item);
    }

    public static void init() {
    }
}
