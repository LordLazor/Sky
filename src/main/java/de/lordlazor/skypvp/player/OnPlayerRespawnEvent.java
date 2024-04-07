package de.lordlazor.skypvp.player;

import de.lordlazor.skypvp.utils.Variables;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class OnPlayerRespawnEvent implements Listener {

  @EventHandler
  public void onPlayerRespawn(PlayerRespawnEvent event){
    event.setRespawnLocation(new Location(Bukkit.getWorld(Variables.mapName), 121.51,88.00 ,-153.49, -90.15f, 0.15f));
  }

}