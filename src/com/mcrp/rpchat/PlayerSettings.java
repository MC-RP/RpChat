package com.mcrp.rpchat;

import java.io.Serializable;
import java.util.ArrayList;

import org.bukkit.entity.Player;

public class PlayerSettings implements Serializable {

	private static final long serialVersionUID = 1L;

	public String ownerUUID;
	public ArrayList<String> prefixes;
	
	public PlayerSettings(Player p) {
		ownerUUID = p.getUniqueId().toString();
		prefixes = new ArrayList<String>();
		prefixes.add(RolePlayChatPlugin.defaultPrefix);
	}
	
	
	
}
