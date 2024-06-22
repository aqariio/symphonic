package aqario.symphonic;

import net.minecraft.sound.SoundEvent;

public record SymphonicInstrument(SoundEvent bassSoundEvent, SoundEvent harmonySoundEvent, SoundEvent melodySoundEvent,
                                  int useDuration, float range) {
}
