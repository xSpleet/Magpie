package xspleet.magpie;

import net.fabricmc.api.ClientModInitializer;
import xspleet.magpie.event.KeyInputHandler;

public class MagpieModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient()
    {
    	KeyInputHandler.register();
    }
}
