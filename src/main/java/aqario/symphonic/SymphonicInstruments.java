package aqario.symphonic;

import aqario.symphonic.registry.SymphonicRegistries;
import aqario.symphonic.sound.SymphonicSoundEvents;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public interface SymphonicInstruments {
    int DEFAULT_RANGE = 256;
    int DEFAULT_DURATION = 80;
    RegistryKey<SymphonicInstrument> GREAT_COPPER_HORN = create("great_copper_horn");
    RegistryKey<SymphonicInstrument> OLD_COPPER_HORN = create("old_copper_horn");
    RegistryKey<SymphonicInstrument> PURE_COPPER_HORN = create("pure_copper_horn");
    RegistryKey<SymphonicInstrument> MUMBLE_COPPER_HORN = create("mumble_copper_horn");
    RegistryKey<SymphonicInstrument> DRY_COPPER_HORN = create("dry_copper_horn");
    RegistryKey<SymphonicInstrument> CLEAR_COPPER_HORN = create("clear_copper_horn");
    RegistryKey<SymphonicInstrument> FRESH_COPPER_HORN = create("fresh_copper_horn");
    RegistryKey<SymphonicInstrument> SECRET_COPPER_HORN = create("secret_copper_horn");
    RegistryKey<SymphonicInstrument> FEARLESS_COPPER_HORN = create("fearless_copper_horn");
    RegistryKey<SymphonicInstrument> SWEET_COPPER_HORN = create("sweet_copper_horn");

    private static RegistryKey<SymphonicInstrument> create(String id) {
        return RegistryKey.of(SymphonicRegistries.INSTRUMENT_KEY, new Identifier(Symphonic.ID, id));
    }

    static void initialize(Registry<SymphonicInstrument> registry) {
        Registry.register(registry, GREAT_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(0),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(0),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(0),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, OLD_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(1),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(1),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(1),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, PURE_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(2),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(2),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(2),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, MUMBLE_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(3),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(3),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(3),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, DRY_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(4),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(4),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(4),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, CLEAR_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(5),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(5),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(5),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, FRESH_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(6),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(6),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(6),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, SECRET_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(7),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(7),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(7),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, FEARLESS_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(8),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(8),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(8),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, SWEET_COPPER_HORN, new SymphonicInstrument(
            SymphonicSoundEvents.ITEM_COPPER_HORN_BASS.get(9),
            SymphonicSoundEvents.ITEM_COPPER_HORN_HARMONY.get(9),
            SymphonicSoundEvents.ITEM_COPPER_HORN_MELODY.get(9),
            DEFAULT_DURATION, DEFAULT_RANGE
        ));
    }
}
