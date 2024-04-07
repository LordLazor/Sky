package de.lordlazor.skypvp.player;

import de.lordlazor.skypvp.utils.Variables;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakBlockListener implements Listener {

  @EventHandler
  public void onPlayerBreakBlock(BlockBreakEvent event){
    if(event.getBlock().getLocation().getWorld().getName().equals(Variables.mapName)) event.setCancelled(true);
  }

}
