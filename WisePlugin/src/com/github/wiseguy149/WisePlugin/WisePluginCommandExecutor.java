package com.github.wiseguy149.WisePlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class WisePluginCommandExecutor implements CommandExecutor
{

	private WisePluginMain myPlugin;

	public WisePluginCommandExecutor(WisePluginMain myPlugin) {
		this.myPlugin = myPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player player = null;
		if (sender instanceof Player)
			player = (Player) sender;
		
		
		if (cmd.getName().equalsIgnoreCase("stalk"))
		{
			if(args.length < 1)
				sender.sendMessage("this command requires a playername");
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase("basic2")) {
			if (player == null)
				sender.sendMessage("this command can only be run by a player");
			else
			{
				// do something else...
			}
			return true;
		}
		else
			return false;
	}

}
