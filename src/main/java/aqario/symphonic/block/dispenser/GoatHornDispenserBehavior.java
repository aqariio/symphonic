package aqario.symphonic.block.dispenser;

import aqario.symphonic.mixin.GoatHornItemInvoker;
import net.minecraft.block.dispenser.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.Instrument;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Holder;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Optional;

public class GoatHornDispenserBehavior extends ItemDispenserBehavior {
    @Override
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        World world = pointer.getWorld();
        if (!world.isClient()) {
            Optional<Holder<Instrument>> optional = ((GoatHornItemInvoker) stack.getItem()).invokeGetInstrument(stack);
            Instrument instrument = optional.get().value();
            BlockPos blockPos = pointer.getPos().offset(pointer.getBlockState().get(DispenserBlock.FACING));
            playSound(world, blockPos, instrument);
        }
        return stack;
    }

    private static void playSound(World world, BlockPos blockPos, Instrument instrument) {
        SoundEvent soundEvent = instrument.sound().value();
        float f = instrument.range() / 16.0F;
        world.playSound(null, blockPos, soundEvent, SoundCategory.RECORDS, f, 1.0F);
        world.emitGameEvent(null, GameEvent.INSTRUMENT_PLAY, blockPos);
    }
}
