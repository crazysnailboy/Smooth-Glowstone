package net.crazysnailboy.mods.smoothglowstone.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockSmoothGlowstone extends Block {

	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", ModBlockSmoothGlowstone.EnumType.class);
	
	
	
	public ModBlockSmoothGlowstone(Material materialIn) {
		super(materialIn);
		this.setLightLevel(1.0F);
		this.setHardness(0.3F);
		this.setStepSound(Block.soundTypeGlass);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.NORMAL));
	}

	
	@Override
	public int damageDropped(IBlockState state)
	{
        return ((ModBlockSmoothGlowstone.EnumType)state.getValue(VARIANT)).getMetadata();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		ModBlockSmoothGlowstone.EnumType[] variants = ModBlockSmoothGlowstone.EnumType.values();
		for (ModBlockSmoothGlowstone.EnumType variant : variants) {
			list.add(new ItemStack(itemIn, 1, variant.getMetadata()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
        return this.getDefaultState().withProperty(VARIANT, ModBlockSmoothGlowstone.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
        return ((ModBlockSmoothGlowstone.EnumType)state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] {VARIANT});
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		ModBlockSmoothGlowstone.EnumType variant = ModBlockSmoothGlowstone.EnumType.byMetadata(meta);
		return this.getDefaultState().withProperty(VARIANT, variant);
	}
	
	
	
	public static enum EnumType implements IStringSerializable
	{
		NORMAL(0, "normal"),
		BORDERED(1, "bordered");

		public int getMetadata()
		{
			return this.meta;
		}

		@Override
		public String toString()
		{
			return this.name;
		}

		public static EnumType byMetadata(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
			{
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName()
		{
			return this.name;
		}

		private final int meta;
		private final String name;
		private static final EnumType[] META_LOOKUP = new EnumType[values().length];

		private EnumType(int i_meta, String i_name)
		{
			this.meta = i_meta;
			this.name = i_name;
		}

		static
		{
			for (EnumType variant : values()) {
				META_LOOKUP[variant.getMetadata()] = variant;
			}
		}
	}
	
	
}
