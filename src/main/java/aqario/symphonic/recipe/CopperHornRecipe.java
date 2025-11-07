package aqario.symphonic.recipe;

import aqario.symphonic.Symphonic;
import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.item.CopperHornItem;
import aqario.symphonic.item.SymphonicItems;
import aqario.symphonic.mixin.GoatHornItemInvoker;
import aqario.symphonic.tag.SymphonicInstrumentTags;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Instrument;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.InstrumentTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.random.Random;

import java.util.Optional;

public class CopperHornRecipe extends ShapedRecipe {
    public CopperHornRecipe(Identifier id, CraftingRecipeCategory category) {
        super(id, "", category, 3, 2, DefaultedList.copyOf(Ingredient.EMPTY,
            Ingredient.ofItems(Items.COPPER_INGOT), Ingredient.ofItems(Items.GOAT_HORN), Ingredient.ofItems(Items.COPPER_INGOT),
            Ingredient.EMPTY, Ingredient.ofItems(Items.COPPER_INGOT), Ingredient.EMPTY
        ), new ItemStack(SymphonicItems.COPPER_HORN));
    }

    @Override
    public ItemStack craft(RecipeInputInventory inventory, DynamicRegistryManager dynamicRegistryManager) {
        ItemStack goatHorn = ItemStack.EMPTY;
        for(int i = 0; i < inventory.size() && goatHorn.isEmpty(); ++i) {
            ItemStack itemStack = inventory.getStack(i);
            if(!itemStack.isOf(Items.GOAT_HORN)) {
                continue;
            }
            goatHorn = itemStack;
        }
        TagKey<SymphonicInstrument> tag = SymphonicInstrumentTags.REGULAR_COPPER_HORNS;

        Optional<RegistryEntry<Instrument>> instrument = ((GoatHornItemInvoker) goatHorn.getItem()).invokeGetInstrument(goatHorn);
        if(instrument.isPresent()) {
            if(instrument.get().isIn(InstrumentTags.SCREAMING_GOAT_HORNS)) {
                tag = SymphonicInstrumentTags.SCREAMING_COPPER_HORNS;
            }
        }

        ItemStack copperHorn = new ItemStack(SymphonicItems.COPPER_HORN);
        CopperHornItem.addInstrument(copperHorn, tag, Random.create());

        return copperHorn;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Symphonic.COPPER_HORN_RECIPE;
    }
}
