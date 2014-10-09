package me.banana.hubplusplus;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join
  implements Listener
{
  public Join(Main main)
  {
  }

  public void onPlayerJoin(PlayerJoinEvent event)
  {
    Player p = event.getPlayer();
    String prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "hub++" + ChatColor.GRAY + "]";

    p.sendMessage(prefix + ChatColor.GREEN + " Player joined to game");
  }
}
