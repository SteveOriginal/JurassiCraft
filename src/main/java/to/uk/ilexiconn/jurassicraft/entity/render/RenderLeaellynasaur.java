package to.uk.ilexiconn.jurassicraft.entity.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import to.uk.ilexiconn.jurassicraft.JurassiCraft;
import to.uk.ilexiconn.jurassicraft.client.model.entity.ModelLeaellynasaur;
import to.uk.ilexiconn.jurassicraft.entity.Dinosaur;
import to.uk.ilexiconn.jurassicraft.entity.dinosaur.EntityLeaellynasaur;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLeaellynasaur extends RenderDinosaur
{
    public RenderLeaellynasaur(Dinosaur dino)
    {
        super(new ModelLeaellynasaur(), dino, 0.45F);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity)
    {
        EntityLeaellynasaur dino = (EntityLeaellynasaur) entity;
        if (dino.isMale())
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leaellynasaura_Male_1.png");
        } 
        else 
        {
            return new ResourceLocation(JurassiCraft.getModId() + "textures/entity/Leaellynasaura_Female_1.png");
        }
    }
}