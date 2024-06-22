package aqario.symphonic;

import aqario.symphonic.item.SymphonicItems;
import aqario.symphonic.loot.SetCopperHornInstrumentFunction;
import aqario.symphonic.recipe.CopperHornRecipe;
import aqario.symphonic.registry.SymphonicRegistries;
import aqario.symphonic.tag.SymphonicInstrumentTags;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class Symphonic implements ModInitializer {
    public static final String ID = "symphonic";
    public static final SpecialRecipeSerializer<CopperHornRecipe> COPPER_HORN_RECIPE = new SpecialRecipeSerializer<>(CopperHornRecipe::new);
    public static final LootFunctionType SET_COPPER_HORN_INSTRUMENT = Registry.register(Registries.LOOK_FUNCTION_TYPE, new Identifier(ID, "set_instrument"), new LootFunctionType(new SetCopperHornInstrumentFunction.Serializer()));

    @Override
    public void onInitialize(ModContainer container) {
        SymphonicInstruments.initialize(SymphonicRegistries.INSTRUMENT);
        SymphonicItems.init();

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(ID, "copper_horn_recipe"), COPPER_HORN_RECIPE);

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (id.equals(LootTables.PILLAGER_OUTPOST_CHEST)) {
                tableBuilder.pool(LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.3f).build())
                    .with(ItemEntry.builder(SymphonicItems.COPPER_HORN))
                    .apply(SetCopperHornInstrumentFunction.builder(SymphonicInstrumentTags.COPPER_HORNS))
                );
            }
        });
    }
}
