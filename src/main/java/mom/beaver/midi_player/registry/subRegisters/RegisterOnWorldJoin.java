package mom.beaver.midi_player.registry.subRegisters;

import mom.beaver.midi_player.MidiPlayer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class RegisterOnWorldJoin {
    public static void bootstrap() {
        ClientPlayConnectionEvents.JOIN.register((handler, packetSender, client) -> {
            MidiPlayer.LOGGER.info("Connecting to server...");
        });
    }
}
