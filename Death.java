package me.banana.hubplusplus;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

public class Death
  implements Listener
{
  Plugin plugin;

  public Death(Main main)
  {
    this.plugin = main;

    this.plugin.getConfig().options().copyDefaults(true);
    this.plugin.saveConfig();
  }

  @EventHandler
  public void onDeath(PlayerDeathEvent e) {
    Player player = e.getEntity();
    String prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "hub++" + ChatColor.GRAY + "]";
    player.sendMessage(prefix + ChatColor.GOLD + " You Are Death, you return to HUB !");
  }

  @EventHandler
  public void onDeathEvent(PlayerRespawnEvent e) {
    Player player = e.getPlayer();
    String prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "Hub++" + ChatColor.GRAY + "]";
    player.sendMessage(prefix + ChatColor.GOLD + " Respawning...");
    player.sendMessage(prefix + ChatColor.GREEN + " You Have Been Respawning !");
  }
}
