package aqario.symphonic.recipe;

import aqario.symphonic.Symphonic;
import aqario.symphonic.SymphonicInstrumentTags;
import aqario.symphonic.item.CopperHornItem;
import aqario.symphonic.mixin.GoatHornItemInvoker;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Instrument;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.tag.InstrumentTags;
import net.minecraft.util.Holder;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;

import java.util.Optional;

public class CopperHornRecipe extends ShapedRecipe {
    public CopperHornRecipe(Identifier id) {
        super(id, "", 3, 2, DefaultedList.copyOf(Ingredient.EMPTY,
                Ingredient.ofItems(Items.COPPER_INGOT), Ingredient.ofItems(Items.GOAT_HORN), Ingredient.ofItems(Items.COPPER_INGOT),
                Ingredient.EMPTY, Ingredient.ofItems(Items.COPPER_INGOT), Ingredient.EMPTY
        ), new ItemStack(Symphonic.COPPER_HORN));
    }

    @Override
    public ItemStack craft(CraftingInventory inventory) {
        ItemStack goatHorn = ItemStack.EMPTY;
        for (int i = 0; i < inventory.size() && goatHorn.isEmpty(); ++i) {
            ItemStack itemStack = inventory.getStack(i);
            if (!itemStack.isOf(Items.GOAT_HORN)) continue;
            goatHorn = itemStack;
        }
        var tag = SymphonicInstrumentTags.REGULAR_COPPER_HORNS;

        Optional<Holder<Instrument>> instrument = ((GoatHornItemInvoker) goatHorn.getItem()).invokeGetInstrument(goatHorn);
        if (instrument.isPresent()) {
            if (instrument.get().isIn(InstrumentTags.SCREAMING_GOAT_HORNS)) tag = SymphonicInstrumentTags.SCREAMING_COPPER_HORNS;
        }

        ItemStack copperHorn = new ItemStack(Symphonic.COPPER_HORN);
        CopperHornItem.setRandomInstrumentFromTag(copperHorn, tag, RandomGenerator.createLegacy());

        return copperHorn;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Symphonic.COPPER_HORN_RECIPE;
    }

    @Override
    public boolean matches(CraftingInventory craftingInventory, World world) {
        return super.matches(craftingInventory, world);
    }
}
