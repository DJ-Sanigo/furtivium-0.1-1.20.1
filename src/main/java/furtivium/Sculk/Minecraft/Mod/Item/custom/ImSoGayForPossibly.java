package furtivium.Sculk.Minecraft.Mod.Item.custom;

import com.mojang.authlib.yggdrasil.response.User;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ImSoGayForPossibly extends SwordItem {
    public ImSoGayForPossibly(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);


        if (world.isClient) {
         return TypedActionResult.pass(stack);
        }

        if (user.getItemCooldownManager().isCoolingDown(this)) {
            return TypedActionResult.fail(stack);
        }
        Vec3d look = user.getRotationVec(1.0f);

        Vec3d horizontalLook = new Vec3d(look.x, 0, look.z).normalize();

        double dashStrength = 0;
        double upwardBoost = 1.5;

        Vec3d currentVel = user.getVelocity();

        Vec3d newVel = currentVel.add(
                horizontalLook.x * dashStrength,
                upwardBoost,
                horizontalLook.z * dashStrength
        );
        user.setVelocity(newVel);
        user.velocityModified = true;

        world.playSound(
                null,
                user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_WARDEN_SONIC_BOOM,
                SoundCategory.PLAYERS,
                3.0F,
                10.0F
        );

        //ServerWorld serverWorld = (ServerWorld) world;//Under Construction
        //for (int i = 0; i < 40; i++) {
            //Vec3d pos =
        //}

        user.getItemCooldownManager().set(this, 150);

        return TypedActionResult.success(stack);



        }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && !player.getWorld().isClient) {


            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.SPEED,
                    50,
                    3
            ));

            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.WEAKNESS,
                    100,
                    0
            ));

        }

        return super.postHit(stack, target, attacker);

    }

}

    //we all say thank you counter strike i mean noelle


