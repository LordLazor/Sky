package de.lordlazor.skypvp.stats;

import de.lordlazor.skypvp.utils.Graphical;
import java.io.IOException;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillstreakListener implements Listener {

  @EventHandler
  public void onPlayerKillsPlayerKillstreak(PlayerDeathEvent event) throws IOException {

    Player player = event.getEntity();

    if(player.getKiller() != null){
      Player killer = player.getKiller();

      PlayerStats playerStats = new PlayerStats();

      String killerId = String.valueOf(killer.getUniqueId());

      playerStats.setCurrentKillstreak(killerId, playerStats.getCurrentKillstreak(killerId) + 1);

      int currentKillerKillstreak = playerStats.getCurrentKillstreak(killerId);

      if(playerStats.getCurrentKillstreak(killerId) > playerStats.getHighestKillstreak(killerId)){
        playerStats.setHighestKillstreak(killerId, playerStats.getCurrentKillstreak(killerId));
      }

      //killer.sendActionBar(Component.text()
      //        .append(Component.text("Killstreak: ").color(NamedTextColor.AQUA))
      //    .append(Component.text(playerStats.getCurrentKillstreak(killerId)).color(NamedTextColor.WHITE)));

      if(currentKillerKillstreak % 5 == 0 && currentKillerKillstreak != 0){
        Bukkit.broadcast((Graphical.PluginPrefix
            .append(Component.text(killer.getName())
                .color(NamedTextColor.AQUA))
            .append(Component.text(" hat eine Killstreak von ")
                .color(NamedTextColor.WHITE))
            .append(Component.text(currentKillerKillstreak)
                .color(NamedTextColor.DARK_AQUA))
            .append(Component.text(" erreicht!")
                .color(NamedTextColor.WHITE))));
      }

      playerStats.setCurrentKillstreak(String.valueOf(player.getUniqueId()), 0);

      playerStats.saveStats();

    }


  }

}
