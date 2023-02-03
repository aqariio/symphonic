package aqario.symphonic.mixin;

import net.minecraft.item.Instrument;
import net.minecraft.item.InstrumentItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Holder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Optional;

@Mixin(InstrumentItem.class)
public interface GoatHornItemInvoker {
    @Invoker
    Optional<Holder<Instrument>> invokeGetInstrument(ItemStack stack);
}
