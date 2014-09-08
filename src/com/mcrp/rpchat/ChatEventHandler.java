package com.mcrp.rpchat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ChatEventHandler implements Listener {
	
	public ChatManager cm;
	
	public ChatEventHandler() {
		cm = new ChatManager();
	}
	
	@EventHandler
	public void playerJoin(PlayerLoginEvent e) {
		cm.loadPlayer(e.getPlayer());
	}
	
	@EventHandler
	public void playerExit(PlayerQuitEvent e) {
		cm.savePlayer(e.getPlayer());
	}
	
	
}
