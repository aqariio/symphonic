package aqario.symphonic.data;

import aqario.symphonic.Symphonic;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.ComplexRecipeJsonFactory;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class SymphonicRecipeProvider extends FabricRecipeProvider {
    public SymphonicRecipeProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        ComplexRecipeJsonFactory.create(Symphonic.COPPER_HORN_RECIPE).offerTo(exporter, new Identifier(Symphonic.ID, "copper_horn").toString());
    }
}
