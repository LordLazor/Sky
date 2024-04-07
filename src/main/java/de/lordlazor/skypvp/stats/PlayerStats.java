package de.lordlazor.skypvp.stats;

import de.lordlazor.skypvp.SkyPvP;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;

public class PlayerStats {

  private SkyPvP plugin;

  private File file;
  private YamlConfiguration statsConfig;

  public PlayerStats() {
    plugin = SkyPvP.getPlugin(SkyPvP.class);

    file = new File(plugin.getDataFolder() + File.separator + "stats.yml");
    statsConfig = YamlConfiguration.loadConfiguration(file);
  }

  public boolean isPlayerInStats(String playerID){
    if(statsConfig.get(playerID) == null){
      return false;
    }
    return true;
  }

  public int getCurrentKillstreak(String playerID) {
    return statsConfig.getInt(playerID + ".currentKillstreak");
  }

  public void setCurrentKillstreak(String playerID, int currentKillstreak) {
    statsConfig.set(playerID + ".currentKillstreak", currentKillstreak);
  }

  public int getHighestKillstreak(String playerID) {
    return statsConfig.getInt(playerID + ".highestKillstreak");
  }

  public void setHighestKillstreak(String playerID, int highestKillstreak) {
    statsConfig.set(playerID + ".highestKillstreak", highestKillstreak);
  }

  public int getKills(String playerID) {
    return statsConfig.getInt(playerID + ".kills");
  }

  public void setKills(String playerID, int kills) {
    statsConfig.set(playerID + ".kills", kills);
  }

  public int getDeaths(String playerID) {
    return statsConfig.getInt(playerID + ".deaths");
  }

  public void setDeaths(String playerID, int deaths) {
    statsConfig.set(playerID + ".deaths", deaths);
  }

  public int getCoins(String playerID) {
    return statsConfig.getInt(playerID + ".coins");
  }

  public void setCoins(String playerID, int coins) {
    statsConfig.set(playerID + ".coins", coins);
  }

  public void saveStats() {
    try {
      statsConfig.save(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
