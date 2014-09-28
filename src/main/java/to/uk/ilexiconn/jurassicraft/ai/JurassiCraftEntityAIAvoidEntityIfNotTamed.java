package to.uk.ilexiconn.jurassicraft.ai;

import net.minecraft.entity.ai.EntityAIAvoidEntity;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandCoward;

public class JurassiCraftEntityAIAvoidEntityIfNotTamed extends EntityAIAvoidEntity
{

    private EntityJurassiCraftLandCoward cowardCreature;
    
    public JurassiCraftEntityAIAvoidEntityIfNotTamed(EntityJurassiCraftLandCoward coward, Class avoidClass, float distanceFromEntity, double farSpeed, double p_i1616_6_)
    {
    	super(coward, avoidClass, distanceFromEntity, farSpeed, p_i1616_6_);
    	this.cowardCreature = coward;
        this.setMutexBits(1);
    }

    @Override
    public boolean shouldExecute()
    {
        return !this.cowardCreature.isTamed() && super.shouldExecute();
    }
}