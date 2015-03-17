package net.crazysnailboy.mods.smoothglowstone.item.crafting;

import net.crazysnailboy.mods.smoothglowstone.block.ModBlockSmoothGlowstone;
import net.crazysnailboy.mods.smoothglowstone.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	
	public static void addCraftingRecipes()
	{
		// bordered smooth glowstone from normal 
		addSquareRecipe(
			new ItemStack(ModBlocks.smooth_glowstone, 4, ModBlockSmoothGlowstone.EnumType.BORDERED.getMetadata()),
			new ItemStack(ModBlocks.smooth_glowstone, 1, ModBlockSmoothGlowstone.EnumType.NORMAL.getMetadata())
		);

		// dyeing recipes for stained variants of bordered smooth glowstone 
		addDyeingRecipes(
			ModBlocks.stained_smooth_glowstone, 
			new ItemStack(ModBlocks.smooth_glowstone, 1, ModBlockSmoothGlowstone.EnumType.BORDERED.getMetadata())
		);
	}
	
	
	public static void addSmeltingRecipes()
	{
		GameRegistry.addSmelting(Blocks.glowstone, new ItemStack(ModBlocks.smooth_glowstone, 1, ModBlockSmoothGlowstone.EnumType.NORMAL.getMetadata()), 0.3F);
	}
	
	
	
	
	
	
	
	private static void addSquareRecipe(ItemStack output, ItemStack input)
	{
		GameRegistry.addRecipe(output, new Object[] { "##", "##", '#', input });
	}
	
	
	private static void addDyeingRecipes(Block output, ItemStack input)
	{
        for (int i = 0; i < 16; i++) 
        {
             GameRegistry.addRecipe(new ItemStack(output, 8, i), "BBB", "BDB", "BBB", 'B', input, 'D', new ItemStack(Items.dye, 1, 15 - i));
        }		
  	}
	
}
