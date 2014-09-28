package to.uk.ilexiconn.jurassicraft.entity.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntityAnkylosaur;
import to.uk.ilexiconn.jurassicraft.entity.model.ModelAnkylosaur;

@SideOnly(Side.CLIENT)
public class RenderAnkylosaur extends RenderDinosaur
{
    public RenderAnkylosaur(Dinosaur dino)
    {
        super(new ModelAnkylosaur(), dino, 0.5F);
    }

    public ResourceLocation getEntityTexture(Entity var1)
    {
        EntityAnkylosaur dino = (EntityAnkylosaur) var1;
        switch (dino.getCreatureTexture())
        {
            case 0:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/ankylosaur1.png");
            case 1:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/ankylosaur2.png");
            default:
                return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/ankylosaur1.png");
        }
    }
}
