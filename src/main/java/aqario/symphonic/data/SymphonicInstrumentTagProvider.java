package aqario.symphonic.data;

import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.SymphonicInstruments;
import aqario.symphonic.registry.SymphonicRegistries;
import aqario.symphonic.tag.SymphonicInstrumentTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SymphonicInstrumentTagProvider extends FabricTagProvider<SymphonicInstrument> {
    public SymphonicInstrumentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, SymphonicRegistries.INSTRUMENT_KEY, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        this.getOrCreateTagBuilder(SymphonicInstrumentTags.REGULAR_COPPER_HORNS)
            .add(SymphonicInstruments.GREAT_COPPER_HORN)
            .add(SymphonicInstruments.OLD_COPPER_HORN)
            .add(SymphonicInstruments.PURE_COPPER_HORN)
            .add(SymphonicInstruments.MUMBLE_COPPER_HORN)
            .add(SymphonicInstruments.DRY_COPPER_HORN)
            .add(SymphonicInstruments.CLEAR_COPPER_HORN);

        this.getOrCreateTagBuilder(SymphonicInstrumentTags.SCREAMING_COPPER_HORNS)
            .add(SymphonicInstruments.FRESH_COPPER_HORN)
            .add(SymphonicInstruments.SECRET_COPPER_HORN)
            .add(SymphonicInstruments.FEARLESS_COPPER_HORN)
            .add(SymphonicInstruments.SWEET_COPPER_HORN);

        this.getOrCreateTagBuilder(SymphonicInstrumentTags.COPPER_HORNS)
            .addTag(SymphonicInstrumentTags.REGULAR_COPPER_HORNS)
            .addTag(SymphonicInstrumentTags.SCREAMING_COPPER_HORNS);
    }
}
