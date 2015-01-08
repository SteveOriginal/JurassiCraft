package net.ilexiconn.jurassicraft.entity;

import java.util.ArrayList;
import java.util.Random;

import net.ilexiconn.jurassicraft.config.JsonCreatureDefinition;
import net.ilexiconn.jurassicraft.item.ItemDNA;
import net.ilexiconn.jurassicraft.item.ItemDinoEgg;
import net.ilexiconn.jurassicraft.item.ItemDinoMeat;
import net.ilexiconn.jurassicraft.item.ItemDinoSteak;
import net.ilexiconn.jurassicraft.item.ItemMammalSyringe;
import net.ilexiconn.jurassicraft.item.drops.ItemFeather;
import net.ilexiconn.jurassicraft.item.drops.ItemFur;
import net.ilexiconn.jurassicraft.item.drops.ItemScale;
import net.ilexiconn.jurassicraft.item.drops.ItemSkin;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Creature
{
    private byte creatureID;
    private byte addItemTypes;

    private String creatureName;
    private ArrayList<String> livingSounds;
    private String hurtSound;
    private String deathSound;

    private double minHealth;
    private double minStrength;
    private double minSpeed;
    private double minKnockback;
    private double minProximate;
    private double minMinerals;
    private double minVitamins;
    private double minLipids;
    private double maxHealth;
    private double maxStrength;
    private double maxSpeed;
    private double maxKnockback;
    private double ridingSpeed;

    private float adultAge;
    private float minLength;
    private float minHeight;
    private float maxLength;
    private float maxHeight;
    private float xzBoxMin;
    private float yBoxMin;
    private float xzBoxDelta;
    private float yBoxDelta;
    private float scaleAdjustment;

    private int ticksToAdulthood;
    private int cultivateSpeed;
    private int textureCount;
    private int ridingStyle;
    private int numberOfInfoPages;

    private ArrayList favoriteFoodList;
    private ArrayList ridingItemList;

    private boolean isRidable;
    private boolean canBeTamedUponSpawning;
    private boolean waterCreature;
    private boolean flyingCreature;

    private ItemDinoEgg egg;
    private ItemMammalSyringe syringe;
    private ItemDinoMeat meat;
    private ItemDinoSteak steak;
    private ItemFur fur;
    private ItemSkin skin;
    private ItemScale scale;
    private ItemFeather feather;
    private ItemDNA dna;

    private String creatureCategory;

    public Creature(String creatureCategory, JsonCreatureDefinition def)
    {
        this.creatureCategory = creatureCategory;

        this.adultAge = def.adultAge;
        this.canBeTamedUponSpawning = def.canBeTamedUponSpawning;
        this.creatureID = def.creatureID;
        this.creatureName = def.creatureName;
        this.cultivateSpeed = def.cultivateSpeed;
        this.deathSound = def.deathSound;
        this.favoriteFoodList = def.favoriteFoodList;
        this.hurtSound = def.hurtSound;
        this.isRidable = def.isRidable;
        this.livingSounds = def.livingSounds;
        this.maxHealth = def.maxHealth;
        this.maxHeight = def.maxHeight;
        this.maxKnockback = def.maxKnockback;
        this.maxLength = def.maxLength;
        this.maxSpeed = def.maxSpeed;
        this.maxStrength = def.maxStrength;
        this.minHealth = def.minHealth;
        this.minHeight = def.minHeight;
        this.minKnockback = def.minKnockback;
        this.minLength = def.minLength;
        this.minLipids = def.minLipids;
        this.minMinerals = def.minMinerals;
        this.minProximate = def.minProximate;
        this.minSpeed = def.minSpeed;
        this.minStrength = def.minStrength;
        this.minVitamins = def.minVitamins;
        this.numberOfInfoPages = def.numberOfInfoPages;
        this.textureCount = def.numberOfTextures;
        this.ridingItemList = def.ridingItemList;
        this.ridingSpeed = def.ridingSpeed;
        this.ridingStyle = def.ridingStyle;
        this.scaleAdjustment = def.scaleAdjustment;
        this.ticksToAdulthood = def.ticksToAdulthood;
        this.waterCreature = def.waterCreature;
        this.flyingCreature = def.flyingCreature;
        this.xzBoxDelta = def.xzBoxDelta;
        this.xzBoxMin = def.xzBoxMin;
        this.yBoxDelta = def.yBoxDelta;
        this.yBoxMin = def.yBoxMin;
        this.addItemTypes = def.addItemTypes;

        if (!def.creatureName.equals("Santa")) {
        	switch (def.addItemTypes) 
    		{
    			case 0:
    				/** DNA + Meat + Egg */
    				this.dna = new ItemDNA(this.creatureName);
    				this.egg = new ItemDinoEgg(this.creatureName);
    				this.meat = new ItemDinoMeat(this.creatureName);
    				this.steak = new ItemDinoSteak(this.creatureName);
    				GameRegistry.registerItem(this.dna, this.dna.getUnlocalizedName());
    				GameRegistry.registerItem(this.egg, this.egg.getUnlocalizedName());
    				GameRegistry.registerItem(this.meat, this.meat.getUnlocalizedName());
    				GameRegistry.registerItem(this.steak, this.steak.getUnlocalizedName());
    				GameRegistry.addSmelting(new ItemStack(this.meat), new ItemStack(this.steak), 0.0F);
    				break;
    			case 1:
    				/** DNA + Meat + Syringe */
    				this.dna = new ItemDNA(this.creatureName);
    				this.meat = new ItemDinoMeat(this.creatureName);
    				this.steak = new ItemDinoSteak(this.creatureName);
    				this.syringe = new ItemMammalSyringe(this.creatureName);
    				GameRegistry.registerItem(this.dna, this.dna.getUnlocalizedName());
    				GameRegistry.registerItem(this.meat, this.meat.getUnlocalizedName());
    				GameRegistry.registerItem(this.steak, this.steak.getUnlocalizedName());
    				GameRegistry.registerItem(this.syringe, this.syringe.getUnlocalizedName());
    				GameRegistry.addSmelting(new ItemStack(this.meat), new ItemStack(this.steak), 0.0F);
    				break;
    			case 2:
    				/** DNA + Meat + Egg + Scales */
    				this.dna = new ItemDNA(this.creatureName);
    				this.egg = new ItemDinoEgg(this.creatureName);
    				this.meat = new ItemDinoMeat(this.creatureName);
    				this.steak = new ItemDinoSteak(this.creatureName);
    				this.scale = new ItemScale(this.creatureName);
    				GameRegistry.registerItem(this.dna, this.dna.getUnlocalizedName());
    				GameRegistry.registerItem(this.egg, this.egg.getUnlocalizedName());
    				GameRegistry.registerItem(this.meat, this.meat.getUnlocalizedName());
    				GameRegistry.registerItem(this.steak, this.steak.getUnlocalizedName());
    				GameRegistry.registerItem(this.scale, this.scale.getUnlocalizedName());
    				GameRegistry.addSmelting(new ItemStack(this.meat), new ItemStack(this.steak), 0.0F);
    				break;
    			default:
    				/** DNA + Meat + Egg */
    				this.dna = new ItemDNA(this.creatureName);
    				this.egg = new ItemDinoEgg(this.creatureName);
    				this.meat = new ItemDinoMeat(this.creatureName);
    				this.steak = new ItemDinoSteak(this.creatureName);
    				GameRegistry.registerItem(this.dna, this.dna.getUnlocalizedName());
    				GameRegistry.registerItem(this.egg, this.egg.getUnlocalizedName());
    				GameRegistry.registerItem(this.meat, this.meat.getUnlocalizedName());
    				GameRegistry.registerItem(this.steak, this.steak.getUnlocalizedName());
    				GameRegistry.addSmelting(new ItemStack(this.meat), new ItemStack(this.steak), 0.0F);
    		}
        }
    }

    public String pickLivingSound()
    {
        Random rand = new Random();

        return getLivingSound(rand.nextInt(livingSounds.size()));
    }

    public String getDeathSound()
    {
        return this.deathSound;
    }

    public String getHurtSound()
    {
        return this.hurtSound;
    }

    public String getCreatureName()
    {
        return this.creatureName;
    }

    public String getCreatureCategory()
    {
        return this.creatureCategory;
    }

    public byte getCreatureID()
    {
        return this.creatureID;
    }

    public boolean isWaterCreature()
    {
        return this.waterCreature;
    }

    public boolean isFlyingCreature()
    {
        return this.flyingCreature;
    }

    public ItemDNA getDNA()
    {
        return this.dna;
    }

    public ItemDinoMeat getMeat()
    {
        return this.meat;
    }

    public ItemDinoSteak getSteak()
    {
        return this.steak;
    }

    public ItemFur getFur()
    {
        return this.fur;
    }

    public ItemSkin getSkin()
    {
        return this.skin;
    }

    public ItemScale getScale()
    {
        return this.scale;
    }

    public ItemFeather getFeather()
    {
        return this.feather;
    }

    public boolean isRidingItem(Item item)
    {
        if (this.ridingItemList != null && item != null)
        {
            return this.ridingItemList.contains(item);
        }
        return false;
    }

    public boolean isRidable()
    {
        return this.isRidable;
    }

    public int getRidingStyle()
    {
        return this.ridingStyle;
    }

    public boolean isFavoriteFood(Item item)
    {
        if (this.favoriteFoodList != null && item != null)
        {
            return this.favoriteFoodList.contains(item);
        }
        return false;
    }

    public boolean canBeTamedUponSpawning()
    {
        return this.canBeTamedUponSpawning;
    }

    public int getInfoPageCount()
    {
        return this.numberOfInfoPages;
    }

    public String getLivingSound(int soundIndex)
    {
        if (soundIndex >= this.livingSounds.size())
        {
            soundIndex = this.livingSounds.size() - 1;
        }

        String sound = this.livingSounds.get(soundIndex);

        if (sound == "")
        {
            return null;
        }
        else
        {
            return sound;
        }
    }

    public float getMaxLength()
    {
        return this.maxLength;
    }

    public float getMaxHeight()
    {
        return this.maxHeight;
    }

    public double getMaxHealth()
    {
        return this.maxHealth;
    }

    public double getMinHealth()
    {
        return this.minHealth;
    }

    public double getTicksToAdulthood()
    {
        return this.ticksToAdulthood;
    }

    public double getMaxStrength()
    {
        return this.maxStrength;
    }

    public double getMinStrength()
    {
        return this.minStrength;
    }

    public double getMaxSpeed()
    {
        return this.maxSpeed;
    }

    public double getMinSpeed()
    {
        return this.minSpeed;
    }

    public double getMaxKnockback()
    {
        return this.maxKnockback;
    }

    public double getMinKnockback()
    {
        return this.minKnockback;
    }

    public double getYBoxMin()
    {
        return this.yBoxMin;
    }

    public double getYBoxDelta()
    {
        return this.yBoxDelta;
    }

    public double getXzBoxMin()
    {
        return this.xzBoxMin;
    }

    public double getXzBoxDelta()
    {
        return this.xzBoxDelta;
    }

    public float getScaleAdjustment()
    {
        return this.scaleAdjustment;
    }

    public float getMinHeight()
    {
        return this.minHeight;
    }

    public float getMinLength()
    {
        return this.minLength;
    }

    public float getAdultAge()
    {
        return this.adultAge;
    }

    public int getTextureCount()
    {
        return this.textureCount;
    }

    public ItemDinoEgg getEgg()
    {
        return this.egg;
    }

    public ItemMammalSyringe getMammalSyringe()
    {
        return this.syringe;
    }

    public double getMinProximate()
    {
        return this.minProximate;
    }

    public double getMinVitamins()
    {
        return this.minVitamins;
    }

    public double getMinLipids()
    {
        return this.minLipids;
    }

    public double getMinMinerals()
    {
        return this.minMinerals;
    }

    public int getCultivateSpeed()
    {
        return this.cultivateSpeed;
    }

    public byte getAddedItemTypes()
    {
        return this.addItemTypes;
    }
}
