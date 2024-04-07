package de.lordlazor.skypvp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.ChatColor;

public class Variables {

  public static boolean chatMuted;

  public static List<UUID> commandSpyPlayers = new ArrayList<>();

  public static String[] ranks = {"Owner", "Admin", "Moderator", "Team", "Builder", "Premium", "Spieler"};

  public static String ownerRank = ChatColor.DARK_RED + "" + ChatColor.BOLD + "OWNER " + ChatColor.WHITE;
  public static String adminRank = ChatColor.RED + "" + ChatColor.BOLD + "ADMIN " + ChatColor.WHITE;
  public static String moderatorRank = ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "MOD " + ChatColor.WHITE;
  public static String teamRank = ChatColor.AQUA + "" + ChatColor.BOLD + "TEAM " + ChatColor.WHITE;
  public static String builderRank = ChatColor.YELLOW + "" + ChatColor.BOLD + "BUILDER " + ChatColor.WHITE;
  public static String premiumRank = ChatColor.GOLD + "" + ChatColor.BOLD + "PREMIUM " + ChatColor.WHITE;
  public static String spielerRank = ChatColor.GRAY + "" + ChatColor.BOLD + "SPIELER " + ChatColor.WHITE;

  public static String mapName = "pvp";

  public static int netheriteSwordPrice = 1;
  public static int netheriteHelmetPrice = 2;
  public static int netheriteChestplatePrice = 3;
  public static int netheriteLeggingsPrice = 4;
  public static int netheriteBootsPrice = 5;

  public static int enchantedGoldenApplePrice = 10;

}
