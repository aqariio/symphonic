package aqario.symphonic.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SymphonicDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(SymphonicInstrumentTagProvider::new);
        fabricDataGenerator.addProvider(SymphonicRecipeProvider::new);
    }
}
