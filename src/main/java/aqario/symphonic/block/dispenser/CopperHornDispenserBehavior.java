package aqario.symphonic.block.dispenser;

import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.item.CopperHornItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Holder;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Optional;

public class CopperHornDispenserBehavior extends ItemDispenserBehavior {
    @Override
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        World world = pointer.getWorld();
        Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
        if (!world.isClient()) {
            Optional<Holder<SymphonicInstrument>> optional = ((CopperHornItem) stack.getItem()).getInstrument(stack);
            SymphonicInstrument instrument = optional.get().value();
            BlockPos blockPos = pointer.getPos().offset(pointer.getBlockState().get(DispenserBlock.FACING));
            playSound(world, direction, blockPos, instrument);
        }
        return stack;
    }

    private static void playSound(World world, Direction dir, BlockPos blockPos, SymphonicInstrument instrument) {
        SoundEvent soundEvent = instrument.melodySoundEvent();
        if (dir.equals(Direction.UP)) soundEvent = instrument.harmonySoundEvent();
        if (dir.equals(Direction.DOWN)) soundEvent = instrument.bassSoundEvent();

        float f = instrument.range() / 16.0f;
        world.playSound(null, blockPos, soundEvent, SoundCategory.RECORDS, f, 1.0f);
        world.emitGameEvent(null, GameEvent.INSTRUMENT_PLAY, blockPos);
    }
}
