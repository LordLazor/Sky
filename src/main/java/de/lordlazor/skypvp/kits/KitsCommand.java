package de.lordlazor.skypvp.kits;

import de.lordlazor.skypvp.SkyPvP;
import java.util.Collections;
import java.util.UUID;
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

public class KitsCommand implements CommandExecutor {


  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {
    if (!(commandSender instanceof Player)) return true;

    Player player = (Player) commandSender;

    Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.DARK_AQUA + "Kits");

    ItemStack getStarterKit = new ItemStack(Material.WOODEN_SWORD);
    ItemMeta starterMeta = getStarterKit.getItemMeta();
    starterMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
    starterMeta.setLore(Collections.singletonList(ChatColor.GREEN + "No cooldown"));
    getStarterKit.setItemMeta(starterMeta);

    inventory.setItem(1, getStarterKit);

    player.openInventory(inventory);
    player.setMetadata("OpenedMenu", new FixedMetadataValue(SkyPvP.getInstance(), "Kits Menu"));

    return true;
  }
}