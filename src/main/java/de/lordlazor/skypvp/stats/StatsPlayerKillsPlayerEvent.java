package de.lordlazor.skypvp.stats;

import de.lordlazor.skypvp.SkyPvP;
import java.io.IOException;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class StatsPlayerKillsPlayerEvent implements Listener {

  private final SkyPvP plugin;

  public StatsPlayerKillsPlayerEvent() {
    this.plugin = SkyPvP.getPlugin(SkyPvP.class);
  }

  @EventHandler
  public void onPlayerKillsPlayer(PlayerDeathEvent event) throws IOException {

    Player player = event.getEntity();

    if(player.getKiller() != null){
      Player killer = player.getKiller();

      String killerId = String.valueOf(killer.getUniqueId());

      PlayerStats playerStats = new PlayerStats();

      playerStats.setKills(killerId, playerStats.getKills(killerId) + 1);

      playerStats.setCoins(killerId, playerStats.getCoins(killerId) + 10);

      playerStats.saveStats();

      killer.sendActionBar(Component.text()
          .append(Component.text("Du hast einen Spieler getötet!")
              .color(NamedTextColor.AQUA))
          .append(Component.text(" +10 Münzen")
              .color(NamedTextColor.DARK_AQUA)));

      killer.setScoreboard(StatsSidebarUtils.getBaseScoreboard(killer));

    }


  }

}
