package de.lordlazor.skypvp.utils;

import static net.kyori.adventure.text.Component.text;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;


public class Graphical {

  public static final Component PluginPrefix = text()
      .content("Sky").color(NamedTextColor.DARK_AQUA)
      .append(text("PvP").color(NamedTextColor.AQUA))
      .append(text(" » ").color(NamedTextColor.GRAY))
      .build();

  public static final Component NoPermissions = text()
      .append(PluginPrefix)
      .append(text("Dazu hast du keine Rechte.").color(NamedTextColor.RED))
      .build();

  public static final Component ServerPrefix = text()
      .append(text("SERVER » ").color(NamedTextColor.DARK_RED).decoration(TextDecoration.BOLD, true))
      .build();

  public static final Component CommandTracker = text()
      .append(text("TRACKER » ").color(NamedTextColor.DARK_AQUA).decoration(TextDecoration.BOLD, true))
      .build();

}
