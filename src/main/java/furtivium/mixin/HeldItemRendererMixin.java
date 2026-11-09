package furtivium.mixin;

import furtivium.item.custom.FurtiviumGladiusItem;
import furtivium.item.custom.FurtiviumGlaiveItem;
import furtivium.item.custom.FurtiviumSpadoneitem;
import furtivium.item.custom.VoidTouchedFurtiviumGlaiveItem;

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
    private void blockPose(AbstractClientPlayerEntity player,
                           float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item,
                           float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci
    ) {

        // Only animate while actively using an item
        if (!player.isUsingItem()) {
            return;
        }

        // Only animate the hand currently being used
        if (hand != player.getActiveHand()) {
            return;
        }

        // Check whether the item is one of our swords
        if (!(item.getItem() instanceof FurtiviumGlaiveItem) && !(item.getItem() instanceof VoidTouchedFurtiviumGlaiveItem)
                && !(item.getItem() instanceof FurtiviumSpadoneitem) && !(item.getItem() instanceof FurtiviumGladiusItem)) {
            return;
        }

        Arm arm = hand == Hand.MAIN_HAND
                ? player.getMainArm()
                : player.getMainArm().getOpposite();

        // Isolate the rendering transformations
        matrices.push();

        if (arm == Arm.RIGHT) {

            // Right-handed blocking pose
            matrices.translate(0.0F, 0.10F, -0.15F);

            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-15.0F));

            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0.0F));

            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-15.0F));

        } else {

            // Left-handed blocking pose
            matrices.translate(-0.20F, -0.10F, -0.15F);

            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-45.0F));

            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(2.0F));

            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0F));
        }
    }

    @Inject(
            method = "renderFirstPersonItem",
            at = @At("RETURN")
    )
    private void resetBlockPose(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item,
                                float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci
    ) {
        if (player.isUsingItem()
                && hand == player.getActiveHand()
                && (item.getItem() instanceof FurtiviumGlaiveItem || item.getItem() instanceof VoidTouchedFurtiviumGlaiveItem
                || item.getItem() instanceof FurtiviumSpadoneitem || item.getItem() instanceof FurtiviumGladiusItem)) {

            matrices.pop();
        }
    }
}