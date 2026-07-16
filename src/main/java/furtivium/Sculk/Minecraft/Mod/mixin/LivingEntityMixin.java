package furtivium.Sculk.Minecraft.Mod.mixin;

import furtivium.Sculk.Minecraft.Mod.Item.custom.FurtiviumGlaiveItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @ModifyVariable(
            method = "damage",
            at = @At("HEAD"),
            ordinal = 0,
            argsOnly = true
    )
    private float blockDamage(float amount, DamageSource source) {

        LivingEntity self = (LivingEntity) (Object) this;

        if (!(self instanceof PlayerEntity player)) {
            return amount;
        }

        if (!player.isUsingItem()) {
            return amount;
        }

        ItemStack active = player.getActiveItem();

        if (!(active.getItem() instanceof FurtiviumGlaiveItem)) {
            return amount;
        }

        return amount * 0.5F;
    }
}
