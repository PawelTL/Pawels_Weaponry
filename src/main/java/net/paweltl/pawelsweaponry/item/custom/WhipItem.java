package net.paweltl.pawelsweaponry.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.paweltl.pawelsweaponry.PawelsWeaponry;
import net.paweltl.pawelsweaponry.init.CompatInit;
import net.paweltl.pawelsweaponry.sound.ModSounds;

public class WhipItem extends SwordItem {

    private final float attackDamage;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public WhipItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.attackDamage = (float)attackDamage + toolMaterial.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        if (!CompatInit.isBetterCombatLoaded && CompatInit.isReachEntityAttributesLoaded) {
            builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier("Weapon modifier", 1, EntityAttributeModifier.Operation.ADDITION));
            builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier("Weapon modifier", 1.5, EntityAttributeModifier.Operation.ADDITION));
        }
        this.attributeModifiers = builder.build();
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getItemCooldownManager().isCoolingDown(stack.getItem())) {
            Vec3d playerVec = user.getRotationVecClient();
            entity.addVelocity(-playerVec.x * 1.5, -playerVec.y * 0.5, -playerVec.z * 1.5);
            user.getItemCooldownManager().set(stack.getItem(), 100);
            user.getWorld().playSound(null, user.getBlockPos(), ModSounds.WHIP_CRACK, SoundCategory.PLAYERS, 0.8f, 0.8f);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }
}
