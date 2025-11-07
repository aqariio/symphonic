package aqario.symphonic;

import aqario.symphonic.item.SymphonicItems;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class SymphonicClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(SymphonicItems.COPPER_HORN, new Identifier("tooting"), ((stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0f));
    }
}
