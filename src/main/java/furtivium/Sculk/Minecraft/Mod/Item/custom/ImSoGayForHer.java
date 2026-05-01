package furtivium.Sculk.Minecraft.Mod.Item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ImSoGayForHer extends SwordItem {
    public ImSoGayForHer(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
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

        double dashStrength = 1.6;
        double upwardBoost = 0.12;

        Vec3d currentVel = user.getVelocity();

        Vec3d newVel = currentVel.add(
                horizontalLook.x * dashStrength,
                upwardBoost,
                horizontalLook.z * dashStrength
        );
        user.setVelocity(newVel);
        user.velocityModified = true;

        return TypedActionResult.success(stack);

        }
    }

    //we all say thank you counter strike i mean noelle


