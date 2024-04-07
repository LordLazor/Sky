package de.lordlazor.skypvp.player;

import de.lordlazor.skypvp.stats.PlayerStats;
import de.lordlazor.skypvp.utils.Variables;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event){

    event.getPlayer().showTitle(Title.title(Component.text("Sky").color(NamedTextColor.DARK_AQUA).append(Component.text("PvP").color(NamedTextColor.AQUA)), Component.text("Willkommen!").color(NamedTextColor.WHITE)));

    event.joinMessage(Component.text("[").color(NamedTextColor.GRAY).append(Component.text("+").color(NamedTextColor.GREEN)).append(Component.text("] ").color(NamedTextColor.GRAY).append(Component.text(event.getPlayer().getName()).color(NamedTextColor.GREEN))));

    String playerID = String.valueOf(event.getPlayer().getUniqueId());

    PlayerInfo playerInfo = new PlayerInfo();

    if (!(playerInfo.isPlayerInPlayers(playerID))) {
      playerInfo.setPlayerName(playerID, event.getPlayer().getName());
      playerInfo.setPlayersRank(playerID, "Spieler");
      playerInfo.setIsVanished(playerID, false);
      playerInfo.setIsMuted(playerID, false);

      playerInfo.savePlayers();
    }

    event.getPlayer().teleport(new Location(Bukkit.getWorld(Variables.mapName), 121.51,88.00 ,-153.49, -90.15f, 0.15f));

  }

}
