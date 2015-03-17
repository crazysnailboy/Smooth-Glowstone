package net.crazysnailboy.mods.smoothglowstone.init;

import net.crazysnailboy.mods.smoothglowstone.SmoothGlowstone;
import net.crazysnailboy.mods.smoothglowstone.block.ModBlockColorVariantBase;
import net.crazysnailboy.mods.smoothglowstone.block.ModBlockSmoothGlowstone;
import net.crazysnailboy.mods.smoothglowstone.block.ModBlockStainedSmoothGlowstone;
import net.crazysnailboy.mods.smoothglowstone.item.ItemBlockColorVariant;
import net.crazysnailboy.mods.smoothglowstone.item.ModItemBlockSmoothGlowstone;
import net.crazysnailboy.mods.smoothglowstone.item.crafting.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	
	public static Block smooth_glowstone;
	public static Block stained_smooth_glowstone;
	
	
	public static void init()
	{
		smooth_glowstone = new ModBlockSmoothGlowstone(Material.ground).setLightLevel(1.0F).setUnlocalizedName("smooth_glowstone").setCreativeTab(SmoothGlowstone.lightsTab);
		stained_smooth_glowstone = new ModBlockStainedSmoothGlowstone().setUnlocalizedName("stained_smooth_glowstone").setCreativeTab(SmoothGlowstone.lightsTab);
	}

		
	public static void register()
	{
		registerBlock(smooth_glowstone, ModItemBlockSmoothGlowstone.class, ModBlockSmoothGlowstone.EnumType.values());
		registerBlock(stained_smooth_glowstone, ItemBlockColorVariant.class, ModBlockColorVariantBase.EnumColour.values());
		
		ModRecipes.addCraftingRecipes();
		ModRecipes.addSmeltingRecipes();
	}

	
	public static void registerRenders()
	{
		registerInventoryModels(smooth_glowstone, ModBlockSmoothGlowstone.EnumType.values());
		registerInventoryModels(stained_smooth_glowstone, ModBlockColorVariantBase.EnumColour.values());
	}
	
	
	
	
	
	private static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	private static void registerBlock(Block block, Class<? extends ItemBlock> itemclass, Enum[] variants)
	{
		GameRegistry.registerBlock(block, itemclass, block.getUnlocalizedName().substring(5));

		Item itemVariants = Item.getItemFromBlock(block);
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	String variantName = ModBootstrap.MOD_ID + ":" + block.getUnlocalizedName().substring(5) + "_" + variants[i];
	        ModelBakery.addVariantName(itemVariants, variantName);
        }
	}
	

	private static void registerInventoryModel(Block block)
	{	
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModBootstrap.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

	public static void registerInventoryModels(Block block, Enum[] variants)
	{
		Item itemVariants = Item.getItemFromBlock(block);
	    for (int i = 0; i < variants.length ; i++) 
	    {
	    	String unLocalizedName = ModBootstrap.MOD_ID + ":" + itemVariants.getUnlocalizedName().substring(5) + "_" + variants[i]; 
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemVariants, i, new ModelResourceLocation(unLocalizedName, "inventory"));
        }		
	}
	
	
}
