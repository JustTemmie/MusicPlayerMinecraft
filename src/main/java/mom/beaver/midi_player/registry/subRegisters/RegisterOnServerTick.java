package mom.beaver.midi_player.registry.subRegisters;

import mom.beaver.midi_player.MidiPlayer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.logging.Logger;


public class RegisterOnServerTick {
    public static void bootstrap() {
        ServerTickEvents.END_SERVER_TICK.register((server) -> {
            if (server != null) {
//                MidiPlayer.LOGGER.info("Server Tick!");
            }
        });
    }
}
