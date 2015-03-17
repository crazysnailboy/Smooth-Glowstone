package net.crazysnailboy.mods.smoothglowstone.item;

import net.crazysnailboy.mods.smoothglowstone.block.ModBlockSmoothGlowstone;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ModItemBlockSmoothGlowstone extends ItemBlock
{

	public ModItemBlockSmoothGlowstone(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		ModBlockSmoothGlowstone.EnumType variant = ModBlockSmoothGlowstone.EnumType.byMetadata(stack.getMetadata());
		return super.getUnlocalizedName() + "_" + variant.toString();
	}
}
