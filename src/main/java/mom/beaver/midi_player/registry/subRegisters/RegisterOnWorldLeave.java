package mom.beaver.midi_player.registry.subRegisters;

import mom.beaver.midi_player.MidiPlayer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class RegisterOnWorldLeave {
    public static void bootstrap() {
        // reset the jovial ticks played counter to 0 whenever leaving a server
        ClientPlayConnectionEvents.DISCONNECT.register(((handler, client) -> {
            MidiPlayer.LOGGER.info("Disconnecting from server...");
        }));
    }
}
