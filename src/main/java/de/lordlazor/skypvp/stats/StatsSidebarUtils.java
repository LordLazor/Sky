package de.lordlazor.skypvp.stats;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class StatsSidebarUtils {

  public static Scoreboard getBaseScoreboard(Player player){

    PlayerStats playerStats = new PlayerStats();

    Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
    Objective objective = s.registerNewObjective("main", "main", "    §3§lSky§b§lPvP    ");
    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    objective.getScore("    §3§lSky§b§lPvP    ").setScore(0);
    objective.getScore("      ").setScore(1);
    objective.getScore("§b" + playerStats.getCoins(String.valueOf(player.getUniqueId())) + " ").setScore(2);
    objective.getScore("§fMünzen:").setScore(3);
    objective.getScore("   ").setScore(4);
    objective.getScore("§b" + playerStats.getDeaths(String.valueOf(player.getUniqueId())) + "  ").setScore(5);
    objective.getScore("§fTode:").setScore(6);
    objective.getScore("  ").setScore(7);
    objective.getScore("§b" + playerStats.getKills(String.valueOf(player.getUniqueId()))).setScore(8);
    objective.getScore("§fKills:").setScore(9);
    objective.getScore(" ").setScore(10);

    return s;
  }

}