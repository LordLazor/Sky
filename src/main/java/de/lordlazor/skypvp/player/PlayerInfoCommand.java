package de.lordlazor.skypvp.player;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerInfoCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    String playerID = String.valueOf(player.getUniqueId());

    PlayerInfo playerInfo = new PlayerInfo();

    player.sendMessage(Component.text()
        .append(Component.text("<--------INFO-------->").color(NamedTextColor.DARK_AQUA))
        .appendNewline()
        .append(Component.text("Name: ")
            .color(NamedTextColor.AQUA))
        .append(Component.text(playerInfo.getPlayerName(playerID))).color(NamedTextColor.WHITE)
        .appendNewline()
        .append(Component.text("Rang: ")
            .color(NamedTextColor.AQUA))
        .append(Component.text(playerInfo.getPlayersRank(playerID))
            .color(NamedTextColor.WHITE))
        .appendNewline()
        .append(Component.text("<--------INFO-------->")
            .color(NamedTextColor.DARK_AQUA)));

    return true;
  }
}
