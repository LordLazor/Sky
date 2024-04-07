package de.lordlazor.skypvp.chat.commands;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import de.lordlazor.skypvp.utils.Variables;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MuteChatCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    PlayerInfo playerInfo = new PlayerInfo();

    String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

    if(player.isOp() || playerRank.equals("Owner") || playerRank.equals("Admin")) {

      if(strings.length != 1) return false;

      if(Variables.chatMuted && strings[0].equalsIgnoreCase("off")) {
        Variables.chatMuted = false;

        player.sendMessage(Graphical.PluginPrefix
            .append(Component.text("Du hast den Chat ")
                .color(NamedTextColor.WHITE))
            .append(Component.text("entsperrt")
                .color(NamedTextColor.AQUA))
            .append(Component.text(".")
                .color(NamedTextColor.WHITE)));

        Bukkit.getServer().getOnlinePlayers().forEach(p -> {
          p.sendMessage(Graphical.ServerPrefix
              .append(Component.text("Der Chat wurde von ")
                  .color(NamedTextColor.RED))
              .append(Component.text(player.getName())
                  .color(NamedTextColor.RED))
              .append(Component.text(" entsperrt")
                  .color(NamedTextColor.DARK_RED))
              .append(Component.text(".")
                  .color(NamedTextColor.RED)));
        });

      }
      else if(!Variables.chatMuted && strings[0].equalsIgnoreCase("on")) {
        Variables.chatMuted = true;

        player.sendMessage(Graphical.PluginPrefix
            .append(Component.text("Du hast den Chat ")
                .color(NamedTextColor.WHITE))
            .append(Component.text("gesperrt")
                .color(NamedTextColor.AQUA))
            .append(Component.text(".")
                .color(NamedTextColor.WHITE)));

        Bukkit.getServer().getOnlinePlayers().forEach(p -> {
          p.sendMessage(Graphical.ServerPrefix
              .append(Component.text("Der Chat wurde von ")
                  .color(NamedTextColor.RED))
              .append(Component.text(player.getName())
                  .color(NamedTextColor.RED))
              .append(Component.text(" gesperrt")
                  .color(NamedTextColor.DARK_RED))
              .append(Component.text(".")
                  .color(NamedTextColor.RED)));
        });
      } else {
        return false;
      }
    }
    else {
      player.sendMessage(Graphical.NoPermissions);
    }

    return true;
  }
}
