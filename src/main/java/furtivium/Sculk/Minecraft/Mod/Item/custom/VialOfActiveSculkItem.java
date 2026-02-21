package furtivium.Sculk.Minecraft.Mod.Item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.apache.logging.log4j.core.config.Order;

public class VialOfActiveSculkItem extends Item {
    public VialOfActiveSculkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if(user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode) {
            user.emitGameEvent(GameEvent.DRINK);
            return itemStack;
        }
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1000, 4));
        return new ItemStack(Items.GLASS_BOTTLE);
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

}
