package de.lordlazor.skypvp;

import static net.kyori.adventure.text.Component.text;

import de.lordlazor.skypvp.admin.AddCoinsCommand;
import de.lordlazor.skypvp.admin.ClearInventoryCommand;
import de.lordlazor.skypvp.admin.GamemodeCommand;

import de.lordlazor.skypvp.admin.GetYawPitch;
import de.lordlazor.skypvp.admin.listeners.BanListener;
import de.lordlazor.skypvp.admin.listeners.KickListener;
import de.lordlazor.skypvp.admin.ToggleTrackerCommand;
import de.lordlazor.skypvp.admin.VanishCommand;
import de.lordlazor.skypvp.admin.listeners.PlayerCommandsListener;
import de.lordlazor.skypvp.admin.listeners.PlayerJoinAddToToggleCommandListener;
import de.lordlazor.skypvp.chat.commands.ClearChatCommand;
import de.lordlazor.skypvp.chat.commands.MuteChatCommand;
import de.lordlazor.skypvp.chat.listeners.ChatListener;
import de.lordlazor.skypvp.kits.KitsCommand;
import de.lordlazor.skypvp.kits.KitsGuiListener;
import de.lordlazor.skypvp.player.HelpCommand;
import de.lordlazor.skypvp.player.OnPlayerRespawnEvent;
import de.lordlazor.skypvp.player.PlayerBreakBlockListener;
import de.lordlazor.skypvp.player.PlayerInfoCommand;
import de.lordlazor.skypvp.player.PlayerJoinListener;
import de.lordlazor.skypvp.player.PlayerLeaveListener;
import de.lordlazor.skypvp.player.SetRankCommand;
import de.lordlazor.skypvp.shop.ShopCommand;
import de.lordlazor.skypvp.shop.ShopGuiListener;
import de.lordlazor.skypvp.stats.KillstreakListener;
import de.lordlazor.skypvp.stats.StatsCommand;
import de.lordlazor.skypvp.stats.StatsOnDiesEvent;
import de.lordlazor.skypvp.stats.StatsOnJoinListener;
import de.lordlazor.skypvp.stats.StatsPlayerKillsPlayerEvent;
import de.lordlazor.skypvp.tablist.TablistJoinListener;
import de.lordlazor.skypvp.tablist.TablistManager;
import de.lordlazor.skypvp.tasks.AlwaysDayTask;
import de.lordlazor.skypvp.tasks.CheckYCoordTask;
import de.lordlazor.skypvp.utils.Variables;
import de.lordlazor.skypvp.world.OnWeatherChangeEvent;
import java.io.File;
import java.io.IOException;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


public final class SkyPvP extends JavaPlugin {

    private TablistManager tablistManager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.getComponentLogger().info(text("Plugin wird geladen...").color(NamedTextColor.GREEN));

        World world = getServer().createWorld(new WorldCreator(Variables.mapName));
        world.setGameRule(GameRule.FALL_DAMAGE, false);
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        world.setDifficulty(Difficulty.EASY);

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        File file = new File(getDataFolder() + File.separator + "stats.yml");
        FileConfiguration statsConfig = YamlConfiguration.loadConfiguration(file);

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        File file2 = new File(getDataFolder() + File.separator + "players.yml");
        FileConfiguration playersConfig = YamlConfiguration.loadConfiguration(file2);

        if(!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        Variables.chatMuted = false;

        registerCommand("gm", new GamemodeCommand());
        registerCommand("mutechat", new MuteChatCommand());
        registerCommand("clearchat", new ClearChatCommand());
        registerCommand("stats", new StatsCommand());
        registerCommand("toggletracker", new ToggleTrackerCommand());
        registerCommand("setrank", new SetRankCommand());
        registerCommand("info", new PlayerInfoCommand());
        registerCommand("getyawpitch", new GetYawPitch());
        registerCommand("kits", new KitsCommand());
        registerCommand("shop", new ShopCommand());
        registerCommand("vanish", new VanishCommand());
        registerCommand("addcoins", new AddCoinsCommand());
        registerCommand("clearinventory", new ClearInventoryCommand());

        registerListener(new ChatListener());
        registerListener(new PlayerCommandsListener());
        registerListener(new StatsOnJoinListener());
        registerListener(new StatsOnDiesEvent());
        registerListener(new StatsPlayerKillsPlayerEvent());
        registerListener(new PlayerJoinAddToToggleCommandListener());
        registerListener(new KillstreakListener());
        registerListener(new HelpCommand());
        registerListener(new PlayerBreakBlockListener());

        registerListener(new PlayerJoinListener());
        registerListener(new OnPlayerRespawnEvent());
        registerListener(new PlayerLeaveListener());

        registerListener(new OnWeatherChangeEvent());

        registerListener(new TablistJoinListener());

        registerListener(new KitsGuiListener());
        registerListener(new ShopGuiListener());

        registerListener(new KickListener());
        registerListener(new BanListener());

        tablistManager = new TablistManager();



        BukkitTask alwaysDay = new AlwaysDayTask().runTaskTimer(this, 0L, 100L);
        BukkitTask killPlayerBelowMap = new CheckYCoordTask().runTaskTimer(this, 0L, 20L);


        this.getComponentLogger().info(text("Plugin erfolgreich geladen").color(NamedTextColor.GREEN));

    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        this.getComponentLogger().info(text("Plugin wird gestoppt...").color(NamedTextColor.RED));

    }

    private void registerCommand(String command, CommandExecutor executor) {
        getCommand(command).setExecutor(executor);
    }

    private void registerListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    public static SkyPvP getInstance(){
        return getPlugin(SkyPvP.class);
    }


}
