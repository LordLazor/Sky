package de.lordlazor.skypvp.admin.listeners;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import de.lordlazor.skypvp.utils.Variables;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinAddToToggleCommandListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {

    Player player = event.getPlayer();

    PlayerInfo playerInfo = new PlayerInfo();

    if(playerInfo.isPlayerInPlayers(String.valueOf(player.getUniqueId()))) {

      String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

      if (player.isOp() || playerRank.equals("Owner") || playerRank.equals("Admin")
          || playerRank.equals("Moderator") || playerRank.equals("Team")) {

        Variables.commandSpyPlayers.add(event.getPlayer().getUniqueId());

        event.getPlayer().sendMessage(Graphical.CommandTracker
            .append(Component.text("aktiviert"))
            .color(NamedTextColor.GREEN));

      }
    }

  }

}
