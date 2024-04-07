package de.lordlazor.skypvp.chat.commands;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearChatCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    PlayerInfo playerInfo = new PlayerInfo();

    String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

    if(player.isOp() || playerRank.equals("Owner") || playerRank.equals("Admin") || playerRank.equals("Moderator")) {
      String playerName = commandSender.getName();

      Bukkit.getOnlinePlayers().forEach(p -> {
        for(int i = 0; i < 99; i++){
          p.sendMessage(" ");
        }

        p.sendMessage(Graphical.ServerPrefix
            .append(Component.text("Der Chat wurde von ")
                .color(NamedTextColor.RED))
            .append(Component.text(playerName)
                .color(NamedTextColor.DARK_RED))
            .append(Component.text(" geleert.")
                        .color(NamedTextColor.RED)));
      });
    }
    else {
      player.sendMessage(Graphical.NoPermissions);
    }

    return true;
  }
}
