package net.ilexiconn.jurassicraft.api;

import net.ilexiconn.jurassicraft.api.interfaces.ILargeItem;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ProPercivalalb
 */
public class CarboniferousApi
{
    //Damage Sources
    public static DamageSource brachiopodDamage;
    
    /**
     * Adds a recipe to the grinder.
     * @param input1/input2 The in input items, It can be a...
     * 		  ItemStack e.g. [new ItemStack(ID, AMOUNT, META] In the ItemStack you can be specific what meta, tagcompund, id is needed.
     * 		  Block     e.g. [new Block]
     * 		  Item      e.g. [new Item] Converted into an itemstack with stacksize of 1 and meta of 0. Just ItemStack if you want to be more specific.
     * 		  String    e.g.  "Example" Only use strings if you know what the forge ore dictionary is. (The String is the id String id of the item.
     * 		  *NOTE* You may make the one inputs null if you wish for the recipe to only be a one stack recipe. Both inputs cannot be null!
     * 
     * @param output The output stack. All the NBT data and other values are replicated when made.
     * @return Returns whether the recipe was registered.
     */
    public static boolean addGrinderRecipe(Object input1, Object input2, ItemStack output)
    {
        try
        {
            Class cls = Class.forName("net.ilexiconn.jurassicraft.recipe.GrinderManager");
            
            Method method = cls.getMethod("addGrinderRecipe", ItemStack.class, Object[].class);
            method.invoke(null, output, new Object[] { input1, input2 });
            
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Adds an object that will allow the grinder to run.
     * @param component The ItemStack that is the object
     * @param duration The speed of the grinder is 200, so a duration of 200 will do one item,
     * but can be put to what ever you want
     */
    public static void addGrinderComponent(ItemStack component, int duration, int speedIncrement)
    {
        try
        {
            Class cls = Class.forName("net.ilexiconn.jurassicraft.recipe.CarboniferousRecipes");
            Method meth = cls.getMethod("addGrinderComponent", ItemStack.class, Integer.TYPE, Integer.TYPE);
            meth.invoke(null, component, duration, speedIncrement);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private static final List<ArrayList<Object>> sedimentOres = new ArrayList<ArrayList<Object>>();
    
    public static void addSedimentOre(Block block, int blockMeta)
    {
        ArrayList<Object> ret = new ArrayList<Object>();
        ret.add(block);
        ret.add(blockMeta);
        sedimentOres.add(ret);
    }
    
    public static List<ArrayList<Object>> getSedimentOres()
    {
        return sedimentOres;
    }
    
    /**
     * Registers a biome to generate in the Carboniferous dimension.
     * @param biome The biome you want to register.
     */
    public static void registerBiome(BiomeGenBase biome)
    {
        try
        {
            Class clazz = Class.forName("net.ilexiconn.jurassicraft.world.core.GenLayerBiomesDino");
            Method method = clazz.getMethod("registerBiome", BiomeGenBase.class);
            method.invoke(null, biome);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void registerLargeItem(Item item)
    {
        assert item != null : "Item cannot be equal to null";
        assert item instanceof ILargeItem : "Item must be an instanceof ILargeItem";
        
        try
        {
            MinecraftForgeClient.registerItemRenderer(item, (IItemRenderer) Class.forName("carboniferous.client.renderer.item.ItemLargeRenderer").newInstance());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static DamageSource causeSpearDamage(Entity spear, Entity par1Entity)
    {
        return (new EntityDamageSourceIndirect("spear", spear, par1Entity)).setProjectile();
    }
    
    /**
     * Private Functions (NOT TO BE USED BY OTHER MODDERS)
     */
    private static void setup()
    {
        try
        {
            brachiopodDamage = (DamageSource) Class.forName("net.ilexiconn.jurassicraft.utility.util.DamageSourceBrachiopod").newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    static
    {
        setup();
    }
}
