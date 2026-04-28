package furtivium.Sculk.Minecraft.Mod.mixin;

import furtivium.Sculk.Minecraft.Mod.Item.ModItems;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class ArmPoseMixin {

    @Inject(method = "getArmPose", at = @At("HEAD"), cancellable = true)
    private static void render(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<BipedEntityModel.ArmPose> cir) {
        if (player.getStackInHand(hand).isOf(ModItems.FURTIVIUM_GLAVE)) {
            if (!player.isUsingItem() && !player.handSwinging) {
                cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_CHARGE);
            } else if (player.handSwinging) {
                cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
            }
        }

        if (player.getStackInHand(hand).isOf(ModItems.FURTIVIUM_SPADONE)) {
            if (!player.isUsingItem() && !player.handSwinging) {
                cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_CHARGE);
            } else if (player.handSwinging) {
                cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_HOLD);
            }
        }

    }

}