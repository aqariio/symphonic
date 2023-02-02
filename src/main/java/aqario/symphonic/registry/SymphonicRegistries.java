package aqario.symphonic.registry;

import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.Symphonic;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class SymphonicRegistries {
    public static final RegistryKey<Registry<SymphonicInstrument>> INSTRUMENT_KEY = RegistryKey.ofRegistry(Symphonic.id("instrument"));
    public static final DefaultedRegistry<SymphonicInstrument> INSTRUMENT = FabricRegistryBuilder.createDefaulted(SymphonicInstrument.class, INSTRUMENT_KEY.getValue(), Symphonic.id("great_copper_horn")).buildAndRegister();
}
