package aqario.symphonic.registry;

import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.Symphonic;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class SymphonicRegistries {
    public static final RegistryKey<Registry<SymphonicInstrument>> INSTRUMENT_KEY = RegistryKey.ofRegistry(new Identifier(Symphonic.ID, "instrument"));
    public static final DefaultedRegistry<SymphonicInstrument> INSTRUMENT = FabricRegistryBuilder.createDefaulted(SymphonicInstrument.class, INSTRUMENT_KEY.getValue(), new Identifier(Symphonic.ID, "great_copper_horn")).buildAndRegister();
}
