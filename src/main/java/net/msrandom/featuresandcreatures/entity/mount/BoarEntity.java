package net.msrandom.featuresandcreatures.entity.mount;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRideable;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.msrandom.featuresandcreatures.core.FnCEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import javax.annotation.ParametersAreNonnullByDefault;

import static net.msrandom.featuresandcreatures.FeaturesAndCreatures.createEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class BoarEntity extends AbstractAngryMountEntity implements IRideable {
    private static final Ingredient FOODS = Ingredient.of(Items.CARROT);

    public BoarEntity(EntityType<? extends BoarEntity> entityType, World world) {
        super(entityType, world);
    }

    public static @NotNull AttributeModifierMap.MutableAttribute createBoarAttributes() {
        return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 11.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D)
                .add(Attributes.ATTACK_DAMAGE, 8.0F);
    }

    @Override
    protected void registerAdditionalGoals() {
        goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, FOODS));
        goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.CARROT_ON_A_STICK), false));
        goalSelector.addGoal(2, new PanicGoal(this, 1.42D));
        goalSelector.addGoal(2, new BreedGoal(this, 0.8D));
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity playerEntity, Hand hand) {
        if (!playerEntity.isCrouching() && !isFood(playerEntity.getItemInHand(hand)) && isSaddled() && !isVehicle() && !playerEntity.isSecondaryUseActive()) {
            return sidedOperation(serverWorld -> playerEntity.startRiding(this));
        }
        return super.mobInteract(playerEntity, hand);
    }

    @Override
    public @NotNull Ingredient getFoods() {
        return FOODS;
    }

    @Override
    protected <T extends IAnimatable> PlayState getPlayState(AnimationEvent<T> event) {
        AnimationController<?> controller = event.getController();
        controller.transitionLengthTicks = 0;
        int animationTime = getAnimationTime();
        if (event.isMoving() && animationTime <= 0) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.boar.walk", true));
            return PlayState.CONTINUE;
        } else if (animationTime > 0) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.boar.attack", true));
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }

    @Override
    public boolean boost() {
        return false;
    }

    @Override
    public void travelWithInput(Vector3d p_230267_1_) {
    }

    @Override
    public float getSteeringSpeed() {
        return 0;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld serverWorld, AgeableEntity entity) {
        return createEntity(FnCEntities.BOAR.get(), serverWorld, boarEntity -> boarEntity.setAge(-24000));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.PIG_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.PIG_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PIG_DEATH;
    }
}