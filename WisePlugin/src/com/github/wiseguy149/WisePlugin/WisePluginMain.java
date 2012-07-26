package com.github.wiseguy149.WisePlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WisePluginMain extends JavaPlugin
{

	private WisePluginCommandExecutor myExecutor = null;
	private WisePluginBlockListener myListener = null;
	private int commentChance = 0;
	private Random commentRand = null;
	private Map<String, Boolean> map = null;
	
	public void onEnable()
	{
		getLogger().info("WisePlugin is beginning loading....");
		
		this.myExecutor = new WisePluginCommandExecutor(this);
		getCommand("stalk").setExecutor(myExecutor);

		this.myListener = new WisePluginBlockListener(this);
		getServer().getPluginManager().registerEvents(myListener, this);
		
		commentChance = 5; //in 100
		commentRand = new Random();
		map = new HashMap<String, Boolean>(Bukkit.getServer().getMaxPlayers());
		
		getLogger().info("WisePlugin has finished loading!");
	}
	
	public void onDisable()
	{
		getLogger().info("WisePlugin has begun disabling....");
		
		//wat do
		
		getLogger().info("WisePlugin has finished disabling!");
	}

	public boolean toggleMap(String name) {
		Boolean oldValue = map.get(name);
		Boolean newValue = (oldValue == null || !oldValue.booleanValue());
		map.put(name, newValue);
		return newValue;
	}
	
	public boolean stalkMessage(String name)
	{
		Boolean value = map.get(name);
		boolean stalkName = !(value == null || !value.booleanValue());
		boolean stalkChance = commentRand.nextInt(100) < commentChance;
		return stalkName && stalkChance;
	}

}
