package furtivium.Sculk.Minecraft.Mod.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.Vibrations;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(Vibrations.VibrationListener.class)
public abstract class VibrationListenerMixin {

    private static final UUID BLOCKED_UUID =
            UUID.fromString("bb46cef6-0d6d-4f6c-a4b0-4490551611a7");

    @Inject(method = "listen", at = @At("HEAD"), cancellable = true)
    private void blockUuid(World world, GameEvent event, GameEvent.Emitter emitter,
                           org.joml.Vector3d pos, CallbackInfoReturnable<Boolean> cir) {
        Entity source = emitter.sourceEntity();
        Entity cause = emitter.sourceEntity();

        if ((source != null && source.getUuid().equals(BLOCKED_UUID)) ||
                (cause != null && cause.getUuid().equals(BLOCKED_UUID))) {
            cir.setReturnValue(false);
        }
    }
}
