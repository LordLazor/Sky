package de.lordlazor.skypvp.admin;

import de.lordlazor.skypvp.player.PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VanishJoinListener implements Listener {

  @EventHandler
  public void onVanishJoin(PlayerJoinEvent event){

    PlayerInfo playerInfo = new PlayerInfo();

    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {

      if(playerInfo.getIsVanished(String.valueOf(onlinePlayer.getUniqueId()))){



      }

    }

  }

}
