package net.ilexiconn.jurassicraft.ai.herds;

import java.util.List;

import javax.vecmath.Vector3d;

import net.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;
import net.ilexiconn.jurassicraft.entity.dinosaurs.EntityVelociraptor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.pathfinding.PathEntity;

public class HerdAISurprise extends EntityAIHerd
{
    private EntityLivingBase theChosenOne;
    private VelociraptorHerd velociraptorHerd;
    
    public HerdAISurprise(EntityJurassiCraftCreature creature)
    {
        super(creature, false); // false, because we don't need (and don't want) the attack targets to be overwritten
    }
    
    @SuppressWarnings("unchecked")
    public void startExecuting()
    {
        super.startExecuting();
        
        CreatureHerd herd = getHerd();
        
        if (herd != null)
        {
            velociraptorHerd = (VelociraptorHerd) getHerd();
          
            EntityJurassiCraftCreature creature = getCreature();
            if (creature.worldObj != null)
            {
                if (creature.boundingBox != null)
                {
                    if (!velociraptorHerd.isSneakingUp())
                    {
                        List<EntityLivingBase> entities = creature.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, creature.boundingBox.expand(32, 32, 32));
                        
                        int i = 0;
                       
                        while (theChosenOne == null || theChosenOne instanceof EntityVelociraptor)
                        {
                            theChosenOne = entities.get((int) (entities.size() * Math.random()));
                            i++;
                            
                            if (i >= 100)
                            {
                                theChosenOne = null;
                                break;
                            }
                        }
                       
                        if (theChosenOne != null)
                            velociraptorHerd.attack(theChosenOne);
                    }
                    else
                        theChosenOne = velociraptorHerd.getCurrentTarget();
                }
            }
        }
    }
    
    public boolean continueExecuting()
    {
        if (theChosenOne == null)
            return false;
        
        if (theChosenOne.isDead) // So sad i crai evrytim
        {
            return false;
        }
        
        EntityJurassiCraftCreature creature = getCreature();
        int index = getHerd().indexOf(creature);
       
        float targetAngle = (float) Math.toRadians((360f / getHerd().size()) * index);
       
        Vector3d chosenPos = new Vector3d(theChosenOne.posX, theChosenOne.posY, theChosenOne.posZ);
        Vector3d creaturePos = new Vector3d(creature.posX, creature.posY, creature.posZ);
       
        float angle = (float) Math.acos(chosenPos.angle(creaturePos));
        float delta = Math.abs(targetAngle - angle);
       
        if (delta < Math.PI / 8f) // We are close enough
        {
            creature.setSneaking(true);
            PathEntity path = creature.getNavigator().getPathToXYZ(theChosenOne.posX, theChosenOne.posY, theChosenOne.posZ);
          
            if (path != null)
            {
                creature.getNavigator().setPath(path, creature.getCreatureSpeed() * 4);
            }
        }
        else
        {
            float speed = (float) (Math.PI / 128f);
            float angleToGo = speed + angle * (Math.signum(targetAngle - angle));
            float dist = 20f;
            float xPos = (float) (Math.cos(angleToGo) * dist - 5 + theChosenOne.posX);
            float zPos = (float) (dist * Math.sin(angleToGo) - 5 + theChosenOne.posZ);
            PathEntity path = creature.getNavigator().getPathToXYZ(xPos, theChosenOne.posY, zPos);
           
            if (path != null)
            {
                creature.getNavigator().setPath(path, creature.getCreatureSpeed() * 4);
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public boolean shouldExecute()
    {
        return (getCreature().getAttackTarget() == null && Math.random() < 1.10) || velociraptorHerd.isSneakingUp(); // TODO: change proba
    }
    
    protected CreatureHerd createHerd()
    {
        return new VelociraptorHerd();
    }
}
