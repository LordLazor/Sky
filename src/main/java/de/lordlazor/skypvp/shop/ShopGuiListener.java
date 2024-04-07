package de.lordlazor.skypvp.shop;

import com.google.errorprone.annotations.Var;
import de.lordlazor.skypvp.SkyPvP;
import de.lordlazor.skypvp.stats.PlayerStats;
import de.lordlazor.skypvp.stats.StatsSidebarUtils;
import de.lordlazor.skypvp.utils.Graphical;
import de.lordlazor.skypvp.utils.Variables;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopGuiListener implements Listener {

  @EventHandler
  public void onClick(InventoryClickEvent event){
    Player player = (Player) event.getWhoClicked();

    PlayerStats playerStats = new PlayerStats();

    int playerCoins = playerStats.getCoins(String.valueOf(player.getUniqueId()));

    if (player.hasMetadata("OpenedShopMenu")){
      event.setCancelled(true);

      if (event.getSlot() == 9){

        if (playerCoins >= Variables.netheriteSwordPrice){

          playerStats.setCoins(String.valueOf(player.getUniqueId()), playerCoins - Variables.netheriteSwordPrice);
          playerStats.saveStats();

          ItemStack getNetheriteSword = new ItemStack(Material.NETHERITE_SWORD);
          ItemMeta netheriteSwordItemMeta = getNetheriteSword.getItemMeta();
          netheriteSwordItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY SCHWERT");
          getNetheriteSword.setItemMeta(netheriteSwordItemMeta);

          player.getInventory().addItem(getNetheriteSword);

          Bukkit.broadcast(Graphical.PluginPrefix
              .append(Component.text(player.getName()).color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" hat das ").color(NamedTextColor.WHITE))
              .append(Component.text("SKY SCHWERT").color(NamedTextColor.DARK_RED).decoration(
                  TextDecoration.BOLD, true))
              .append(Component.text(" gekauft!").color(NamedTextColor.WHITE)));

          player.sendActionBar(Component.text()
              .append(Component.text("-")
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(Variables.netheriteSwordPrice)
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" Münzen")
                  .color(NamedTextColor.WHITE)));

          player.setScoreboard(StatsSidebarUtils.getBaseScoreboard(player));

          SkyPvP.getInstance().getTablistManager().setTablist(player);

          for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
          }

          player.closeInventory();

        } else {
          player.sendMessage(Graphical.PluginPrefix
              .append(Component.text("Du hast nicht genügend Münzen!").color(NamedTextColor.WHITE)));
          player.closeInventory();
        }

      } else if(event.getSlot() == 11) {

        if (playerCoins >= Variables.netheriteHelmetPrice){

          playerStats.setCoins(String.valueOf(player.getUniqueId()), playerCoins - Variables.netheriteHelmetPrice);
          playerStats.saveStats();

          ItemStack getNetheriteHelmet = new ItemStack(Material.NETHERITE_HELMET);
          ItemMeta netheriteHelmetItemMeta = getNetheriteHelmet.getItemMeta();
          netheriteHelmetItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY HELM");
          getNetheriteHelmet.setItemMeta(netheriteHelmetItemMeta);

          player.getInventory().addItem(getNetheriteHelmet);

          Bukkit.broadcast(Graphical.PluginPrefix
              .append(Component.text(player.getName()).color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" hat den ").color(NamedTextColor.WHITE))
              .append(Component.text("SKY HELM").color(NamedTextColor.DARK_RED).decoration(
                  TextDecoration.BOLD, true))
              .append(Component.text(" gekauft!").color(NamedTextColor.WHITE)));


          player.sendActionBar(Component.text()
              .append(Component.text("-")
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(Variables.netheriteHelmetPrice)
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" Münzen")
                  .color(NamedTextColor.WHITE)));

          player.setScoreboard(StatsSidebarUtils.getBaseScoreboard(player));

          SkyPvP.getInstance().getTablistManager().setTablist(player);

          for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
          }

          player.closeInventory();

        } else {
          player.sendMessage(Graphical.PluginPrefix
              .append(Component.text("Du hast nicht genügend Münzen!").color(NamedTextColor.WHITE)));
          player.closeInventory();
        }

      }

      else if(event.getSlot() == 12) {

        if (playerCoins >= Variables.netheriteChestplatePrice){

          playerStats.setCoins(String.valueOf(player.getUniqueId()), playerCoins - Variables.netheriteChestplatePrice);
          playerStats.saveStats();

          ItemStack getNetheriteChestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
          ItemMeta netheriteChestplateItemMeta = getNetheriteChestplate.getItemMeta();
          netheriteChestplateItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY BRUSTPLATTE");
          getNetheriteChestplate.setItemMeta(netheriteChestplateItemMeta);

          player.getInventory().addItem(getNetheriteChestplate);

          Bukkit.broadcast(Graphical.PluginPrefix
              .append(Component.text(player.getName()).color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" hat die ").color(NamedTextColor.WHITE))
              .append(Component.text("SKY BRUSTPLATTE").color(NamedTextColor.DARK_RED).decoration(
                  TextDecoration.BOLD, true))
              .append(Component.text(" gekauft!").color(NamedTextColor.WHITE)));


          player.sendActionBar(Component.text()
              .append(Component.text("-")
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(Variables.netheriteChestplatePrice)
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" Münzen")
                  .color(NamedTextColor.WHITE)));

          player.setScoreboard(StatsSidebarUtils.getBaseScoreboard(player));

          SkyPvP.getInstance().getTablistManager().setTablist(player);

          for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
          }

          player.closeInventory();

        } else {
          player.sendMessage(Graphical.PluginPrefix
              .append(Component.text("Du hast nicht genügend Münzen!").color(NamedTextColor.WHITE)));
          player.closeInventory();
        }

      }

      else if(event.getSlot() == 13) {

        if (playerCoins >= Variables.netheriteLeggingsPrice){

          playerStats.setCoins(String.valueOf(player.getUniqueId()), playerCoins - Variables.netheriteLeggingsPrice);
          playerStats.saveStats();

          ItemStack getNetheriteLeggins = new ItemStack(Material.NETHERITE_LEGGINGS);
          ItemMeta netheriteLegginsItemMeta = getNetheriteLeggins.getItemMeta();
          netheriteLegginsItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY HOSE");
          getNetheriteLeggins.setItemMeta(netheriteLegginsItemMeta);

          player.getInventory().addItem(getNetheriteLeggins);

          Bukkit.broadcast(Graphical.PluginPrefix
              .append(Component.text(player.getName()).color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" hat die ").color(NamedTextColor.WHITE))
              .append(Component.text("SKY HOSE").color(NamedTextColor.DARK_RED).decoration(
                  TextDecoration.BOLD, true))
              .append(Component.text(" gekauft!").color(NamedTextColor.WHITE)));


          player.sendActionBar(Component.text()
              .append(Component.text("-")
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(Variables.netheriteLeggingsPrice)
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" Münzen")
                  .color(NamedTextColor.WHITE)));

          player.setScoreboard(StatsSidebarUtils.getBaseScoreboard(player));

          SkyPvP.getInstance().getTablistManager().setTablist(player);

          for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
          }

          player.closeInventory();

        } else {
          player.sendMessage(Graphical.PluginPrefix
              .append(Component.text("Du hast nicht genügend Münzen!").color(NamedTextColor.WHITE)));
          player.closeInventory();
        }

      }

      else if(event.getSlot() == 14) {

        if (playerCoins >= Variables.netheriteBootsPrice){

          playerStats.setCoins(String.valueOf(player.getUniqueId()), playerCoins - Variables.netheriteBootsPrice);
          playerStats.saveStats();

          ItemStack getNetheriteBoots = new ItemStack(Material.NETHERITE_BOOTS);
          ItemMeta netheriteBootsItemMeta = getNetheriteBoots.getItemMeta();
          netheriteBootsItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY SCHUHE");
          getNetheriteBoots.setItemMeta(netheriteBootsItemMeta);

          player.getInventory().addItem(getNetheriteBoots);

          Bukkit.broadcast(Graphical.PluginPrefix
              .append(Component.text(player.getName()).color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" hat die ").color(NamedTextColor.WHITE))
              .append(Component.text("SKY SCHUHE").color(NamedTextColor.DARK_RED).decoration(
                  TextDecoration.BOLD, true))
              .append(Component.text(" gekauft!").color(NamedTextColor.WHITE)));


          player.sendActionBar(Component.text()
              .append(Component.text("-")
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(Variables.netheriteBootsPrice)
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" Münzen")
                  .color(NamedTextColor.WHITE)));

          player.setScoreboard(StatsSidebarUtils.getBaseScoreboard(player));

          SkyPvP.getInstance().getTablistManager().setTablist(player);

          for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
          }

          player.closeInventory();

        } else {
          player.sendMessage(Graphical.PluginPrefix
              .append(Component.text("Du hast nicht genügend Münzen!").color(NamedTextColor.WHITE)));
          player.closeInventory();
        }

      }

      else if(event.getSlot() == 18) {

        if (playerCoins >= Variables.enchantedGoldenApplePrice){

          playerStats.setCoins(String.valueOf(player.getUniqueId()), playerCoins - Variables.enchantedGoldenApplePrice);
          playerStats.saveStats();

          ItemStack getEnchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
          ItemMeta enchantedGoldenAppleItemMeta = getEnchantedGoldenApple.getItemMeta();
          enchantedGoldenAppleItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY APFEL");
          getEnchantedGoldenApple.setItemMeta(enchantedGoldenAppleItemMeta);

          player.getInventory().addItem(getEnchantedGoldenApple);

          Bukkit.broadcast(Graphical.PluginPrefix
              .append(Component.text(player.getName()).color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" hat den ").color(NamedTextColor.WHITE))
              .append(Component.text("SKY APFEL").color(NamedTextColor.DARK_RED).decoration(
                  TextDecoration.BOLD, true))
              .append(Component.text(" gekauft!").color(NamedTextColor.WHITE)));


          player.sendActionBar(Component.text()
              .append(Component.text("-")
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(Variables.enchantedGoldenApplePrice)
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" Münzen")
                  .color(NamedTextColor.WHITE)));

          player.setScoreboard(StatsSidebarUtils.getBaseScoreboard(player));

          SkyPvP.getInstance().getTablistManager().setTablist(player);

          for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            SkyPvP.getInstance().getTablistManager().setPlayerTeams(onlinePlayer);
          }

          player.closeInventory();

        } else {
          player.sendMessage(Graphical.PluginPrefix
              .append(Component.text("Du hast nicht genügend Münzen!").color(NamedTextColor.WHITE)));
          player.closeInventory();
        }

      }
    }
  }

  @EventHandler
  public void onClose(InventoryCloseEvent event){
    Player player = (Player) event.getPlayer();

    if(player.hasMetadata("OpenedShopMenu")){
      player.removeMetadata("OpenedShopMenu", SkyPvP.getInstance());
    }
  }

}
