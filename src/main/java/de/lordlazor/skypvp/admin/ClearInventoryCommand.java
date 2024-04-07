package de.lordlazor.skypvp.admin;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearInventoryCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    PlayerInfo playerInfo = new PlayerInfo();

    String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

    if(player.isOp() || playerRank.equals("Owner") || playerRank.equals("Admin") || playerRank.equals("Moderator")) {
      if(strings.length == 0) {

        player.sendMessage(Graphical.PluginPrefix
            .append(Component.text("Dein Inventar wurde geleert.")
                .color(NamedTextColor.WHITE)));

        player.getInventory().clear();
      } else {
        Player targetPlayer = player.getServer().getPlayer(strings[0]);

        if(targetPlayer == null) {
          player.sendMessage(Graphical.ServerPrefix.append(Component.text("Der Spieler ist nicht online.").color(
              NamedTextColor.RED)));
        } else {
          targetPlayer.getInventory().clear();
          player.sendMessage(Graphical.PluginPrefix
              .append(Component.text("Das Inventar von ")
                  .color(NamedTextColor.WHITE))
              .append(Component.text(targetPlayer.getName())
                  .color(NamedTextColor.AQUA))
              .append(Component.text(" wurde geleert.")
                  .color(NamedTextColor.WHITE)));
        }
      }
    }
    else {
      player.sendMessage(Graphical.NoPermissions);
    }

    return true;
  }
}
