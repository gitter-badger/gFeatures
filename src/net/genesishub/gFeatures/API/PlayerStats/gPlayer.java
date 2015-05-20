package net.genesishub.gFeatures.API.PlayerStats;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class gPlayer {
	private Player player;
	private String uuid;
	private String name;
	private HashMap<String, String> values;
	public gPlayer(Player players){
		player = players;
		uuid = players.getUniqueId().toString();
		name = player.getName();
	}
	public Player getPlayer(){
		return player;
	}
	public String getUUID(){
		return uuid;
	}
	public String getName(){
		return name;
	}
	public HashMap<String, String> getValues(){
		return values;
	}
	public void setPlayer(Player p){
		player = p;
	}
	@Deprecated
	public void setUUID(String uuids){
		uuid = uuids;
	}
	@Deprecated
	public void setName(String names){
		name = names;
	}
	public void addValue(String valuename, String value){
		values.put(valuename, value);
	}
	public void removeValue(String valuename, String value){
		values.remove(valuename, value);
	}
	public void removeValue(String valuename){
		values.remove(valuename);
	}
	
}
