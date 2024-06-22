package aqario.symphonic.item;

import aqario.symphonic.Symphonic;
import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.registry.SymphonicRegistries;
import aqario.symphonic.tag.SymphonicInstrumentTags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Holder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class SymphonicItems {
    public static final Item COPPER_HORN = register("copper_horn", new CopperHornItem(new QuiltItemSettings().maxCount(1), SymphonicInstrumentTags.COPPER_HORNS));

    private static Item register(String id, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS_AND_UTILITIES).register(entries -> {
            for (Holder<SymphonicInstrument> instrument : SymphonicRegistries.INSTRUMENT.getTagOrEmpty(SymphonicInstrumentTags.COPPER_HORNS)) {
                entries.addAfter(Items.GOAT_HORN, CopperHornItem.addInstrument(COPPER_HORN, instrument));
            }
        });
        return Registry.register(Registries.ITEM, new Identifier(Symphonic.ID, id), item);
    }

    public static void init() {
    }
}
