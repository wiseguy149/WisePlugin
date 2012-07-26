package com.github.wiseguy149.WisePlugin;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class WisePluginBlockListener implements Listener {
 
        public WisePluginMain myPlugin;
       
        public WisePluginBlockListener(WisePluginMain myPlugin) {
                this.myPlugin = myPlugin;
        }
 
        @EventHandler
        public void onBlockPlace(BlockPlaceEvent event){
                Player player = event.getPlayer();
                String name = player.getName();
                Block block = event.getBlock();
                Material mat = block.getType();
                String matName = mat.toString().toLowerCase();
                
                if(myPlugin.stalkMessage(name))
                {
                	player.sendMessage(ChatColor.DARK_PURPLE + "Hey " + name + ", I see you placed a " + matName + " block there.");
                	player.sendMessage(ChatColor.DARK_PURPLE + "Watcha doin with that?");
                }
        }
}