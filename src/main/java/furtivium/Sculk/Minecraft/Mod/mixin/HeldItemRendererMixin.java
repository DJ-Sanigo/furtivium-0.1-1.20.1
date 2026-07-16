package furtivium.Sculk.Minecraft.Mod.mixin;

import furtivium.Sculk.Minecraft.Mod.Item.custom.FurtiviumGlaiveItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RotationAxis;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {

    @Inject(
            method = "renderFirstPersonItem",
            at = @At("HEAD")
    )
    private void blockPose(
            AbstractClientPlayerEntity player,
            float tickDelta,
            float pitch,
            Hand hand,
            float swingProgress,
            ItemStack item,
            float equipProgress,
            MatrixStack matrices,
            VertexConsumerProvider vertexConsumers,
            int light,
            CallbackInfo ci
    ) {

        if (!player.isUsingItem()) {
            return;
        }

        if (!(player.getActiveItem().getItem() instanceof FurtiviumGlaiveItem)) {
            return;
        }

        if (hand != player.getActiveHand()) {
            return;
        }

        Arm arm = hand == Hand.MAIN_HAND
                ? player.getMainArm()
                : player.getMainArm().getOpposite();

        if (arm == Arm.RIGHT) {
            matrices.translate(0.20F, -0.10F, -0.15F);
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-90.0F));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0F));
        } else {
            matrices.translate(-0.20F, -0.10F, -0.15F);
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0F));
        }
    }
}
