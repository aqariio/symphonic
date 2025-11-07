package aqario.symphonic.data;

import aqario.symphonic.Symphonic;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.ComplexRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class SymphonicRecipeProvider extends FabricRecipeProvider {
    public SymphonicRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ComplexRecipeJsonBuilder.create(Symphonic.COPPER_HORN_RECIPE)
            .offerTo(exporter, new Identifier(Symphonic.ID, "copper_horn").toString());
    }
}
