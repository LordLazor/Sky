package de.lordlazor.skypvp.admin;

import static net.kyori.adventure.text.Component.text;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    PlayerInfo playerInfo = new PlayerInfo();

    String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

    if(player.isOp() || playerRank.equals("Owner") || playerRank.equals("Admin")){
      if(player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR){
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(Graphical.PluginPrefix
            .append(text("Dein Spielmodus wurde auf").color(NamedTextColor.WHITE))
            .append(text(" ÜBERLEBEN ").color(NamedTextColor.AQUA))
            .append(text("geändert.").color(NamedTextColor.WHITE)));
      }
      else {
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(Graphical.PluginPrefix
            .append(text("Dein Spielmodus wurde auf").color(NamedTextColor.WHITE))
            .append(text(" KREATIV ").color(NamedTextColor.AQUA))
            .append(text("geändert.").color(NamedTextColor.WHITE)));
      }
    }
    else {
      player.sendMessage(Graphical.NoPermissions);
    }

    return true;
  }
}
