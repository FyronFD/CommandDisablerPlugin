package me.fyronfd.commanddisablerplugin;

import me.fyronfd.commanddisablerplugin.Commands.DisableCommand;
import me.fyronfd.commanddisablerplugin.Commands.EnableCommand;
import me.fyronfd.commanddisablerplugin.Commands.ReloadDisabledCommand;
import me.fyronfd.commanddisablerplugin.Events.CommandProcessed;
import me.fyronfd.commanddisablerplugin.Util.ConfigReader;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CommandDisablerPlugin extends JavaPlugin {
    private static ConfigReader configReader;
    private static CommandDisablerPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        configReader = new ConfigReader(config);

        Objects.requireNonNull(getCommand("disableCommand")).setExecutor(new DisableCommand());
        Objects.requireNonNull(getCommand("enableCommand")).setExecutor(new EnableCommand());
        Objects.requireNonNull(getCommand("reloadDisabled")).setExecutor(new ReloadDisabledCommand());

        getServer().getPluginManager().registerEvents(new CommandProcessed(), this);
    }

    public static ConfigReader getConfigReader(){
        return configReader;
    }

    public static CommandDisablerPlugin getPlugin(){
        return plugin;
    }
}
