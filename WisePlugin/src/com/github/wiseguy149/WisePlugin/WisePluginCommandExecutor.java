package com.github.wiseguy149.WisePlugin;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WisePluginCommandExecutor implements CommandExecutor
{

	private WisePluginMain myPlugin;
	
	public WisePluginCommandExecutor(WisePluginMain myPlugin) {
		this.myPlugin = myPlugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		/*
		Player player = null;
		if (sender instanceof Player)
			player = (Player) sender;
		*/
		
		if (cmd.getName().equalsIgnoreCase("stalk"))
		{
			if(args.length != 1)
			{
				//sender.sendMessage(ChatColor.RED + "command usage: /stalk <playername>");
				return false;
			}
			else
			{
				Player target = (Bukkit.getServer().getPlayer(args[0]));
		        if (target == null) {
		           sender.sendMessage(ChatColor.RED + args[0] + " is not online!");
		           return true;
		        }
		        else
		        {
		        	if(myPlugin.toggleMap(target.getName()))
		        		sender.sendMessage(ChatColor.WHITE + "Stalking " + ChatColor.GREEN + "enabled" + ChatColor.WHITE + " for " + ChatColor.DARK_AQUA + target.getName());
		        	else
		        		sender.sendMessage(ChatColor.WHITE + "Stalking " + ChatColor.RED + "disabled" + ChatColor.WHITE + " for " + ChatColor.DARK_AQUA + target.getName());
		        	
		        	return true;
		        }
			}
		}
		/*
		else if (cmd.getName().equalsIgnoreCase("basic2")) {
			if (player == null)
				sender.sendMessage("this command can only be run by a player");
			else
			{
				// do something else...
			}
			return true;
		}
		*/
		else
			return false;
	}

}
