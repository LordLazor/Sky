package de.lordlazor.skypvp.shop;

import de.lordlazor.skypvp.SkyPvP;
import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.stats.PlayerStats;
import de.lordlazor.skypvp.utils.Variables;
import io.papermc.paper.chat.ChatRenderer;
import java.util.Collections;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

public class ShopCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    Inventory inventory = Bukkit.createInventory(player, 9*3, ChatColor.DARK_AQUA + "Sky" + ChatColor.AQUA + "Shop");

    ItemStack getNetheriteSword = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta netheriteSwordItemMeta = getNetheriteSword.getItemMeta();
    netheriteSwordItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY SCHWERT");
    netheriteSwordItemMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Preis: " + ChatColor.GOLD + Variables.netheriteSwordPrice + " Münzen"));
    getNetheriteSword.setItemMeta(netheriteSwordItemMeta);

    ItemStack getNetheriteHelmet = new ItemStack(Material.NETHERITE_HELMET);
    ItemMeta netheriteHelmetItemMeta = getNetheriteHelmet.getItemMeta();
    netheriteHelmetItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY HELM");
    netheriteHelmetItemMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Preis: " + ChatColor.GOLD + Variables.netheriteHelmetPrice + " Münzen"));
    getNetheriteHelmet.setItemMeta(netheriteHelmetItemMeta);

    ItemStack getNetheriteChestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
    ItemMeta netheriteChestplateItemMeta = getNetheriteChestplate.getItemMeta();
    netheriteChestplateItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY BRUSTPLATTE");
    netheriteChestplateItemMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Preis: " + ChatColor.GOLD + Variables.netheriteChestplatePrice + " Münzen"));
    getNetheriteChestplate.setItemMeta(netheriteChestplateItemMeta);

    ItemStack getNetheriteLeggings = new ItemStack(Material.NETHERITE_LEGGINGS);
    ItemMeta netheriteLeggingsItemMeta = getNetheriteLeggings.getItemMeta();
    netheriteLeggingsItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY HOSE");
    netheriteLeggingsItemMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Preis: " + ChatColor.GOLD + Variables.netheriteLeggingsPrice + " Münzen"));
    getNetheriteLeggings.setItemMeta(netheriteLeggingsItemMeta);

    ItemStack getNetheriteBoots = new ItemStack(Material.NETHERITE_BOOTS);
    ItemMeta netheriteBootsItemMeta = getNetheriteBoots.getItemMeta();
    netheriteBootsItemMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY SCHUHE");
    netheriteBootsItemMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Preis: " + ChatColor.GOLD + Variables.netheriteBootsPrice + " Münzen"));
    getNetheriteBoots.setItemMeta(netheriteBootsItemMeta);

    ItemStack getEnchantedGoldenApple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
    ItemMeta enchantedGoldenAppleMeta = getEnchantedGoldenApple.getItemMeta();
    enchantedGoldenAppleMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "SKY APFEL");
    enchantedGoldenAppleMeta.setLore(Collections.singletonList(ChatColor.WHITE + "Preis: " + ChatColor.GOLD + Variables.enchantedGoldenApplePrice + " Münzen"));
    getEnchantedGoldenApple.setItemMeta(enchantedGoldenAppleMeta);


    PlayerStats playerStats = new PlayerStats();

    ItemStack getCurrentCoins = new ItemStack(Material.GOLD_INGOT);
    ItemMeta currentCoinsMeta = getCurrentCoins.getItemMeta();
    currentCoinsMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Deine Münzen: " + ChatColor.GREEN + playerStats.getCoins(
        String.valueOf(player.getUniqueId())));
    getCurrentCoins.setItemMeta(currentCoinsMeta);


    inventory.setItem(9, getNetheriteSword);

    inventory.setItem(11, getNetheriteHelmet);

    inventory.setItem(12, getNetheriteChestplate);

    inventory.setItem(13, getNetheriteLeggings);

    inventory.setItem(14, getNetheriteBoots);

    inventory.setItem(18, getEnchantedGoldenApple);

    inventory.setItem(8, getCurrentCoins);

    player.openInventory(inventory);
    player.setMetadata("OpenedShopMenu", new FixedMetadataValue(SkyPvP.getInstance(), "Kits Menu"));

    return true;
  }
}
