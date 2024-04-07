package de.lordlazor.skypvp.stats;

import de.lordlazor.skypvp.SkyPvP;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StatsCommand implements CommandExecutor {

  private final SkyPvP plugin;

  public StatsCommand() {
    this.plugin = SkyPvP.getPlugin(SkyPvP.class);
  }

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    String playerID = String.valueOf(player.getUniqueId());

    PlayerStats playerStats = new PlayerStats();

    player.sendMessage(Component.text()
            .append(Component.text("<--------STATS-------->").color(NamedTextColor.DARK_AQUA))
            .appendNewline()
            .append(Component.text("Kills: ")
                .color(NamedTextColor.AQUA))
            .append(Component.text(playerStats.getKills(playerID))).color(NamedTextColor.WHITE)
            .appendNewline()
            .append(Component.text("Tode: ")
                .color(NamedTextColor.AQUA))
            .append(Component.text(playerStats.getDeaths(playerID))
                .color(NamedTextColor.WHITE))
            .appendNewline()
            .append(Component.text("Aktuelle Killstreak: ")
                .color(NamedTextColor.AQUA))
            .append(Component.text(playerStats.getCurrentKillstreak(playerID))
                .color(NamedTextColor.WHITE))
            .appendNewline()
            .append(Component.text("Höchste Killstreak: ")
                .color(NamedTextColor.AQUA))
            .append(Component.text(playerStats.getHighestKillstreak(playerID))
                .color(NamedTextColor.WHITE))
            .appendNewline()
            .append(Component.text("Münzen: ")
                .color(NamedTextColor.AQUA))
            .append(Component.text(playerStats.getCoins(playerID))
                .color(NamedTextColor.WHITE))
            .appendNewline()
            .append(Component.text("<--------STATS-------->")
                .color(NamedTextColor.DARK_AQUA)));


    return true;
  }
}
