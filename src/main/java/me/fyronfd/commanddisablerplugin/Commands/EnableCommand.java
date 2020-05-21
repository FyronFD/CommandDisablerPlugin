package me.fyronfd.commanddisablerplugin.Commands;

import me.fyronfd.commanddisablerplugin.CommandDisablerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EnableCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 1){
            return false;
        }else{
            boolean successful = CommandDisablerPlugin.getConfigReader().removeCommand(args[0]);
            if(successful){
                sender.sendMessage(ChatColor.GREEN + "Removed " + args[0] + " from the disabled commands list. ");
            }else{
                sender.sendMessage(ChatColor.RED + "Could not remove " + args[0] + " from the disabled commands list.");
            }

        }

        return true;
    }
}