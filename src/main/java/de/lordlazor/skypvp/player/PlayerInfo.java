package de.lordlazor.skypvp.player;

import de.lordlazor.skypvp.SkyPvP;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerInfo {

  private SkyPvP plugin;

  private File file;
  private YamlConfiguration playersConfig;

  public PlayerInfo() {
    plugin = SkyPvP.getPlugin(SkyPvP.class);

    file = new File(plugin.getDataFolder() + File.separator + "players.yml");
    playersConfig = YamlConfiguration.loadConfiguration(file);
  }

  public boolean isPlayerInPlayers(String playerID){
    if(playersConfig.get(playerID) == null){
      return false;
    }
    return true;
  }

  public String getPlayersRank(String playerID) {
    return playersConfig.getString(playerID + ".rank");
  }

  public void setPlayersRank(String playerID, String rank) {
    playersConfig.set(playerID + ".rank", rank);
  }

  public String getPlayerName(String playerID) {
    return playersConfig.getString(playerID + ".name");
  }

  public void setPlayerName(String playerID, String name) {
    playersConfig.set(playerID + ".name", name);
  }

  public boolean getIsVanished(String playerID) {
    return playersConfig.getBoolean(playerID + ".vanished");
  }

  public void setIsVanished(String playerID, boolean vanished) {
    playersConfig.set(playerID + ".vanished", vanished);
  }

  public boolean getIsMuted(String playerID) {
    return playersConfig.getBoolean(playerID + ".muted");
  }

  public void setIsMuted(String playerID, boolean muted) {
    playersConfig.set(playerID + ".muted", muted);
  }

  public void savePlayers() {
    try {
      playersConfig.save(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
