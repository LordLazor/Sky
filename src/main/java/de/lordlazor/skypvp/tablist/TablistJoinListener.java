package de.lordlazor.skypvp.tablist;

import de.lordlazor.skypvp.SkyPvP;
import de.lordlazor.skypvp.player.PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class TablistJoinListener implements Listener {

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {

    SkyPvP.getInstance().getTablistManager().setTablist(event.getPlayer());

    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
      SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
    }

  }

  @EventHandler
  public void onPlayerKillsPlayer(PlayerDeathEvent event) {
    SkyPvP.getInstance().getTablistManager().setTablist(event.getPlayer());

    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
      SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
    }
  }

}
