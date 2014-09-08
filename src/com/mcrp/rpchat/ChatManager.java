package com.mcrp.rpchat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class ChatManager {
	public HashMap<String, PlayerSettings> loadedPlayers;
	
	public static final String path = "plugins" + File.pathSeparator + RolePlayChatPlugin.name + File.pathSeparator + "data"+ File.pathSeparator;
	
	public ChatManager() {
		loadedPlayers = new HashMap<String, PlayerSettings>();
	}
	
	public void loadPlayer(Player p) {
		File f = new File(path + p.getUniqueId().toString());
		f.mkdirs();
		if(f.exists())
			loadedPlayers.put(p.getUniqueId().toString(), (PlayerSettings) deserilizeObject(f));
		else
			loadedPlayers.put(p.getUniqueId().toString(), new PlayerSettings(p));
	}
	
	public void loadPlayers(Player[] players) {
		for(Player p : players)
			loadPlayer(p);
	}
	
	public void savePlayers(Player[] players) {
		for(Player p : players)
			savePlayer(p);
	}
	
	public void savePlayer(Player p) {
		File f = new File(path + p.getUniqueId().toString());
		f.mkdirs();
		if(!loadedPlayers.containsKey(p.getUniqueId().toString()))
			return;
		serilizeObject(f, loadedPlayers.get(p.getUniqueId().toString()));
	}
	
	
	public static void serilizeObject(File file, Object obj) {
		if(!(obj instanceof Serializable)) 
			return;
		try
	      {
	         FileOutputStream fileOut =
	         new FileOutputStream(file);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(obj);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}

	public static Object deserilizeObject(File file) {
		if(!file.exists())
			return null;
		Object obj;
		try
	      {
	         FileInputStream fileIn = new FileInputStream(file);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         obj = in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         return null;
	      }
		return obj;
		
	}
	
}
