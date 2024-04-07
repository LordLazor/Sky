package de.lordlazor.skypvp.tablist;

import de.lordlazor.skypvp.player.PlayerInfo;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager {

  public void setTablist(Player player){
    player.setPlayerListHeaderFooter(ChatColor.DARK_AQUA + "Sky" + ChatColor.AQUA + "PvP" + "\n", "\n" + ChatColor.AQUA + "Dein Server für PvP");
  }

  public void setPlayerTeams(Player player) {

    Scoreboard scoreboard = player.getScoreboard();

    Team owner = scoreboard.getTeam("aowner");

    if(owner == null){
      owner = scoreboard.registerNewTeam("aowner");
    }

    Team admin = scoreboard.getTeam("badmin");

    if(admin == null){
      admin = scoreboard.registerNewTeam("badmin");
    }

    Team moderator = scoreboard.getTeam("cmoderator");

    if(moderator == null){
      moderator = scoreboard.registerNewTeam("cmoderator");
    }

    Team team = scoreboard.getTeam("dteam");

    if(team == null){
      team = scoreboard.registerNewTeam("dteam");
    }

    Team builder = scoreboard.getTeam("ebuilder");

    if(builder == null){
      builder = scoreboard.registerNewTeam("ebuilder");
    }

    Team premium = scoreboard.getTeam("fpremium");

    if(premium == null){
      premium = scoreboard.registerNewTeam("fpremium");
    }

    Team spieler = scoreboard.getTeam("gspieler");

    if(spieler == null){
      spieler = scoreboard.registerNewTeam("gspieler");
    }

    owner.setPrefix(ChatColor.DARK_RED + "" + ChatColor.BOLD + "OWNER " + ChatColor.WHITE);
    admin.setPrefix(ChatColor.RED + "" + ChatColor.BOLD + "ADMIN " + ChatColor.WHITE);
    moderator.setPrefix(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "MOD " + ChatColor.WHITE);
    team.setPrefix(ChatColor.AQUA + "" + ChatColor.BOLD + "TEAM " + ChatColor.WHITE);
    builder.setPrefix(ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER " + ChatColor.WHITE);
    premium.setPrefix(ChatColor.GOLD + "" + ChatColor.BOLD + "PREMIUM " + ChatColor.WHITE);
    spieler.setPrefix(ChatColor.GRAY + "" + ChatColor.BOLD + "SPIELER " + ChatColor.WHITE);

    PlayerInfo playerInfo = new PlayerInfo();

    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {

      String playerRank = playerInfo.getPlayersRank(String.valueOf(onlinePlayer.getUniqueId()));

      if(playerRank.equals("Owner")){
        owner.addEntry(onlinePlayer.getName());
      }
      else if(playerRank.equals("Admin")){
        admin.addEntry(onlinePlayer.getName());
      }
      else if(playerRank.equals("Moderator")){
        moderator.addEntry(onlinePlayer.getName());
      }
      else if(playerRank.equals("Team")){
        team.addEntry(onlinePlayer.getName());
      }
      else if(playerRank.equals("Builder")){
        builder.addEntry(onlinePlayer.getName());
      }
      else if(playerRank.equals("Premium")){
        premium.addEntry(onlinePlayer.getName());
      }
      else {
        spieler.addEntry(onlinePlayer.getName());
      }

    }

  }

}
