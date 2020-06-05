package me.Rxhys.SimpleMOTD.Listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.Rxhys.SimpleMOTD.MainClass;

public class PingHandler implements Listener {
	MainClass mc = MainClass.getPlugin(MainClass.class);
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPing(ServerListPingEvent event) {
		String line1 = ChatColor.translateAlternateColorCodes('&', mc.getConfig().getString("line1"));
		String line2 = ChatColor.translateAlternateColorCodes('&', mc.getConfig().getString("line2"));
		event.setMotd(String.valueOf(line1) + "\n" + line2);
	}
}
