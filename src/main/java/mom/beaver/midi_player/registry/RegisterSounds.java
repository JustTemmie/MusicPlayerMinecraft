package mom.beaver.midi_player.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class RegisterSounds {
    public static final Identifier FREDDY_KALAS_QUOTE_ID = new Identifier("midi_player:freddy-kalas");
    public static SoundEvent FREDDY_KALAS_QUOTE_EVENT = SoundEvent.of(FREDDY_KALAS_QUOTE_ID);
    public static void bootstrap() {
        Registry.register(Registries.SOUND_EVENT, FREDDY_KALAS_QUOTE_ID, FREDDY_KALAS_QUOTE_EVENT);
    }
}
