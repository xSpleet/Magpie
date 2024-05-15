package xspleet.magpie.data;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import xspleet.magpie.MagpieMod;
import xspleet.magpie.item.ModItems;

public class TradeOfferModifier
{
    public static void modifyTrades() {
        MagpieMod.LOGGER.info("Modifying trades");

        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 10),
                        new ItemStack(ModItems.RAIN_MARACAS, 1),
                        1, 0, 0)));

        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 6),
                        new ItemStack(ModItems.TRANQ_DART, 1),
                        1, 0, 0)));

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 12),
                        new ItemStack(ModItems.FORK, 1),
                        1, 0, 0))
        );

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 12),
                        new ItemStack(ModItems.LIGHTNING_ARRESTER, 1),
                        1, 0, 0))
        );

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 2,
                factories -> factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(ModItems.RITUAL_CANDLE, 1),
                        1, 0, 0))
        );
    }
}

