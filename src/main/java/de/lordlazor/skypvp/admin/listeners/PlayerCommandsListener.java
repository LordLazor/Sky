package de.lordlazor.skypvp.admin.listeners;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import de.lordlazor.skypvp.utils.Variables;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandsListener implements Listener {

  @EventHandler
  public void onPlayerCommand(PlayerCommandPreprocessEvent event) {

    String playerMessage = event.getMessage().toLowerCase();

    if(playerMessage.startsWith("/pl") || playerMessage.startsWith("/plugins") || playerMessage.startsWith("/bukkit:pl") || playerMessage.startsWith("/bukkit:plugins")) {
      event.setCancelled(true);
      event.getPlayer().sendMessage(Graphical.ServerPrefix
          .append(Component.text("Dieser Befehl ist nicht erlaubt!").color(NamedTextColor.RED)));
    }

    if(playerMessage.startsWith("/")){
      String playerName = event.getPlayer().getName();

      Bukkit.getServer().getOnlinePlayers().forEach(p -> {

        PlayerInfo playerInfo = new PlayerInfo();

        String playerRank = playerInfo.getPlayersRank(String.valueOf(p.getUniqueId()));

        if((p.isOp() || playerRank.equals("Owner") || playerRank.equals("Admin") || playerRank.equals("Moderator") || playerRank.equals("Team")) && Variables.commandSpyPlayers.contains(p.getUniqueId()) && p.getUniqueId() != event.getPlayer().getUniqueId()) {
          p.sendMessage(Graphical.CommandTracker
              .append(Component.text(playerName))
                .color(NamedTextColor.AQUA)
              .append(Component.text(": ")
                  .color(NamedTextColor.WHITE))
              .append(Component.text(playerMessage)
                  .color(NamedTextColor.AQUA)
              .decoration(TextDecoration.UNDERLINED, true)));
        }
      });
    }

  }

}
