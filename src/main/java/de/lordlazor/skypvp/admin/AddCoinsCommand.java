package de.lordlazor.skypvp.admin;

import de.lordlazor.skypvp.SkyPvP;
import de.lordlazor.skypvp.stats.PlayerStats;
import de.lordlazor.skypvp.stats.StatsSidebarUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AddCoinsCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    String targetPlayerName = strings[0];
    int coins = Integer.parseInt(strings[1]);

    Player targetPlayer = player.getServer().getPlayer(targetPlayerName);

    PlayerStats playerStats = new PlayerStats();

    if (targetPlayer != null) {
      playerStats.setCoins(
          String.valueOf(targetPlayer.getUniqueId()), playerStats.getCoins(
              String.valueOf(targetPlayer.getUniqueId())) + coins);

      playerStats.saveStats();

      targetPlayer.setScoreboard(StatsSidebarUtils.getBaseScoreboard(targetPlayer));

      SkyPvP.getInstance().getTablistManager().setTablist(targetPlayer);

      for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
        SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
      }

    }



    return true;
  }
}
