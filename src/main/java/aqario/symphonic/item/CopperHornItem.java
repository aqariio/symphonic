package aqario.symphonic.item;

import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.registry.SymphonicRegistries;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Holder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CopperHornItem extends Item {
    private static final String INSTRUMENT_KEY = "instrument";
    private final TagKey<SymphonicInstrument> validInstruments;

    public CopperHornItem(Settings settings, TagKey<SymphonicInstrument> validInstruments) {
        super(settings);
        this.validInstruments = validInstruments;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        Optional<RegistryKey<SymphonicInstrument>> optional = this.getInstrument(stack).flatMap(Holder::getKey);
        if (optional.isPresent()) {
            MutableText mutableText = Text.translatable(Util.createTranslationKey(INSTRUMENT_KEY, optional.get().getValue()));
            tooltip.add(mutableText.formatted(Formatting.GRAY));
        }
    }

    public static ItemStack addInstrument(Item item, Holder<SymphonicInstrument> instrument) {
        ItemStack itemStack = new ItemStack(item);
        addInstrument(itemStack, instrument);
        return itemStack;
    }

    public static void addInstrument(ItemStack stack, TagKey<SymphonicInstrument> instrumentTag, RandomGenerator random) {
        Optional<Holder<SymphonicInstrument>> optional = SymphonicRegistries.INSTRUMENT.getTag(instrumentTag).flatMap(set -> set.getRandomElement(random));
        optional.ifPresent(symphonicInstrumentHolder -> addInstrument(stack, symphonicInstrumentHolder));
    }

    private static void addInstrument(ItemStack stack, Holder<SymphonicInstrument> instrument) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putString(INSTRUMENT_KEY, instrument.getKey().orElseThrow(() -> new IllegalStateException("Invalid instrument")).getValue().toString());
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        Optional<? extends Holder<SymphonicInstrument>> optional = this.getInstrument(itemStack);
        if (optional.isPresent()) {
            SymphonicInstrument instrument = optional.get().value();
            user.setCurrentHand(hand);
            playSound(world, user, instrument);
            user.getItemCooldownManager().set(this, instrument.useDuration());
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        Optional<? extends Holder<SymphonicInstrument>> optional = this.getInstrument(stack);
        return optional.map(copperHornInstrumentHolder -> copperHornInstrumentHolder.value().useDuration()).orElse(0);
    }

    public Optional<? extends Holder<SymphonicInstrument>> getInstrument(ItemStack stack) {
        Identifier identifier;
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound != null && (identifier = Identifier.tryParse(nbtCompound.getString(INSTRUMENT_KEY))) != null) {
            return SymphonicRegistries.INSTRUMENT.getHolder(RegistryKey.of(SymphonicRegistries.INSTRUMENT_KEY, identifier));
        }
        Iterator<Holder<SymphonicInstrument>> iterator = SymphonicRegistries.INSTRUMENT.getTagOrEmpty(this.validInstruments).iterator();
        return iterator.hasNext() ? Optional.of(iterator.next()) : Optional.empty();
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    private static void playSound(World world, PlayerEntity player, SymphonicInstrument instrument) {
        SoundEvent soundEvent = instrument.melodySoundEvent();
        if (player.getPitch() <= -45.0) {
            soundEvent = instrument.harmonySoundEvent();
        }
        if (player.isSneaking()) {
            soundEvent = instrument.bassSoundEvent();
        }

        float f = instrument.range() / 16.0f;
        world.playSoundFromEntity(player, player, soundEvent, SoundCategory.RECORDS, f, 1.0f);
        world.emitGameEvent(GameEvent.INSTRUMENT_PLAY, player.getPos(), GameEvent.Context.create(player));
    }
}
