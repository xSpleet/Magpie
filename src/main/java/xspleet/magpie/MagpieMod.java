package xspleet.magpie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import xspleet.magpie.data.LootTablesModifier;
import xspleet.magpie.data.TradeOfferModifier;
import xspleet.magpie.effect.ModStatusEffects;
import xspleet.magpie.event.ModEvents;
import xspleet.magpie.event.custom.*;
import xspleet.magpie.item.ModItemGroup;
import xspleet.magpie.item.ModItems;
import xspleet.magpie.util.MagpieNetworkingConstants;
import xspleet.magpie.util.TrinketsUtil;

public class MagpieMod implements ModInitializer {

	public static final float NO_DAMAGE = -1;
	public static final int SYMBOLS_PER_LINE = 40;
	public static final String MOD_ID = "magpie";
	public static final Logger LOGGER = LoggerFactory.getLogger("magpie");

	@Override
	public void onInitialize()
	{
		ModelPredicateProviderRegistry.register(ModItems.LIGHT_BULB, new Identifier("on"), (itemStack, clientWorld, livingEntity, id) -> {
            if (livingEntity == null || !TrinketsUtil.hasArtifact(livingEntity, ModItems.LIGHT_BULB)) {
                return 0.0F;
            }

            if (livingEntity.getMaxHealth() <= livingEntity.getHealth())
                return 1.0F;
            else
                return 0.0F;
        });
		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModStatusEffects.registerStatusEffects();
		ModEvents.registerEvents();
		TradeOfferModifier.modifyTrades();
		LootTablesModifier.modifyLootTables();
	}
}