package aqario.symphonic.sound;

import aqario.symphonic.Symphonic;
import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.stream.IntStream;

public class SymphonicSoundEvents {
    public static final ImmutableList<SoundEvent> ITEM_COPPER_HORN_BASS = registerCopperHornSounds(CopperHornSoundType.BASS);
    public static final ImmutableList<SoundEvent> ITEM_COPPER_HORN_HARMONY = registerCopperHornSounds(CopperHornSoundType.HARMONY);
    public static final ImmutableList<SoundEvent> ITEM_COPPER_HORN_MELODY = registerCopperHornSounds(CopperHornSoundType.MELODY);

    private static ImmutableList<SoundEvent> registerCopperHornSounds(CopperHornSoundType type) {
        return IntStream.range(0, 10).mapToObj(variant ->
            SymphonicSoundEvents.register("item.copper_horn.sound." + type.value + "." + variant)
        ).collect(ImmutableList.toImmutableList());
    }

    private static SoundEvent register(String id) {
        return Registry.register(Registries.SOUND_EVENT, new Identifier(Symphonic.ID, id), SoundEvent.of(new Identifier(Symphonic.ID, id)));
    }

    private enum CopperHornSoundType {
        BASS("bass"),
        HARMONY("harmony"),
        MELODY("melody");

        public final String value;

        CopperHornSoundType(String value) {
            this.value = value;
        }
    }
}
