package net.crazysnailboy.mods.smoothglowstone;

import net.crazysnailboy.mods.smoothglowstone.init.ModBlocks;
import net.crazysnailboy.mods.smoothglowstone.init.ModBootstrap;
import net.crazysnailboy.mods.smoothglowstone.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = ModBootstrap.MOD_ID, name = ModBootstrap.MOD_NAME, version = ModBootstrap.VERSION)
public class SmoothGlowstone {

	private static final String CLIENT_PROXY_CLASS = "net.crazysnailboy.mods.smoothglowstone.proxy.ClientProxy";
	private static final String SERVER_PROXY_CLASS = "net.crazysnailboy.mods.smoothglowstone.proxy.CommonProxy";

	
	
	public static CreativeTabs lightsTab = new CreativeTabs("tabGlowstone")
	{
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(Blocks.glowstone);
		}
	};
	
	
	
	
	@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModBlocks.init();
//		ModItems.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModBlocks.register();
//		ModItems.register();

		proxy.registerRenders();
	}
	
//	@EventHandler
//	public void postInit(FMLPostInitializationEvent event)
//	{
//	}
	
	
}
