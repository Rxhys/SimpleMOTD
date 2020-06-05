package me.Rxhys.SimpleMOTD.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Rxhys.SimpleMOTD.MainClass;

public class SimpleMOTDCommand implements CommandExecutor {
	MainClass mc = MainClass.getPlugin(MainClass.class);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;

		if (sender instanceof Player) {
			if (!player.hasPermission("simplemotd.admincommands"))
				player.sendMessage(String.valueOf(MainClass.getPrefix()) + ChatColor.RED
						+ "You do not have permission to run this command.");
			if (player.hasPermission("simplemotd.admincommands"))
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("getmotd")) {
						String line1 = ChatColor.translateAlternateColorCodes('&', mc.getConfig().getString("line1"));
						String line2 = ChatColor.translateAlternateColorCodes('&', mc.getConfig().getString("line2"));
						
						player.sendMessage(
								String.valueOf(MainClass.getPrefix()) + ChatColor.GREEN + "Your current MOTD is:");
						player.sendMessage(
								String.valueOf(MainClass.getPrefix()) + ChatColor.GREEN + "Line 1: " + line1);
						player.sendMessage(
								String.valueOf(MainClass.getPrefix()) + ChatColor.GREEN + "Line 2: " + line2);
					} else if (args[0].equalsIgnoreCase("getline1")) {
						String line1 = ChatColor.translateAlternateColorCodes('&', mc.getConfig().getString("line1"));
						player.sendMessage(
								String.valueOf(MainClass.getPrefix()) + ChatColor.GREEN + "Line 1: " + line1);
					} else if (args[0].equalsIgnoreCase("getline2")) {
						String line2 = ChatColor.translateAlternateColorCodes('&', mc.getConfig().getString("line2"));
						player.sendMessage(
								String.valueOf(MainClass.getPrefix()) + ChatColor.GREEN + "Line 2 :" + line2);
					} else if (args[0].equalsIgnoreCase("setline1")) {
						player.sendMessage(
								String.valueOf(MainClass.getPrefix()) + ChatColor.RED + "/simplemotd setline1 <line1>");
					} else if (args[0].equalsIgnoreCase("setline2")) {
						player.sendMessage(
								String.valueOf(MainClass.getPrefix()) + ChatColor.RED + "/simplemotd setline2 <line2>");
					} else {
						sendHelpMessage(player);
					}
				} else if (args.length == 2) {	
					if (args[0].equalsIgnoreCase("setline1")) {
						String motd = args[1];
						
						player.sendMessage(String.valueOf(MainClass.getPrefix()) + ChatColor.GREEN
								+ "Set the line 1 of your motd to: " + ChatColor.RESET
								+ ChatColor.translateAlternateColorCodes('&', motd) + ChatColor.RESET);
						
						mc.getConfig().set("line1", motd);
						mc.saveConfig();
					} else if (args[0].equalsIgnoreCase("setline2")) {
						String motd = args[1];
						
						player.sendMessage(
								String.valueOf(MainClass.getPrefix()) + ChatColor.GREEN + "Set the line 2 of your motd to: "
										+ ChatColor.RESET + ChatColor.translateAlternateColorCodes('&', motd) + "&r");
						
						mc.getConfig().set("line2", motd);
						mc.saveConfig();	
					} else {
						sendHelpMessage(player);
					}
				} else {
					sendHelpMessage(player);
				}
		} else {
			sender.sendMessage(String.valueOf(MainClass.getPrefix()) + ChatColor.RED + "You must be a player to run this command.");
		}
		return true;
	}
	
	public void sendHelpMessage(Player player) {
		player.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&7&m+---------------------------------------------------+"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSimpleMOTD Written by minecraftguy719"));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a/simplemotd: Shows this message."));
		player.sendMessage(
				ChatColor.translateAlternateColorCodes('&', "&a/simplemotd getmotd: Gets your currently set motd."));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&a/simplemotd getline1: Gets the first line of your currently set motd."));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&a/simplemotd getline2: Gets the second line of your currently set motd."));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&a/simplemotd setline1: Sets the first line of your motd."));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&a/simplemotd setline2: Sets the second line of your motd."));
		player.sendMessage(ChatColor.translateAlternateColorCodes('&',
				"&7&m+---------------------------------------------------+"));
	}
}
