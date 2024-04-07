package de.lordlazor.skypvp.kits;

import de.lordlazor.skypvp.SkyPvP;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsGuiListener implements Listener {

  @EventHandler
  public void onClick(InventoryClickEvent event){
    Player player = (Player) event.getWhoClicked();

    if (player.hasMetadata("OpenedMenu")){
      event.setCancelled(true);

      if (event.getSlot() == 1){

        player.sendMessage("You selected the Starter Kit.");

        // Sword
        ItemStack sword = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = sword.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        sword.setItemMeta(meta);
        player.getInventory().addItem(sword);

        // Rod
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemMeta rodMeta = rod.getItemMeta();
        rodMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        rod.setItemMeta(rodMeta);
        player.getInventory().addItem(rod);

        // Bow
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        bow.setItemMeta(bowMeta);
        player.getInventory().addItem(bow);

        // Golden Apple
        ItemStack goldenApple = new ItemStack(Material.GOLDEN_APPLE, 2);
        ItemMeta goldenAppleMeta = goldenApple.getItemMeta();
        goldenAppleMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        goldenApple.setItemMeta(goldenAppleMeta);
        player.getInventory().addItem(goldenApple);

        // Steak
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 16);
        ItemMeta steakMeta = steak.getItemMeta();
        steakMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        steak.setItemMeta(steakMeta);
        player.getInventory().addItem(steak);

        // Helmet
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemMeta helmetMeta = helmet.getItemMeta();
        helmetMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        helmet.setItemMeta(helmetMeta);
        player.getInventory().addItem(helmet);

        // Chestplate
        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta chestplateMeta = chestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        chestplate.setItemMeta(chestplateMeta);
        player.getInventory().addItem(chestplate);

        // Leggings
        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta leggingsMeta = leggings.getItemMeta();
        leggingsMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        leggings.setItemMeta(leggingsMeta);
        player.getInventory().addItem(leggings);

        // Boots
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        boots.setItemMeta(bootsMeta);
        player.getInventory().addItem(boots);

        // Arrow
        ItemStack arrow = new ItemStack(Material.ARROW, 32);
        ItemMeta arrowMeta = arrow.getItemMeta();
        arrowMeta.setDisplayName(ChatColor.GRAY + "Starter Kit");
        arrow.setItemMeta(arrowMeta);
        player.getInventory().addItem(arrow);

        player.closeInventory();
      }
    }
  }

  @EventHandler
  public void onClose(InventoryCloseEvent event){
    Player player = (Player) event.getPlayer();

    if(player.hasMetadata("OpenedMenu")){
      player.removeMetadata("OpenedMenu", SkyPvP.getInstance());
    }
  }

}