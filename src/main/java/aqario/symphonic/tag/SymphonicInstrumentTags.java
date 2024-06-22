package aqario.symphonic.tag;

import aqario.symphonic.Symphonic;
import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.registry.SymphonicRegistries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public interface SymphonicInstrumentTags {
    TagKey<SymphonicInstrument> REGULAR_COPPER_HORNS = register("regular_copper_horns");
    TagKey<SymphonicInstrument> SCREAMING_COPPER_HORNS = register("screaming_copper_horns");
    TagKey<SymphonicInstrument> COPPER_HORNS = register("copper_horns");

    private static TagKey<SymphonicInstrument> register(String id) {
        return TagKey.of(SymphonicRegistries.INSTRUMENT_KEY, new Identifier(Symphonic.ID, id));
    }
}
