package de.lordlazor.skypvp.admin;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Graphical;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetYawPitch implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {
    Player player = (Player) commandSender;

    PlayerInfo playerInfo = new PlayerInfo();

    String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

    if(player.isOp() || playerRank.equals("Owner")) {

      Location location = player.getLocation();

      player.sendMessage("Yaw: " + location.getYaw() + ", Pitch: " + location.getPitch());

      return true;

    } else {
      player.sendMessage(Graphical.NoPermissions);
      return true;
    }


  }
}