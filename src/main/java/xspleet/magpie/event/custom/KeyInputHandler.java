package xspleet.magpie.event.custom;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import xspleet.magpie.util.MagpieNetworkingConstants;

public class KeyInputHandler 
{
	public static final String KEY_CATEGORY_MAGPIE = "key.category.magpie.magpie";
	public static final String KEY_USE_ACTIVE_ARTIFACT = "key.magpie.use_active_artifact";

	public static KeyBinding artifactUsingKey;
	
	public static void registerKeyInputs()
	{
		ClientTickEvents.END_CLIENT_TICK.register(client->
		{
			if(artifactUsingKey.wasPressed())
			{
				ClientPlayNetworking.send(MagpieNetworkingConstants.USE_ACTIVE_ARTIFACT_PACKET_ID, PacketByteBufs.empty());
			}
		}
		);
	}
	
	public static void register()
	{
		artifactUsingKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				KEY_USE_ACTIVE_ARTIFACT,
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_U,
				KEY_CATEGORY_MAGPIE
		));
		registerKeyInputs();
	}
}
