package de.lordlazor.skypvp.world;

import de.lordlazor.skypvp.utils.Variables;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class OnWeatherChangeEvent implements Listener {

  @EventHandler
  public void onWeatherChange(WeatherChangeEvent event){
    if(event.getWorld().getName().equals(Variables.mapName)) event.setCancelled(true);

  }

}