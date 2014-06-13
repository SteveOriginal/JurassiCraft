// Date: 13.06.2014 13:30:47
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.ilexiconn.jurassicraft.data.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMeganeura extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Arm_11;
    ModelRenderer Arm_21;
    ModelRenderer _Arm_31;
    ModelRenderer Arm_41;
    ModelRenderer Arm_51;
    ModelRenderer Arm_61;
    ModelRenderer Arm_12;
    ModelRenderer Arm_22;
    ModelRenderer Arm_32;
    ModelRenderer Arm_42;
    ModelRenderer Arm_52;
    ModelRenderer Arm_62;
    ModelRenderer Wing_1;
    ModelRenderer Wing_2;
    ModelRenderer Wing_3;
    ModelRenderer Wing_4;
  
  public ModelMeganeura()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      Body = new ModelRenderer(this, 30, 0);
      Body.addBox(0F, 0F, 0F, 3, 2, 25);
      Body.setRotationPoint(-1.5F, 10F, -8F);
      Body.setTextureSize(128, 128);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 47, 30);
      Head.addBox(0F, 0F, 0F, 5, 3, 5);
      Head.setRotationPoint(-2.5F, 9.5F, -12F);
      Head.setTextureSize(128, 128);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Arm_11 = new ModelRenderer(this, 90, 0);
      Arm_11.addBox(0F, 0F, 0F, 6, 1, 1);
      Arm_11.setRotationPoint(1.5F, 11F, -3F);
      Arm_11.setTextureSize(128, 128);
      Arm_11.mirror = true;
      setRotation(Arm_11, 0F, 0.2617994F, 0.5235988F);
      Arm_21 = new ModelRenderer(this, 90, 3);
      Arm_21.addBox(0F, 0F, 0F, 6, 1, 1);
      Arm_21.setRotationPoint(1.5F, 11F, -1F);
      Arm_21.setTextureSize(128, 128);
      Arm_21.mirror = true;
      setRotation(Arm_21, 0F, 0F, 0.5235988F);
      _Arm_31 = new ModelRenderer(this, 90, 6);
      _Arm_31.addBox(0F, 0F, 0F, 6, 1, 1);
      _Arm_31.setRotationPoint(1.5F, 11F, 1F);
      _Arm_31.setTextureSize(128, 128);
      _Arm_31.mirror = true;
      setRotation(_Arm_31, 0F, -0.2617994F, 0.5235988F);
      Arm_41 = new ModelRenderer(this, 12, 0);
      Arm_41.addBox(-6F, 0F, 0F, 6, 1, 1);
      Arm_41.setRotationPoint(-1.5F, 11F, -3F);
      Arm_41.setTextureSize(128, 128);
      Arm_41.mirror = true;
      setRotation(Arm_41, 0F, -0.2617994F, -0.5235988F);
      Arm_51 = new ModelRenderer(this, 12, 3);
      Arm_51.addBox(-6F, 0F, 0F, 6, 1, 1);
      Arm_51.setRotationPoint(-1.5F, 11F, -1F);
      Arm_51.setTextureSize(128, 128);
      Arm_51.mirror = true;
      setRotation(Arm_51, 0F, 0F, -0.5235988F);
      Arm_61 = new ModelRenderer(this, 12, 6);
      Arm_61.addBox(-6F, 0F, 0F, 6, 1, 1);
      Arm_61.setRotationPoint(-1.5F, 11F, 1F);
      Arm_61.setTextureSize(128, 128);
      Arm_61.mirror = true;
      setRotation(Arm_61, 0F, 0.2617994F, -0.5235988F);
      Arm_12 = new ModelRenderer(this, 90, 10);
      Arm_12.addBox(-3F, 0F, 0F, 3, 1, 1);
      Arm_12.setRotationPoint(5.5F, 14F, -4F);
      Arm_12.setTextureSize(128, 128);
      Arm_12.mirror = true;
      setRotation(Arm_12, 0F, 0.2617994F, -0.5235988F);
      Arm_22 = new ModelRenderer(this, 90, 13);
      Arm_22.addBox(-3F, 0F, 0F, 3, 1, 1);
      Arm_22.setRotationPoint(5.5F, 14F, -1F);
      Arm_22.setTextureSize(128, 128);
      Arm_22.mirror = true;
      setRotation(Arm_22, 0F, 0F, -0.5235988F);
      Arm_32 = new ModelRenderer(this, 90, 16);
      Arm_32.addBox(-3F, 0F, 0F, 3, 1, 1);
      Arm_32.setRotationPoint(5.5F, 14F, 2F);
      Arm_32.setTextureSize(128, 128);
      Arm_32.mirror = true;
      setRotation(Arm_32, 0F, -0.2617994F, -0.5235988F);
      Arm_42 = new ModelRenderer(this, 18, 10);
      Arm_42.addBox(0F, 0F, 0F, 3, 1, 1);
      Arm_42.setRotationPoint(-5.5F, 14F, 2F);
      Arm_42.setTextureSize(128, 128);
      Arm_42.mirror = true;
      setRotation(Arm_42, 0F, 0.2617994F, 0.5235988F);
      Arm_52 = new ModelRenderer(this, 18, 13);
      Arm_52.addBox(0F, 0F, 0F, 3, 1, 1);
      Arm_52.setRotationPoint(-5.5F, 14F, -1F);
      Arm_52.setTextureSize(128, 128);
      Arm_52.mirror = true;
      setRotation(Arm_52, 0F, 0F, 0.5235988F);
      Arm_62 = new ModelRenderer(this, 18, 16);
      Arm_62.addBox(0F, 0F, 0F, 3, 1, 1);
      Arm_62.setRotationPoint(-5.5F, 14F, -4F);
      Arm_62.setTextureSize(128, 128);
      Arm_62.mirror = true;
      setRotation(Arm_62, 0F, -0.2617994F, 0.5061455F);
      Wing_1 = new ModelRenderer(this, 0, 40);
      Wing_1.addBox(0F, 0F, 0F, 20, 0, 7);
      Wing_1.setRotationPoint(0.5F, 10F, -4F);
      Wing_1.setTextureSize(128, 128);
      Wing_1.mirror = true;
      setRotation(Wing_1, 0F, 0.5235988F, -0.0872665F);
      Wing_2 = new ModelRenderer(this, 60, 40);
      Wing_2.addBox(0F, 0F, 0F, 20, 0, 7);
      Wing_2.setRotationPoint(0F, 10F, -4F);
      Wing_2.setTextureSize(128, 128);
      Wing_2.mirror = true;
      setRotation(Wing_2, 0F, -0.5235988F, -3.054326F);
      Wing_3 = new ModelRenderer(this, 60, 40);
      Wing_3.addBox(0F, 0F, 0F, 20, 0, 7);
      Wing_3.setRotationPoint(-1F, 10.1F, -1F);
      Wing_3.setTextureSize(128, 128);
      Wing_3.mirror = true;
      setRotation(Wing_3, 0F, 0.071259F, -3.141593F);
      Wing_4 = new ModelRenderer(this, 0, 40);
      Wing_4.addBox(0F, 0F, 0F, 20, 0, 7);
      Wing_4.setRotationPoint(1F, 10.1F, -1F);
      Wing_4.setTextureSize(128, 128);
      Wing_4.mirror = true;
      setRotation(Wing_4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Body.render(f5);
    Head.render(f5);
    Arm_11.render(f5);
    Arm_21.render(f5);
    _Arm_31.render(f5);
    Arm_41.render(f5);
    Arm_51.render(f5);
    Arm_61.render(f5);
    Arm_12.render(f5);
    Arm_22.render(f5);
    Arm_32.render(f5);
    Arm_42.render(f5);
    Arm_52.render(f5);
    Arm_62.render(f5);
    Wing_1.render(f5);
    Wing_2.render(f5);
    Wing_3.render(f5);
    Wing_4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}