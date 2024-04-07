package de.lordlazor.skypvp.player;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class HelpCommand implements Listener {

  @EventHandler
  public void onHelpCommand(PlayerCommandPreprocessEvent event){

    if(!event.getMessage().startsWith("/help")) return;

    event.setCancelled(true);

    event.getPlayer().sendMessage(Component.text()
        .append(Component.text("<--------HELP-------->").color(NamedTextColor.DARK_AQUA))
        .appendNewline()
        .append(Component.text("/kits ")
            .color(NamedTextColor.AQUA))
        .appendNewline()
        .append(Component.text("Öffnet das Menu, um Kits auszuwählen").color(NamedTextColor.WHITE)
        .appendNewline()
        .append(Component.text("/skyshop")
            .color(NamedTextColor.AQUA))
        .appendNewline()
        .append(Component.text("Öffnet das Menu, um Items zu kaufen")
            .color(NamedTextColor.WHITE))
        .appendNewline()
        .append(Component.text("<--------HELP-------->")
            .color(NamedTextColor.DARK_AQUA))));

  }

}
