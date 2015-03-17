package net.crazysnailboy.mods.smoothglowstone.item;

import net.crazysnailboy.mods.smoothglowstone.block.ModBlockColorVariantBase;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockColorVariant extends ItemBlock
{

	public ItemBlockColorVariant(Block block)
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
		ModBlockColorVariantBase.EnumColour colour = ModBlockColorVariantBase.EnumColour.byMetadata(stack.getMetadata());
		return super.getUnlocalizedName() + "." + colour.toString();
	}
}
