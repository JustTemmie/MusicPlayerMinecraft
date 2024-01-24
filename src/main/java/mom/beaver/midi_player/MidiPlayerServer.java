package mom.beaver.midi_player;

import mom.beaver.midi_player.registry.subRegisters.RegisterOnServerTick;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.SERVER)
public class MidiPlayerServer implements DedicatedServerModInitializer {

    @Override
    public void onInitializeServer() {
        RegisterOnServerTick.bootstrap();
    }
}
