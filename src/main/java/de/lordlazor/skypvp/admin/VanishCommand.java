package de.lordlazor.skypvp.admin;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import de.lordlazor.skypvp.utils.Variables;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VanishCommand implements CommandExecutor {


  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {
    Player player = (Player) commandSender;

    PlayerInfo playerInfo = new PlayerInfo();

    String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

    if(player.isOp() || playerRank.equals("Owner") || playerRank.equals("Admin") || playerRank.equals("Moderator")) {

      UUID playerUUID = player.getUniqueId();
      boolean isVanished = playerInfo.getIsVanished(String.valueOf(playerUUID));

      for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
        if(onlinePlayer.equals(player)) {
          continue;
        }
        playerRank = playerInfo.getPlayersRank(String.valueOf(onlinePlayer.getUniqueId()));

        if (playerRank.equals("Spieler")) {

          if (isVanished) {

            onlinePlayer.showPlayer(player);

          } else {

            onlinePlayer.hidePlayer(player);

          }
        }

      }

      if(isVanished) {
        player.setGameMode(GameMode.SURVIVAL);
        playerInfo.setIsVanished(String.valueOf(player.getUniqueId()), false);
      } else {
        player.setGameMode(GameMode.SPECTATOR);
        playerInfo.setIsVanished(String.valueOf(player.getUniqueId()), true);
      }

      playerInfo.savePlayers();




    } else {
      player.sendMessage(Graphical.NoPermissions);
    }

    return true;

  }
}
