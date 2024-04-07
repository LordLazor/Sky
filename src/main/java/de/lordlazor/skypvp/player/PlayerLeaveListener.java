package de.lordlazor.skypvp.player;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

  @EventHandler
  public void onPlayerLeave(PlayerQuitEvent event) {

    event.quitMessage(Component.text("[").color(NamedTextColor.GRAY).append(Component.text("-").color(NamedTextColor.RED)).append(Component.text("] ").color(NamedTextColor.GRAY).append(Component.text(event.getPlayer().getName()).color(NamedTextColor.RED))));

  }

}
