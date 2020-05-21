package me.fyronfd.commanddisablerplugin.Events;

import me.fyronfd.commanddisablerplugin.CommandDisablerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class CommandProcessed implements Listener {

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent e){
        String command = e.getMessage();
        String commandName = getCommandName(command);

        if(CommandDisablerPlugin.getConfigReader().getDisabledCommands().contains(commandName)){
            e.setCancelled(true);
            Player player = e.getPlayer();
            player.sendMessage(ChatColor.RED + CommandDisablerPlugin.getConfigReader().getErrorMessage());
            CommandDisablerPlugin.getPlugin().getLogger().info("Restricted " + player.getDisplayName() + " from using the command: " + commandName);
        }
    }

    @EventHandler
    public void onServerCommand(ServerCommandEvent e){
        String command = e.getCommand();
        String commandName = getCommandName(command);

        if(CommandDisablerPlugin.getConfigReader().getDisabledCommands().contains(commandName)){
            e.setCancelled(true);
            CommandDisablerPlugin.getPlugin().getLogger().info("Restricted the sender from using the command: " + commandName);
        }
    }

    private String getCommandName(String command){
        int indexOfSlash = command.indexOf("/");
        int indexOfSpace = command.indexOf(" ");
        if(indexOfSlash == 0 && indexOfSpace > -1){//Player Command with Args
            return command.substring(1, indexOfSpace);
        }else if(indexOfSlash == 0){//Player Command without Args
            return command.substring(1);
        }else if(indexOfSpace > -1){//Server Command without slash and with Args
            return command.substring(0, indexOfSpace);
        }else{//Server command without slash and without Args
            return command;
        }
    }
}
