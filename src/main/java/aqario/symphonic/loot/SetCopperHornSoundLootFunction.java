package aqario.symphonic.loot;

import aqario.symphonic.Symphonic;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSyntaxException;
import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.item.CopperHornItem;
import aqario.symphonic.registry.SymphonicRegistries;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;

public class SetCopperHornSoundLootFunction extends ConditionalLootFunction {
    final TagKey<SymphonicInstrument> instrumentTagKey;

    SetCopperHornSoundLootFunction(LootCondition[] lootConditions, TagKey<SymphonicInstrument> tagKey) {
        super(lootConditions);
        this.instrumentTagKey = tagKey;
    }

    @Override
    public LootFunctionType getType() {
        return Symphonic.SET_COPPER_HORN_INSTRUMENT;
    }

    @Override
    public ItemStack process(ItemStack stack, LootContext context) {
        CopperHornItem.setRandomInstrumentFromTag(stack, this.instrumentTagKey, context.getRandom());
        return stack;
    }

    public static ConditionalLootFunction.Builder<?> builder(TagKey<SymphonicInstrument> tagKey) {
        return SetCopperHornSoundLootFunction.builder((LootCondition[] lootConditions) -> new SetCopperHornSoundLootFunction(lootConditions, tagKey));
    }

    public static class Serializer extends ConditionalLootFunction.Serializer<SetCopperHornSoundLootFunction> {
        @Override
        public void toJson(JsonObject jsonObject, SetCopperHornSoundLootFunction setGoatHornSoundLootFunction, JsonSerializationContext jsonSerializationContext) {
            super.toJson(jsonObject, setGoatHornSoundLootFunction, jsonSerializationContext);
            jsonObject.addProperty("options", "#" + setGoatHornSoundLootFunction.instrumentTagKey.id());
        }

        @Override
        public SetCopperHornSoundLootFunction fromJson(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext, LootCondition[] lootConditions) {
            String string = JsonHelper.getString(jsonObject, "options");
            if (!string.startsWith("#")) {
                throw new JsonSyntaxException("Inline tag value not supported: " + string);
            }
            return new SetCopperHornSoundLootFunction(lootConditions, TagKey.of(SymphonicRegistries.INSTRUMENT_KEY, new Identifier(string.substring(1))));
        }
    }
}
