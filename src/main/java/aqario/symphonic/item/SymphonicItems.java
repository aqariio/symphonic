package aqario.symphonic.item;

import aqario.symphonic.Symphonic;
import aqario.symphonic.tag.SymphonicInstrumentTags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class SymphonicItems {
    public static final Item COPPER_HORN = register("copper_horn", new CopperHornItem(new QuiltItemSettings().group(ItemGroup.MISC).maxCount(1), SymphonicInstrumentTags.COPPER_HORNS));

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Symphonic.ID, id), item);
    }

    public static void init() {
    }
}
