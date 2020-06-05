package me.Rxhys.SimpleMOTD;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.Rxhys.SimpleMOTD.Command.SimpleMOTDCommand;
import me.Rxhys.SimpleMOTD.Listener.PingHandler;

public class MainClass extends JavaPlugin{
	public static String getPrefix() {
		return ChatColor.GRAY + "[" + ChatColor.BLUE + "SimpleMOTD" + ChatColor.GRAY + "] ";
	}

	@Override
	public void onEnable() {
		createdConfig();
		registerListener(new PingHandler());
		registerCommand("simplemotd", new SimpleMOTDCommand());
		super.onEnable();
	}
	
	private void registerCommand(String command, CommandExecutor commandClass) {
		getCommand(command).setExecutor(commandClass);
	}

	private void createdConfig() {
		saveDefaultConfig();
		getConfig().options().copyDefaults(true);
	}

	private void registerListener(Listener listener) {
		getServer().getPluginManager().registerEvents(listener, this);
	}
	
}
