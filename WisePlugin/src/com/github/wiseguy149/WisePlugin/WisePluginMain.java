package com.github.wiseguy149.WisePlugin;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WisePluginMain extends JavaPlugin
{

	private WisePluginCommandExecutor myExecutor;

	public void onEnable()
	{
		this.myExecutor = new WisePluginCommandExecutor(this);
		getCommand("basic").setExecutor(myExecutor);
		getCommand("basic2").setExecutor(myExecutor);
		
		getLogger().info("WisePlugin enabled BETTER!");
	}

	public void onDisable()
	{
		getLogger().info("WisePlugin disabled.  Goodbye!");
	}

}
