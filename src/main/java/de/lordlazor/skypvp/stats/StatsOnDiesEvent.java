package de.lordlazor.skypvp.stats;

import de.lordlazor.skypvp.SkyPvP;
import java.io.IOException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class StatsOnDiesEvent implements Listener {

  private final SkyPvP plugin;

  public StatsOnDiesEvent() {
    this.plugin = SkyPvP.getPlugin(SkyPvP.class);
  }

  @EventHandler
  public void onPlayerDies(PlayerDeathEvent event) throws IOException {

    String playerID = String.valueOf(event.getPlayer().getUniqueId());

    PlayerStats playerStats = new PlayerStats();

    playerStats.setDeaths(playerID, playerStats.getDeaths(playerID) + 1);
    playerStats.setCurrentKillstreak(playerID, 0);

    playerStats.saveStats();

    event.getPlayer().setScoreboard(StatsSidebarUtils.getBaseScoreboard(event.getPlayer()));

  }

}
