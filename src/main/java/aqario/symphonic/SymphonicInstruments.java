package aqario.symphonic;

import aqario.symphonic.registry.SymphonicRegistries;
import aqario.symphonic.sound.SymphonicSoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

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
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(0),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(0),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(0),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, OLD_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(1),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(1),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(1),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, PURE_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(2),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(2),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(2),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, MUMBLE_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(3),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(3),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(3),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, DRY_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(4),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(4),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(4),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, CLEAR_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(5),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(5),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(5),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, FRESH_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(6),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(6),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(6),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, SECRET_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(7),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(7),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(7),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, FEARLESS_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(8),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(8),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(8),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
        Registry.register(registry, SWEET_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(9),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(9),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(9),
                DEFAULT_DURATION, DEFAULT_RANGE
        ));
    }
}
