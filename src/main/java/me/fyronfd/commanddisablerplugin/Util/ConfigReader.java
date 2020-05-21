package me.fyronfd.commanddisablerplugin.Util;

import me.fyronfd.commanddisablerplugin.CommandDisablerPlugin;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigReader {

    private FileConfiguration commandConfig;
    private List<String> disabledCommands;

    public ConfigReader(FileConfiguration config){
        commandConfig = config;
        disabledCommands = commandConfig.getStringList("commands");
    }

    public void saveCommandConfig(){
        try{
            CommandDisablerPlugin.getPlugin().saveConfig();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void reloadCommandConfig(){
        try{
            CommandDisablerPlugin.getPlugin().reloadConfig();
            commandConfig = CommandDisablerPlugin.getPlugin().getConfig();
            disabledCommands = commandConfig.getStringList("commands");
            saveCommandConfig();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addCommand(String commandName){
        disabledCommands.add(commandName);
        commandConfig.set("commands", disabledCommands);
        saveCommandConfig();
    }

    public boolean removeCommand(String commandName){
        boolean removed = disabledCommands.remove(commandName);
        commandConfig.set("commands", disabledCommands);
        saveCommandConfig();
        return removed;
    }

    public List<String> getDisabledCommands(){
        return disabledCommands;
    }

    public String getErrorMessage(){
        return commandConfig.getString("errorMessage");
    }

}
