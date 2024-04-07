package de.lordlazor.skypvp.admin;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import de.lordlazor.skypvp.utils.Variables;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ToggleTrackerCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    PlayerInfo playerInfo = new PlayerInfo();

    String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

    if(player.isOp() || playerRank.equals("Owner") || playerRank.equals("Admin") || playerRank.equals("Moderator") || playerRank.equals("Team")) {

        if(Variables.commandSpyPlayers.contains(player.getUniqueId())) {

          Variables.commandSpyPlayers.remove(player.getUniqueId());
          player.sendMessage(Graphical.CommandTracker
              .append(Component.text("deaktiviert"))
              .color(NamedTextColor.RED));

        }
        else {

          Variables.commandSpyPlayers.add(player.getUniqueId());
          player.sendMessage(Graphical.CommandTracker
              .append(Component.text("aktiviert"))
              .color(NamedTextColor.GREEN));

        }

    }

    return true;
  }
}
