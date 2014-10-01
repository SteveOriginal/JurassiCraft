package to.uk.ilexiconn.jurassicraft.entity.dinosaur;

import com.rafamv.bygoneage.enums.BygoneAgeMobsInformation;

import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import to.uk.ilexiconn.jurassicraft.ModItems;
import to.uk.ilexiconn.jurassicraft.Util;
import to.uk.ilexiconn.jurassicraft.ai.JurassiCraftEntityAIFollowFood;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftLandProtective;
import to.uk.ilexiconn.jurassicraft.entity.IDinosaur;

public class EntityBrachiosaur extends EntityJurassiCraftLandProtective implements IDinosaur
{

    public EntityBrachiosaur(World world)
    {
        super(world, (byte) 1, 1);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        // tasks.addTask(2, new EntityAIMate(this, 1.0D));
        tasks.addTask(4, new JurassiCraftEntityAIFollowFood(this, this.getCreatureSpeed()));
        // tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, this.getCreatureSpeed()));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.setCreatureExperiencePoints(5000);
    }

    @Override
    public double getMountedYOffset()
    {
        return (double) this.getYBouningBox() * 0.95D;
    }

    @Override
    public int getTalkInterval()
    {
        return 350;
    }

    @Override
    public String getLivingSound()
    {
        if (this.rand.nextInt(2) == 0)
        {
            return Util.getDinoByID(this.getCreatureID()).livingSound1;
        }
        else
        {
            return Util.getDinoByID(this.getCreatureID()).livingSound2;
        }
    }

    @Override
    public String getHurtSound()
    {
        return Util.getDinoByID(this.getCreatureID()).hurtSound;
    }

    @Override
    public String getDeathSound()
    {
        return Util.getDinoByID(this.getCreatureID()).deathSound;
    }

    @Override
    public Item getDropItem()
    {
        return Util.getMeat(this.getCreatureID());
    }

	@Override
	protected void dropFewItems(boolean recentlyBeenHit, int enchantBonus) 
	{
		float developmentFraction = this.getGrowthStage() / 120.0F;
		int count = Math.round(1 + (4.0F * developmentFraction) + this.rand.nextInt(3 + (int) (4.0F * developmentFraction)) + this.rand.nextInt(2 + enchantBonus));
		if (this.isBurning()) 
		{
			this.dropItem(ModItems.dinoSteak, count);
		} 
		else 
		{
			this.dropItem(Util.getMeat(this.getCreatureID()), count);
		}
	}
}