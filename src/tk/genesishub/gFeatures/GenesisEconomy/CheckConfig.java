package tk.genesishub.gFeatures.GenesisEconomy;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class CheckConfig {
	File f = new File("plugins/gFeatures/gEconomy/Config.yml");
	YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
	public String getPort(){
		if(yamlFile.get("Config.MySQL.Port").equals(null)){
			return "";
		}
		return yamlFile.get("Config.MySQL.Port").toString();
	}
	public String getAddress(){
		if(yamlFile.get("Config.MySQL.Address").equals(null)){
			return "";
		}
		return yamlFile.get("Config.MySQL.Address").toString();
	}
	public String getTablename(){
		if(yamlFile.get("Config.MySQL.TableName").equals(null)){
			return "";
		}
		return yamlFile.get("Config.MySQL.TableName").toString();
	}
	public String getUsername(){
		if(yamlFile.get("Config.MySQL.Username").equals(null)){
			return "";
		}
		return yamlFile.get("Config.MySQL.Username").toString();
	}
	public String getPassword(){
		if(yamlFile.get("Config.MySQL.Password").equals(null)){
			return "";
		}
		return yamlFile.get("Config.MySQL.Password").toString();
	}
	public String getRate(){
		if(yamlFile.get("Config.Trade.Rate").equals(null)){
			return "";
		}
		return yamlFile.get("Config.Trade.Rate").toString();
	}
}
