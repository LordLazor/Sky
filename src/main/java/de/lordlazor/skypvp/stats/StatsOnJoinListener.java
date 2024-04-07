package de.lordlazor.skypvp.stats;

import de.lordlazor.skypvp.SkyPvP;
import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StatsOnJoinListener implements Listener {

  private final SkyPvP plugin;

  public StatsOnJoinListener() {
    this.plugin = SkyPvP.getPlugin(SkyPvP.class);
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) throws IOException {
    String playerID = String.valueOf(event.getPlayer().getUniqueId());

    PlayerStats playerStats = new PlayerStats();

    if (!(playerStats.isPlayerInStats(playerID))) {
      playerStats.setKills(playerID, 0);
      playerStats.setDeaths(playerID, 0);
      playerStats.setCoins(playerID, 0);
      playerStats.setCurrentKillstreak(playerID, 0);
      playerStats.setHighestKillstreak(playerID, 0);
      playerStats.saveStats();
    }

    event.getPlayer().setScoreboard(StatsSidebarUtils.getBaseScoreboard(event.getPlayer()));

  }

}
