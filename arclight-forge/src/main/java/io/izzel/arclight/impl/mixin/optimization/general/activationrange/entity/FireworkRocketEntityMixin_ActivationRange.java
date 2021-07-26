package io.izzel.arclight.impl.mixin.optimization.general.activationrange.entity;

import io.izzel.arclight.impl.mixin.optimization.general.activationrange.EntityMixin_ActivationRange;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FireworkRocketEntity.class)
public abstract class FireworkRocketEntityMixin_ActivationRange extends EntityMixin_ActivationRange {

    // @formatter:off
    @Shadow private int life;
    @Shadow public int lifetime;
    @Shadow protected abstract void explode();
    // @formatter:on

    @Override
    public void inactiveTick() {
        super.inactiveTick();
        ++this.life;
        if (!this.level.isClientSide && this.life > this.lifetime) {
            this.explode();
        }
    }
}
