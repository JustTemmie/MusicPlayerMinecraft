package mom.beaver.midi_player.registry.subRegisters;

import mom.beaver.midi_player.MidiPlayer;
import mom.beaver.midi_player.registry.RegisterSounds;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;

import java.util.UUID;


public class RegisterOnClientTick {

    public static void bootstrap() {
        ClientTickEvents.START_CLIENT_TICK.register((client) -> {
            UUID uuid = client.getSession().getUuidOrNull();
            if (uuid != null && client.world != null) {
                PlayerEntity player = client.world.getPlayerByUuid(uuid);
                if ( player == null ) {
                    return;
                }

//                MidiPlayer.LOGGER.info("Client Tick!");
            }
        });
    }
}
