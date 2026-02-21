package furtivium.Sculk.Minecraft.Mod.sound;

import furtivium.Sculk.Minecraft.Mod.Furtivium;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent FURTIVIUM_BLOCK_BREAK = registerSoundEvent("furtivium_block_break");
    public static final SoundEvent FURTIVIUM_BLOCK_STEP = registerSoundEvent("furtivium_block_step");
    public static final SoundEvent FURTIVIUM_BLOCK_PLACE = registerSoundEvent("furtivium_block_place");
    public static final SoundEvent FURTIVIUM_BLOCK_HIT = registerSoundEvent("furtivium_block_hit");
    public static final SoundEvent FURTIVIUM_BLOCK_FALL = registerSoundEvent("furtivium_block_fall");


    public static final SoundEvent A_WARDENS_LULLABY = registerSoundEvent("a_wardens_lullaby");
    public static final SoundEvent A_WARDENS_LULLABY_MUSIC_BOX_VERSION = registerSoundEvent("a_wardens_lullaby_music_box_version");


    public static final BlockSoundGroup FURTIVIUM_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            ModSounds.FURTIVIUM_BLOCK_BREAK, ModSounds.FURTIVIUM_BLOCK_STEP, ModSounds.FURTIVIUM_BLOCK_PLACE,
            ModSounds.FURTIVIUM_BLOCK_HIT, ModSounds.FURTIVIUM_BLOCK_FALL);

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Furtivium.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Furtivium.LOGGER.info("Registering Sounds for " + Furtivium.MOD_ID);
    }
}
