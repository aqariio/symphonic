package aqario.symphonic;

import aqario.symphonic.registry.SymphonicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public interface SymphonicInstruments {
    RegistryKey<SymphonicInstrument> GREAT_COPPER_HORN = SymphonicInstruments.of("great_copper_horn");
    RegistryKey<SymphonicInstrument> OLD_COPPER_HORN = SymphonicInstruments.of("old_copper_horn");
    RegistryKey<SymphonicInstrument> PURE_COPPER_HORN = SymphonicInstruments.of("pure_copper_horn");
    RegistryKey<SymphonicInstrument> MUMBLE_COPPER_HORN = SymphonicInstruments.of("mumble_copper_horn");
    RegistryKey<SymphonicInstrument> DRY_COPPER_HORN = SymphonicInstruments.of("dry_copper_horn");
    RegistryKey<SymphonicInstrument> CLEAR_COPPER_HORN = SymphonicInstruments.of("clear_copper_horn");
    RegistryKey<SymphonicInstrument> FRESH_COPPER_HORN = SymphonicInstruments.of("fresh_copper_horn");
    RegistryKey<SymphonicInstrument> SECRET_COPPER_HORN = SymphonicInstruments.of("secret_copper_horn");
    RegistryKey<SymphonicInstrument> FEARLESS_COPPER_HORN = SymphonicInstruments.of("fearless_copper_horn");
    RegistryKey<SymphonicInstrument> SWEET_COPPER_HORN = SymphonicInstruments.of("sweet_copper_horn");

    private static RegistryKey<SymphonicInstrument> of(String id) {
        return RegistryKey.of(SymphonicRegistries.INSTRUMENT_KEY, Symphonic.id(id));
    }

    static void registerAndGetDefault(Registry<SymphonicInstrument> registry) {
        Registry.register(registry, GREAT_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(0),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(0),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(0),
                80, 256
        ));
        Registry.register(registry, OLD_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(1),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(1),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(1),
                80, 256
        ));
        Registry.register(registry, PURE_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(2),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(2),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(2),
                80, 256
        ));
        Registry.register(registry, MUMBLE_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(3),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(3),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(3),
                80, 256
        ));
        Registry.register(registry, DRY_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(4),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(4),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(4),
                80, 256
        ));
        Registry.register(registry, CLEAR_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(5),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(5),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(5),
                80, 256
        ));
        Registry.register(registry, FRESH_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(6),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(6),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(6),
                80, 256
        ));
        Registry.register(registry, SECRET_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(7),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(7),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(7),
                80, 256
        ));
        Registry.register(registry, FEARLESS_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(8),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(8),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(8),
                80, 256
        ));
        Registry.register(registry, SWEET_COPPER_HORN, new SymphonicInstrument(
                SymphonicSoundEvents.COPPER_HORN_BASS_SOUNDS.get(9),
                SymphonicSoundEvents.COPPER_HORN_HARMONY_SOUNDS.get(9),
                SymphonicSoundEvents.COPPER_HORN_MELODY_SOUNDS.get(9),
                80, 256
        ));
    }
}
