package me.obsilabor.explosivechickens.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveChickenEntity extends ChickenEntity {
    public ExplosiveChickenEntity(EntityType<? extends ChickenEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 3.5F, Explosion.DestructionType.BREAK);
    }
}
