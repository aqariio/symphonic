package aqario.symphonic;

import aqario.symphonic.item.CopperHornItem;
import aqario.symphonic.loot.SetCopperHornSoundLootFunction;
import aqario.symphonic.recipe.CopperHornRecipe;
import aqario.symphonic.registry.SymphonicRegistries;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class Symphonic implements ModInitializer {
    public static final String ID = "symphonic";
    public static final Item COPPER_HORN = new CopperHornItem(new QuiltItemSettings().group(ItemGroup.MISC).maxCount(1), SymphonicInstrumentTags.COPPER_HORNS);
    public static final SpecialRecipeSerializer<CopperHornRecipe> COPPER_HORN_RECIPE = new SpecialRecipeSerializer<>(CopperHornRecipe::new);
    public static final LootFunctionType SET_COPPER_HORN_INSTRUMENT = Registry.register(Registry.LOOT_FUNCTION_TYPE, new Identifier(ID, "set_instrument"), new LootFunctionType(new SetCopperHornSoundLootFunction.Serializer()));

    @Override
    public void onInitialize(ModContainer container) {
        SymphonicInstruments.registerAndGetDefault(SymphonicRegistries.INSTRUMENT);
        Registry.register(Registry.ITEM, new Identifier(ID, "copper_horn"), COPPER_HORN);
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(ID, "copper_horn_recipe"), COPPER_HORN_RECIPE);

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (id.equals(LootTables.PILLAGER_OUTPOST_CHEST)) {
                tableBuilder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.3f).build())
                        .with(ItemEntry.builder(COPPER_HORN))
                        .apply(SetCopperHornSoundLootFunction.builder(SymphonicInstrumentTags.REGULAR_COPPER_HORNS))
                );
            }
        });
    }
}
