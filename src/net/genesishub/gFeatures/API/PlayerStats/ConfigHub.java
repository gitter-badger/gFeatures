package net.genesishub.gFeatures.API.PlayerStats;

import java.io.File;
import java.io.IOException;

import net.genesishub.gFeatures.Configuration.Config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ConfigHub {
	static Config config = new Config();
	static File f = new File("plugins/gFeatures/Players/players.yml");
	
	public void setupConfig(){
		Config config = new Config();
		config.createDirectory("plugins/gFeatures/Players", "Setup the players directory for use!");
		config.createFile("plugins/gFeatures/Players/players.yml", "Setup the players file for use!");
		YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
		if(!(yamlFile.contains("Players"))){
		yamlFile.createSection("Players");
		}
		try {
			yamlFile.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadConfig(){
		
	}
	public void addPlayerSection(Player p){
		
	}
}
