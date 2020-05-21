package me.fyronfd.commanddisablerplugin.Commands;

import me.fyronfd.commanddisablerplugin.CommandDisablerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadDisabledCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandDisablerPlugin.getConfigReader().reloadCommandConfig();
        sender.sendMessage(ChatColor.GREEN + "Disabled Commands Config reloaded");
        return true;
    }
}
