package aqario.symphonic.mixin;

import aqario.symphonic.block.dispenser.CopperHornDispenserBehavior;
import aqario.symphonic.block.dispenser.GoatHornDispenserBehavior;
import aqario.symphonic.item.SymphonicItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DispenserBehavior.class)
public interface DispenserBehaviorMixin {
    @Inject(method = "registerDefaults", at = @At("HEAD"))
    private static void injectRegisterDefaults(CallbackInfo info) {
        DispenserBlock.registerBehavior(Items.GOAT_HORN.asItem(), new GoatHornDispenserBehavior());
        DispenserBlock.registerBehavior(SymphonicItems.COPPER_HORN.asItem(), new CopperHornDispenserBehavior());
    }
}
