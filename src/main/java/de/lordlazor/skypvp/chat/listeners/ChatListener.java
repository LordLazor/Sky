package de.lordlazor.skypvp.chat.listeners;

import de.lordlazor.skypvp.player.PlayerInfo;
import de.lordlazor.skypvp.utils.Variables;
import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class ChatListener implements Listener, ChatRenderer {

  @EventHandler
  public void onChat(AsyncChatEvent event) {
    event.renderer(this);


    if (Variables.chatMuted) {

      event.getPlayer().sendMessage(
          Component.text("Der Chat ist momentan deaktiviert.")
              .color(NamedTextColor.RED));

      event.setCancelled(true);
    }

  }

  @Override
  public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
    PlayerInfo playerInfo = new PlayerInfo();

    String rank = playerInfo.getPlayersRank(String.valueOf(source.getUniqueId()));

    if(rank.equals("Owner")){

      return Component.text()
          .append(Component.text("OWNER ")
              .color(NamedTextColor.DARK_RED)
              .decoration(TextDecoration.BOLD, true))
          .append(sourceDisplayName
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(Component.text(": ")
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(message
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .build();

    }else if(rank.equals("Admin")){

      return Component.text()
          .append(Component.text("ADMIN ")
              .color(NamedTextColor.RED)
              .decoration(TextDecoration.BOLD, true))
          .append(sourceDisplayName
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(Component.text(": ")
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(message
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .build();

    }else if(rank.equals("Moderator")){

      return Component.text()
          .append(Component.text("MOD ")
              .color(NamedTextColor.DARK_AQUA)
              .decoration(TextDecoration.BOLD, true))
          .append(sourceDisplayName
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(Component.text(": ")
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(message
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .build();

    }else if(rank.equals("Team")){

      return Component.text()
          .append(Component.text("TEAM ")
              .color(NamedTextColor.AQUA)
              .decoration(TextDecoration.BOLD, true))
          .append(sourceDisplayName
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(Component.text(": ")
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(message
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .build();

    }else if(rank.equals("Builder")){

      return Component.text()
          .append(Component.text("BUILDER ")
              .color(NamedTextColor.YELLOW)
              .decoration(TextDecoration.BOLD, true))
          .append(sourceDisplayName
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(Component.text(": ")
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(message
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .build();

    }else if(rank.equals("Premium")){

      return Component.text()
          .append(Component.text("PREMIUM ")
              .color(NamedTextColor.GOLD)
              .decoration(TextDecoration.BOLD, true))
          .append(sourceDisplayName
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(Component.text(": ")
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(message
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .build();

    } else {

      return Component.text()
          .append(Component.text("SPIELER ")
              .color(NamedTextColor.GRAY)
              .decoration(TextDecoration.BOLD, true))
          .append(sourceDisplayName
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(Component.text(": ")
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .append(message
              .color(NamedTextColor.WHITE)
              .decoration(TextDecoration.BOLD, false))
          .build();
    }

  }
}
