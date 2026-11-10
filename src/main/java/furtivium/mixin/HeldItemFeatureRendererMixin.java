
package furtivium.mixin;

import furtivium.item.custom.FurtiviumGladiusItem;
import furtivium.item.custom.FurtiviumGlaiveItem;
import furtivium.item.custom.FurtiviumSpadoneitem;
import furtivium.item.custom.VoidTouchedFurtiviumGlaiveItem;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.RotationAxis;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemFeatureRenderer.class)
public abstract class HeldItemFeatureRendererMixin {

    private static boolean isFurtiviumGlaive(ItemStack stack) {
        return stack.getItem() instanceof FurtiviumGlaiveItem || stack.getItem() instanceof VoidTouchedFurtiviumGlaiveItem;
    }

    private static boolean isFurtiviumSpadone(ItemStack stack) {
        return stack.getItem() instanceof FurtiviumSpadoneitem;
    }

    private static boolean isFurtiviumGladius(ItemStack stack) {
        return stack.getItem() instanceof FurtiviumGladiusItem;
    }

    @Inject(
            method = "renderItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"
            )
    )
    private void applyThirdPersonBlockingPose(LivingEntity entity, ItemStack stack, ModelTransformationMode
            transformationMode, Arm arm, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci
    ) {

        // Only apply the pose while actively using a Furtivium sword.
        if (!entity.isUsingItem()) return;

        if (entity.getActiveItem() != stack) return;

        if (!isFurtiviumGlaive(stack)) return;

        // Determine which side is holding the sword.
        float side = arm == Arm.RIGHT ? 1.0F : -1.0F;

        // Original Minecraft 1.8-style blocking rotations.
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-40.0F));

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0.0F));

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0.0F));
    }

    @Inject(
            method = "renderItem",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"
            )
    )
    private void applyThirdPersonParryingPose(LivingEntity entity, ItemStack stack, ModelTransformationMode
            transformationMode, Arm arm, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci
    ) {

        // Only apply the pose while actively using a Furtivium sword.
        if (!entity.isUsingItem()) return;

        if (entity.getActiveItem() != stack) return;

        if (!isFurtiviumSpadone(stack)) return;

        // Determine which side is holding the sword.
        float side = arm == Arm.RIGHT ? 1.0F : -1.0F;

        // Original Minecraft 1.8-style blocking rotations.
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-35.0F));

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(30.0F));

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-25.0F));
    }

}
