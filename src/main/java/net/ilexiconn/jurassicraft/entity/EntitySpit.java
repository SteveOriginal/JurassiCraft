package net.ilexiconn.jurassicraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by jnad325 on 3/14/15.
 */
public class EntitySpit extends EntityThrowable {
    public EntitySpit(World world)
    {
        super(world);
    }

    public EntitySpit(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }

    public EntitySpit(World p_i1775_1_, double p_i1775_2_, double p_i1775_4_, double p_i1775_6_)
    {
        super(p_i1775_1_, p_i1775_2_, p_i1775_4_, p_i1775_6_);
    }

    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null && p_70184_1_.entityHit instanceof EntityLivingBase)
        {
            byte b0 = 1;

            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
            ((EntityLivingBase)p_70184_1_.entityHit).addPotionEffect(new PotionEffect(Potion.blindness.id, 300, 1, false));
            ((EntityLivingBase)p_70184_1_.entityHit).addPotionEffect(new PotionEffect(Potion.poison.id, 300, 1, false));

        }

        for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}