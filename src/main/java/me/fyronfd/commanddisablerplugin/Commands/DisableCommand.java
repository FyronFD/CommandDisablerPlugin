package me.fyronfd.commanddisablerplugin.Commands;

import me.fyronfd.commanddisablerplugin.CommandDisablerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DisableCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 1){
            return false;
        }else{
            CommandDisablerPlugin.getConfigReader().addCommand(args[0]);
            sender.sendMessage(ChatColor.GREEN + "Added " + args[0] + " to the disabled commands list. ");
        }

        return true;
    }
}
