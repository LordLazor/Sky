package de.lordlazor.skypvp.admin.listeners;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class BanListener implements Listener {

  @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
  public void onKickPreprocess(PlayerCommandPreprocessEvent event) {

    // TODO: Permissions

    if(event.getMessage().startsWith("/ban")) {

      event.setCancelled(true);

      String[] args = event.getMessage().split(" ");

      String playerName = args[1];

      String reason = String.join(" ", Arrays.copyOfRange(args, 2, args.length));

      Player target = Bukkit.getPlayer(playerName);

      if(target != null) {
        Bukkit.broadcast(Component.text()
            .append(Component.text("Der Spieler ").color(NamedTextColor.RED))
            .append(Component.text(target.getName()).color(NamedTextColor.DARK_RED))
            .append(Component.text(" wurde von ").color(NamedTextColor.RED))
            .append(Component.text(event.getPlayer().getName()).color(NamedTextColor.DARK_RED))
            .append(Component.text(" gebannt!").color(NamedTextColor.RED))
            .appendNewline()
            .append(Component.text("Grund » ").color(NamedTextColor.RED)
                .append(Component.text(reason).color(NamedTextColor.DARK_RED)))
            .build());


        target.ban(reason, (Date) null, event.getPlayer().getName());
      }
    }

  }

  @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
  public void onOperatorSetConsole(ServerCommandEvent event) {
    String cmd = event.getCommand();
    if (cmd.startsWith("ban ")) {
      event.setCancelled(true);
    }
  }

}
