package aqario.symphonic.item;

import aqario.symphonic.Symphonic;
import aqario.symphonic.SymphonicInstrument;
import aqario.symphonic.registry.SymphonicRegistries;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.TagKey;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CopperHornItem extends Item {
    private static final String INSTRUMENT_KEY = "instrument";
    private final TagKey<SymphonicInstrument> instrumentTag;

    public CopperHornItem(Settings settings, TagKey<SymphonicInstrument> instrumentTag) {
        super(settings);
        this.instrumentTag = instrumentTag;
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

    public static ItemStack getStackForInstrument(Item item, Holder<SymphonicInstrument> instrument) {
        ItemStack itemStack = new ItemStack(item);
        CopperHornItem.setInstrument(itemStack, instrument);
        return itemStack;
    }

    public static void setRandomInstrumentFromTag(ItemStack stack, TagKey<SymphonicInstrument> instrumentTag, RandomGenerator random) {
        Optional<Holder<SymphonicInstrument>> optional = SymphonicRegistries.INSTRUMENT.getTag(instrumentTag).flatMap(entryList -> entryList.getRandomElement(random));
        optional.ifPresent(copperHornInstrumentHolder -> CopperHornItem.setInstrument(stack, copperHornInstrumentHolder));
    }

    private static void setInstrument(ItemStack stack, Holder<SymphonicInstrument> instrument) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putString(INSTRUMENT_KEY, instrument.getKey().orElseThrow(() -> new IllegalStateException("Invalid instrument")).getValue().toString());
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        if (this.isInGroup(group)) {
            for (Holder<SymphonicInstrument> Holder : SymphonicRegistries.INSTRUMENT.getTagOrEmpty(this.instrumentTag)) {
                stacks.add(CopperHornItem.getStackForInstrument(Symphonic.COPPER_HORN, Holder));
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        Optional<Holder<SymphonicInstrument>> optional = this.getInstrument(itemStack);
        if (optional.isPresent()) {
            SymphonicInstrument instrument = optional.get().value();
            user.setCurrentHand(hand);
            CopperHornItem.playSound(world, user, instrument);
            user.getItemCooldownManager().set(this, instrument.useDuration());
            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        Optional<Holder<SymphonicInstrument>> optional = this.getInstrument(stack);
        return optional.map(copperHornInstrumentHolder -> copperHornInstrumentHolder.value().useDuration()).orElse(0);
    }

    public Optional<Holder<SymphonicInstrument>> getInstrument(ItemStack stack) {
        Identifier identifier;
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound != null && (identifier = Identifier.tryParse(nbtCompound.getString(INSTRUMENT_KEY))) != null) {
            return SymphonicRegistries.INSTRUMENT.getHolder(RegistryKey.of(SymphonicRegistries.INSTRUMENT_KEY, identifier));
        }
        Iterator<Holder<SymphonicInstrument>> iterator = SymphonicRegistries.INSTRUMENT.getTagOrEmpty(this.instrumentTag).iterator();
        if (iterator.hasNext()) {
            return Optional.of(iterator.next());
        }
        return Optional.empty();
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    private static void playSound(World world, PlayerEntity player, SymphonicInstrument instrument) {
        SoundEvent soundEvent = instrument.melodySoundEvent();
        if (player.getPitch() <= -45.0) soundEvent = instrument.harmonySoundEvent();
        if (player.isSneaking()) soundEvent = instrument.bassSoundEvent();

        float f = instrument.range() / 16.0f;
        world.playSoundFromEntity(player, player, soundEvent, SoundCategory.RECORDS, f, 1.0f);
        world.emitGameEvent(GameEvent.INSTRUMENT_PLAY, player.getPos(), GameEvent.Context.create(player));
    }
}
