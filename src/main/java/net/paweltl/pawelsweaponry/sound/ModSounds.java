package net.paweltl.pawelsweaponry.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.paweltl.pawelsweaponry.PawelsWeaponry;

public class ModSounds {
    public static final SoundEvent WHIP_CRACK = registerSoundEvent("whip_crack");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(PawelsWeaponry.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        PawelsWeaponry.LOGGER.info("Registering Sounds for " + PawelsWeaponry.MOD_ID);
    }
}
