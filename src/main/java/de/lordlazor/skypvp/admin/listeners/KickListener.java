package de.lordlazor.skypvp.admin.listeners;

import de.lordlazor.skypvp.utils.Graphical;
import java.util.Arrays;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class KickListener implements Listener {

  @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
  public void onKickPreprocess(PlayerCommandPreprocessEvent event) {

    // TODO: Permissions

    if(event.getMessage().startsWith("/kick")) {

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
            .append(Component.text(" gekickt!").color(NamedTextColor.RED))
            .appendNewline()
            .append(Component.text("Grund » ").color(NamedTextColor.RED)
            .append(Component.text(reason).color(NamedTextColor.DARK_RED)))
            .build());

        target.kick(Component.text()
            .append(Component.text("KICK")).color(NamedTextColor.DARK_RED)
            .appendNewline()
            .appendNewline()
            .append(Component.text("Du wurdest von ").color(NamedTextColor.RED))
            .append(Component.text(event.getPlayer().getName()).color(NamedTextColor.DARK_RED))
            .append(Component.text(" gekickt.").color(NamedTextColor.RED))
            .appendNewline()
            .append(Component.text("Grund » ").color(NamedTextColor.RED))
            .append(Component.text(reason).color(NamedTextColor.DARK_RED))
            .appendNewline()
            .appendNewline()
            .append(Component.text("KICK")).color(NamedTextColor.DARK_RED)
            .build());
      }

    }

  }

  @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
  public void onOperatorSetConsole(ServerCommandEvent event) {
    String cmd = event.getCommand();
    if (cmd.startsWith("kick ")) {
      event.setCancelled(true);
    }
  }

}
