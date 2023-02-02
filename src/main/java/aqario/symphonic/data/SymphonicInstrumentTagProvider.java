package aqario.symphonic.data;

import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.SymphonicInstrumentTags;
import aqario.symphonic.SymphonicInstruments;
import aqario.symphonic.registry.SymphonicRegistries;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class SymphonicInstrumentTagProvider extends FabricTagProvider<SymphonicInstrument> {
    public SymphonicInstrumentTagProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator, SymphonicRegistries.INSTRUMENT);
    }

    @Override
    protected void generateTags() {
        this.getOrCreateTagBuilder(SymphonicInstrumentTags.REGULAR_COPPER_HORNS)
                .add(SymphonicInstruments.GREAT_COPPER_HORN)
                .add(SymphonicInstruments.OLD_COPPER_HORN)
                .add(SymphonicInstruments.PURE_COPPER_HORN)
                .add(SymphonicInstruments.DRY_COPPER_HORN)
                .add(SymphonicInstruments.MUMBLE_COPPER_HORN)
                .add(SymphonicInstruments.CLEAR_COPPER_HORN);

        this.getOrCreateTagBuilder(SymphonicInstrumentTags.SCREAMING_COPPER_HORNS)
                .add(SymphonicInstruments.SWEET_COPPER_HORN)
                .add(SymphonicInstruments.FEARLESS_COPPER_HORN)
                .add(SymphonicInstruments.SECRET_COPPER_HORN)
                .add(SymphonicInstruments.FRESH_COPPER_HORN);

        this.getOrCreateTagBuilder(SymphonicInstrumentTags.COPPER_HORNS)
                .addTag(SymphonicInstrumentTags.REGULAR_COPPER_HORNS)
                .addTag(SymphonicInstrumentTags.SCREAMING_COPPER_HORNS);
    }
}
