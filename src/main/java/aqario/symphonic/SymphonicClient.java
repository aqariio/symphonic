package aqario.symphonic;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

public class SymphonicClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        ModelPredicateProviderRegistry.register(Symphonic.COPPER_HORN, new Identifier("tooting"), ((stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0f));
    }
}
