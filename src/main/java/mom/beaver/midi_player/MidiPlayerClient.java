package mom.beaver.midi_player;

import mom.beaver.midi_player.registry.subRegisters.RegisterOnClientTick;
import mom.beaver.midi_player.registry.subRegisters.RegisterOnWorldJoin;
import mom.beaver.midi_player.registry.subRegisters.RegisterOnWorldLeave;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MidiPlayerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RegisterOnClientTick.bootstrap();
        RegisterOnWorldJoin.bootstrap();
        RegisterOnWorldLeave.bootstrap();
    }
}
