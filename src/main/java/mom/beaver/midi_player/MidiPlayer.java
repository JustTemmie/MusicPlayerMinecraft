package mom.beaver.midi_player;

import mom.beaver.midi_player.registry.*;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MidiPlayer implements ModInitializer {
	public static String MOD_ID = "midi_player";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		LOGGER.info("Hello world");

		RegisterSounds.bootstrap();
		RegisterItems.bootstrap();
	}
}

