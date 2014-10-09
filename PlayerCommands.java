package me.banana.hubplusplus;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class PlayerCommands
  implements Listener
{
  Plugin plugin;

  public PlayerCommands(Main main)
  {
    this.plugin = main;

    this.plugin.getConfig().options().copyDefaults(true);
    this.plugin.saveConfig();
  }

  @EventHandler(priority=EventPriority.LOWEST)
  public void onPlayerCommands(PlayerCommandPreprocessEvent e) {
    Player player = e.getPlayer();
    String msg = e.getMessage();
    String[] args = msg.split(" ");
    String prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "Hub++" + ChatColor.GRAY + "]";

    if (args[0].equalsIgnoreCase("/sethub")) {
      this.plugin.getConfig().set("spawn.world", player.getLocation().getWorld().getName());
      this.plugin.getConfig().set("spawn.x", Double.valueOf(player.getLocation().getX()));
      this.plugin.getConfig().set("spawn.y", Double.valueOf(player.getLocation().getY()));
      this.plugin.getConfig().set("spawn.z", Double.valueOf(player.getLocation().getZ()));
      this.plugin.saveConfig();
      player.sendMessage(prefix + ChatColor.GREEN + " The spawnpoint has been set successfuly!");
      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("/listhub")) {
      player.sendMessage(prefix + ChatColor.GOLD + " Hub Seting: " + ChatColor.GREEN + "Spawn1");
      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("/hub reload"))
    {
      if (player.hasPermission("hub++.hubreload"))
      {
        player.sendMessage(prefix + ChatColor.GREEN + " Configuration has been reload.");
      }e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("/helph"))
    {
      player.sendMessage(ChatColor.DARK_GREEN + "----------[" + ChatColor.BLUE + "hub++ Help" + ChatColor.DARK_GREEN + "]----------");
      player.sendMessage(ChatColor.AQUA + "/hub : /h : " + ChatColor.GOLD + "Returning to hub/spawn");
      player.sendMessage(ChatColor.AQUA + "/hub reload : " + ChatColor.GOLD + "Reload configuration!");
      player.sendMessage(ChatColor.AQUA + "/sethub : " + ChatColor.GOLD + " SetSpawn location");
      player.sendMessage(ChatColor.AQUA + "/hul : " + ChatColor.GOLD + " nothing");
      player.sendMessage(ChatColor.AQUA + "/hup : " + ChatColor.GOLD + " nothing");

      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("/hul")) {
      if (player.hasPermission("hub++.hun"))
        player.sendMessage(prefix + ChatColor.RED + " This command isn't avaible for this moment!");
      e.setCancelled(true);
    }
    if (args[0].equalsIgnoreCase("/hup")) {
      if (player.hasPermission("hub++.hun"))
        player.sendMessage(prefix + ChatColor.RED + " This command isn't avaible for this moment!");
      e.setCancelled(true);
    }

    if (args[0].equalsIgnoreCase("/top5tp")) {
      player.sendMessage(prefix + ChatColor.GOLD + " 1." + e.getPlayer().getName());
      player.sendMessage(prefix + ChatColor.DARK_GREEN + " 2." + e.getPlayer().getName());
      player.sendMessage(prefix + ChatColor.GREEN + " 3." + e.getPlayer().getName());
      player.sendMessage(prefix + ChatColor.RED + " 4." + e.getPlayer().getName());
      player.sendMessage(prefix + ChatColor.DARK_RED + " 5." + e.getPlayer().getName());
      e.setCancelled(true);
    }
  }
}
