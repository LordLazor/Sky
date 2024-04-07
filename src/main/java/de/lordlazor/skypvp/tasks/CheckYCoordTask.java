package de.lordlazor.skypvp.tasks;

import de.lordlazor.skypvp.utils.Variables;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class CheckYCoordTask extends BukkitRunnable {

  @Override
  public void run() {
    Bukkit.getWorld(Variables.mapName).getPlayers().forEach(player -> {
      if(player.getLocation().getY() < -30)
      {
        player.setHealth(0);
      }
    });
  }

}
