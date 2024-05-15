package xspleet.magpie.event;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import xspleet.magpie.MagpieMod;
import xspleet.magpie.event.custom.*;
import xspleet.magpie.util.MagpieNetworkingConstants;
import xspleet.magpie.util.TrinketsUtil;

public class ModEvents
{
    public static void registerEvents()
    {
        MagpieMod.LOGGER.info("Registering effects");
        ServerLivingEntityEvents.ALLOW_DEATH.register(new LivingEntityDeathHandler());
        ServerLivingEntityEvents.ALLOW_DAMAGE.register(new CombatModifiersHandler());
        ServerLivingEntityEvents.ALLOW_DAMAGE.register(new RottenToothDropEvent());
        ServerLivingEntityEvents.ALLOW_DAMAGE.register(new LivingEntityStatusEffectDamageHandler());
        EntitySleepEvents.ALLOW_NEARBY_MONSTERS.register(new PlayerEntityAllowSleepingHandler());
        ServerPlayNetworking.registerGlobalReceiver(MagpieNetworkingConstants.USE_ACTIVE_ARTIFACT_PACKET_ID, (server, player, handler, buf, responseSender) ->
        {
            TrinketsUtil.activateAllActiveArtifacts(player);
        });
    }

}
