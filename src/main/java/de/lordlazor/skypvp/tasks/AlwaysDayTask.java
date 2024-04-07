package de.lordlazor.skypvp.tasks;

import de.lordlazor.skypvp.utils.Variables;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class AlwaysDayTask extends BukkitRunnable {

  @Override
  public void run() {
    Bukkit.getWorld(Variables.mapName).setTime(6000);
  }
}