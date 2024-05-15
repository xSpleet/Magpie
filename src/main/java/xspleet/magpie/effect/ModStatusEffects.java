package xspleet.magpie.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.MathHelper;
import xspleet.magpie.MagpieMod;
import xspleet.magpie.effect.custom.*;

import java.awt.*;

public class ModStatusEffects
{
    public static StatusEffect ANGY;
    public static StatusEffect AUTOTOMY;
    public static StatusEffect TIDAL_FLOW;
    public static StatusEffect INNER_FLAME;
    public static StatusEffect SOLID_GROUND;
    public static StatusEffect SOFT_BREEZE;

    private static StatusEffect register(int rawId, String id, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT, rawId, id, entry);
    }

    public static void registerStatusEffects()
    {
        MagpieMod.LOGGER.info("Registering custom status effects");
        AUTOTOMY = ModStatusEffects.register(
                31415901,
                "magpie:autotomy",
                new AutotomyEffect(
                        StatusEffectCategory.BENEFICIAL,
                        (new Color(100, 0, 0)).getRGB()
                )
                        .addAttributeModifier(
                                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                "d6133500-db0f-4c89-b9d1-87d1ad28e349",
                                1f,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
                        )
        );
        TIDAL_FLOW = ModStatusEffects.register(
                31415902,
                "magpie:tidal_flow",
                new TidalFlowEffect(
                        StatusEffectCategory.BENEFICIAL,
                        (new Color(0, 0, 69)).getRGB()
                )
        );
        INNER_FLAME = ModStatusEffects.register(
                31415903,
                "magpie:inner_flame",
                new InnerFlameEffect(
                        StatusEffectCategory.BENEFICIAL,
                        (new Color(235, 124, 28)).getRGB()
                )
        );
        SOLID_GROUND = ModStatusEffects.register(
                31415904,
                "magpie:solid_ground",
                new SolidGroundEffect(
                        StatusEffectCategory.BENEFICIAL,
                        (new Color(87, 71, 30)).getRGB()
                )
                        .addAttributeModifier(
                                EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                                "1afce32f-7f35-4564-8f80-f9183ae0619d",
                                10.0f,
                                EntityAttributeModifier.Operation.ADDITION
                        )
        );
        SOFT_BREEZE = ModStatusEffects.register(
                31415905,
                "magpie:soft_breeze",
                new SoftBreezeEffect(
                        StatusEffectCategory.BENEFICIAL,
                        (new Color(253,237,178)).getRGB()
                )
                        .addAttributeModifier(
                                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                "825065c5-1d89-4a98-a833-a0967faa13fa",
                                0.2f,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
                        )
        );
        ANGY = ModStatusEffects.register(
                31415906,
                "magpie:angy",
                new AngyEffect(
                        StatusEffectCategory.NEUTRAL,
                        (new Color(136, 8, 8)).getRGB()
                )
                        .addAttributeModifier(
                                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                                "a3bf020b-d7bc-40aa-a345-8503f518e916",
                                0.1f,
                                EntityAttributeModifier.Operation.MULTIPLY_TOTAL
                        )
        );
    }
}
