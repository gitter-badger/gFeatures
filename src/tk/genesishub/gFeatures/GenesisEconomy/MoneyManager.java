package tk.genesishub.gFeatures.GenesisEconomy;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.earth2me.essentials.api.UserDoesNotExistException;

public class MoneyManager {
	Connection c = new Connection();
	CheckConfig cc = new CheckConfig();
	String Address = cc.getAddress();
	String Port = cc.getPort();
	String Tablename = cc.getTablename();
	String Username = cc.getUsername();
	String Password = cc.getPassword();
	String URL = c.toURL(Port, Address, Tablename);
	public float getMoney(Player p){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		return Float.parseFloat(rs.get(1));
	}
	public float getMoney(OfflinePlayer p){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		return Float.parseFloat(rs.get(1));
	}
	public void giveMoney(Player p, float amount) throws IllegalArgumentException, IllegalStateException, UserDoesNotExistException{
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		float num = Float.parseFloat(rs.get(1));
		float money = num + amount;
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void takeMoney(Player p, float amount) throws IllegalArgumentException, IllegalStateException, UserDoesNotExistException{
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		float num = Float.parseFloat(rs.get(1));
		float money = num - amount;
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void setMoney(Player p, float amount) throws IllegalArgumentException, IllegalStateException, UserDoesNotExistException{
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + amount + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public List<String> clupicTop(){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "select * from Peoples;");
		return rs;
	}
	public void giveMoney(OfflinePlayer p, float amount){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		float num = Float.parseFloat(rs.get(1));
		float money = num + amount;
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void takeMoney(OfflinePlayer p, float amount){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		float num = Float.parseFloat(rs.get(1));
		float money = num - amount;
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + money + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public void setMoney(OfflinePlayer p, float amount){
		c.Connect(URL, Username, Password, "UPDATE Peoples SET Money = " + amount + "\nWHERE Name = '" + p.getUniqueId().toString() + "';");
	}
	public boolean playerExists(OfflinePlayer p){
		List<String> rs = new ArrayList<>();
		rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
		if(rs.get(1).equals(null)){
			return false;
		}
		else{
			return true;
		}
		}
		public boolean playerExists(Player p){
			List<String> rs = new ArrayList<>();
			rs = c.ConnectReturn(URL, Username, Password, "SELECT Name, Money FROM Peoples WHERE Name = '" + p.getUniqueId().toString() + "';");
			if(rs.get(1).equals(null)){
				return false;
			}
			else{
				return true;
			}
	}
	@SuppressWarnings("deprecation")
	public boolean playerOnline(String name){
		Player[] s = Bukkit.getOnlinePlayers();
		for(Player p : s){
			if(p.getName().equals(s)){
				return true;
			}
		}
		return false;
	}
}
