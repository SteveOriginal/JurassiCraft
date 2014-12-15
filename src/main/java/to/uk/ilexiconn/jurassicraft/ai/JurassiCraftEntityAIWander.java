package to.uk.ilexiconn.jurassicraft.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;
import to.uk.ilexiconn.jurassicraft.entity.EntityJurassiCraftCreature;

public class JurassiCraftEntityAIWander extends EntityAIBase {
	private EntityJurassiCraftCreature entity;
	private double xPosition;
	private double yPosition;
	private double zPosition;
	private double speed;
	private double maxDistance;
	private double maxHeight;

	public JurassiCraftEntityAIWander(EntityJurassiCraftCreature creature,
			double distance, double height, double velocity) {
		this.entity = creature;
		this.speed = velocity;
		this.maxDistance = distance;
		this.maxHeight = height;
		this.setMutexBits(1);
	}

	public JurassiCraftEntityAIWander(EntityJurassiCraftCreature creature, double velocity) {
		this.entity = creature;
		this.speed = velocity;
		this.maxDistance = 16;
		this.maxHeight = 6;
		this.setMutexBits(1);
	}
	
	public boolean shouldExecute() {
		if (this.entity.getRNG().nextInt(120) != 0) {
			return false;
		} else {
			Vec3 vec3 = RandomPositionGenerator.findRandomTarget(this.entity,
					(int) (this.maxDistance * Math.sqrt(this.entity
							.getGrowthStage())), (int) this.maxHeight);
			//Now searching range is increased as growth stage increase.
			if (vec3 == null) {
				return false;
			} else {
				this.xPosition = vec3.xCoord;
				this.yPosition = vec3.yCoord;
				this.zPosition = vec3.zCoord;
				return true;
			}
		}
	}

	public void startExecuting() {
		this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition,
				this.zPosition, this.speed);
	}

	public boolean continueExecuting() {
		return !this.entity.getNavigator().noPath();

	}

}
