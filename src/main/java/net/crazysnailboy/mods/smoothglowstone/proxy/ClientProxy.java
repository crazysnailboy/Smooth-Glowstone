package net.crazysnailboy.mods.smoothglowstone.proxy;

import net.crazysnailboy.mods.smoothglowstone.init.ModBlocks;


public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders()
	{
		ModBlocks.registerRenders();
//		ModItems.registerRenders();
	}

}
