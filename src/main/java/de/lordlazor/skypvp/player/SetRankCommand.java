package de.lordlazor.skypvp.player;

import com.google.errorprone.annotations.Var;
import de.lordlazor.skypvp.utils.Graphical;
import de.lordlazor.skypvp.utils.Variables;
import java.util.Arrays;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.jetbrains.annotations.NotNull;

public class SetRankCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command,
      @NotNull String s, @NotNull String[] strings) {

    Player player = (Player) commandSender;

    PlayerInfo playerInfo = new PlayerInfo();

    String playerRank = playerInfo.getPlayersRank(String.valueOf(player.getUniqueId()));

    if(player.isOp() || playerRank.equals("Owner")) {

      if(strings.length != 2) return false;

      String targetPlayer = strings[0];

      Player playerTarget = player.getServer().getPlayer(targetPlayer);

      if(playerTarget == null){
        player.sendMessage(Graphical.ServerPrefix.append(
            Component.text("Der Spieler ist nicht online!").color(
            NamedTextColor.RED)));
        return true;
      } else {

        if(Arrays.asList(Variables.ranks).contains(strings[1])){

          playerInfo.setPlayersRank(String.valueOf(playerTarget.getUniqueId()), strings[1]);

          playerInfo.savePlayers();

          player.sendMessage(Graphical.ServerPrefix
              .append(Component.text("Der Spieler ")
                  .color(NamedTextColor.WHITE))
              .append(Component.text(playerTarget.getName())
                  .color(NamedTextColor.AQUA))
              .append(Component.text(" hat nun den Rang ")
                  .color(NamedTextColor.WHITE))
              .append(Component.text(strings[1])
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(".")
                  .color(NamedTextColor.WHITE)));

          playerTarget.sendMessage(Graphical.ServerPrefix
              .append(Component.text("Du hast den Rang ")
                  .color(NamedTextColor.WHITE))
              .append(Component.text(strings[1])
                  .color(NamedTextColor.DARK_AQUA))
              .append(Component.text(" von ")
                  .color(NamedTextColor.WHITE))
              .append(Component.text(player.getName())
                  .color(NamedTextColor.AQUA))
              .append(Component.text(" erhalten.")
                  .color(NamedTextColor.WHITE)));

          String newRank = "";

          if (strings[1].equals("Owner")) {
            newRank = Variables.ownerRank;
          } else if (strings[1].equals("Admin")) {
            newRank = Variables.adminRank;
          } else if (strings[1].equals("Moderator")) {
            newRank = Variables.moderatorRank;
          } else if (strings[1].equals("Team")) {
            newRank = Variables.teamRank;
          } else if (strings[1].equals("Builder")) {
            newRank = Variables.builderRank;
          } else if (strings[1].equals("Premium")) {
            newRank = Variables.premiumRank;
          } else if (strings[1].equals("Spieler")) {
            newRank = Variables.spielerRank;
          }

          playerTarget.kick(Component.text("Dein Rang wurde geändert!")
              .color(NamedTextColor.DARK_AQUA)
              .appendNewline()
              .appendNewline()
              .append(Component.text("Bitte logge dich erneut ein!")
                  .color(NamedTextColor.WHITE))
              .appendNewline()
              .appendNewline()
              .append(Component.text("Dein neuer Rang: ")
                  .color(NamedTextColor.WHITE)
              .append(Component.text(newRank))));

          return true;

        }
        else {
          player.sendMessage(Graphical.ServerPrefix.append(
              Component.text("Dieser Rang existiert nicht!").color(
                  NamedTextColor.RED)));
          return true;
        }

      }

    }

    return true;
  }
}
