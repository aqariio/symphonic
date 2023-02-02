package aqario.symphonic;

import aqario.symphonic.registry.SymphonicRegistries;
import net.minecraft.tag.TagKey;

public interface SymphonicInstrumentTags {
    TagKey<SymphonicInstrument> REGULAR_COPPER_HORNS = SymphonicInstrumentTags.of("regular_copper_horns");
    TagKey<SymphonicInstrument> SCREAMING_COPPER_HORNS = SymphonicInstrumentTags.of("screaming_copper_horns");
    TagKey<SymphonicInstrument> COPPER_HORNS = SymphonicInstrumentTags.of("copper_horns");

    private static TagKey<SymphonicInstrument> of(String id) {
        return TagKey.of(SymphonicRegistries.INSTRUMENT_KEY, Symphonic.id(id));
    }
}
