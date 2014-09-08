package com.mcrp.rpchat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RolePlayChatPlugin extends JavaPlugin {
	
	public static String defaultPrefix = "Deafult";
	public static String name;
	ChatEventHandler events;
	
	public void onEnable() {
		events = new ChatEventHandler();
		events.cm.loadPlayers((Player[]) Bukkit.getOnlinePlayers().toArray());
		Bukkit.getPluginManager().registerEvents(events, this);
	}
	
	public void onDisable() {
		events.cm.savePlayers((Player[]) Bukkit.getOnlinePlayers().toArray());
	}
	
}
