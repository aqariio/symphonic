package aqario.symphonic.registry;

import aqario.symphonic.Symphonic;
import aqario.symphonic.SymphonicInstrument;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class SymphonicRegistries {
    public static final RegistryKey<Registry<SymphonicInstrument>> INSTRUMENT_KEY = RegistryKey.ofRegistry(new Identifier(Symphonic.ID, "instrument"));
    public static final DefaultedRegistry<SymphonicInstrument> INSTRUMENT = FabricRegistryBuilder.createDefaulted(INSTRUMENT_KEY, new Identifier(Symphonic.ID, "great_copper_horn")).buildAndRegister();
}
