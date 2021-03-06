package net.estinet.gFeatures;

import net.estinet.gFeatures.API.PlayerStats.Load;
import net.estinet.gFeatures.API.PlayerStats.gPlayer;
import net.estinet.gFeatures.Configuration.LoadConfig;
import net.estinet.gFeatures.Configuration.SetupConfig;
import net.genesishub.gFeatures.API.Logger.Debug;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;

/*
gFeatures
https://github.com/EstiNet/gFeatures

   Copyright 2015 EstiNet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

public class Listeners extends JavaPlugin implements Listener{
	public static final String version = "3.0.0-Beta-0.1";
	public static boolean debug = false;
	
	PluginManager pm = getServer().getPluginManager();
	Enabler enable = new Enabler();
	Disabler disable = new Disabler();
	Library library = new Library();
	CommandLibrary commands = new CommandLibrary();
	Setup setup = new Setup();
	Load load = new Load();
	net.estinet.gFeatures.API.PlayerStats.Setup setups = new net.estinet.gFeatures.API.PlayerStats.Setup();
	
	@Override
	public void onEnable(){
	    pm.registerEvents(this, this);
		getLogger().info("_________________________________________________________________________");
		getLogger().info("Starting gFeatures.");
		getLogger().info("Current version: " + version);
		getLogger().info("Starting modules!");
		try{
		setup.onSetup();
		SetupConfig.setup();
		LoadConfig.load();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		enable.onEnable();
		Basic.addPlayerSection("Setup", "DO NOT REMOVE!");
		try{
		load.load();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		getLogger().info("Complete!");
		getLogger().info("_________________________________________________________________________");
	}
	@Override
	public void onDisable(){
		getLogger().info("_________________________________________________________________________");
		getLogger().info("Stopping gFeatures!");
		getLogger().info("Current version: " + version);
		getLogger().info("Turning off modules!");
		disable.onDisable();
		getLogger().info("Complete!");
		getLogger().info("_________________________________________________________________________");
	}
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){ 
		try{
			setups.checkPlayer(event.getPlayer());
			Debug.print("Player API initialized for " + event.getPlayer().getName());
		}
		catch(Exception e){
			Debug.print(e.getMessage());
		}
    	library.onPlayerJoin(event);
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
    	try{
    	gPlayer gp = Basic.getgPlayer(event.getPlayer().getUniqueId().toString());
    	for(String valuename : gp.getValues().keySet()){
    		setups.smartFlush(gp, valuename, gp.getValue(valuename));
    	}
    	Basic.setgPlayer(Basic.getgPlayer(event.getPlayer().getUniqueId().toString()), gp);
    	}
    	catch(Exception e){
    		Debug.print(e.getMessage());
    	}
    	library.onPlayerLeave(event);
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
    	library.onPlayerMove(event);
    }
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	library.onPlayerRespawn(event);
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
    	library.onPlayerDeath(event);
    }
    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
    	library.onEntityDamageByEntity(event);
    }
    @EventHandler
    public void onHit1(WeaponDamageEntityEvent event) {
        library.onWeaponDamageEntity(event);
    }
    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event){
        library.onPlayerInteract(event);
    }
    @EventHandler
    public void PlayerBreakBlock(BlockBreakEvent event){
    	library.onPlayerBreakBlock(event);
    }
    @EventHandler
    public void PlayerChatEvent(AsyncPlayerChatEvent event){
    	library.onPlayerChat(event);
    }
    @EventHandler
    public void PlayerCommandEvent(PlayerCommandPreprocessEvent event){
    	library.onPlayerCommand(event);
    }
    @EventHandler
    public void PlayerInventoryEvent(InventoryOpenEvent event){
    	library.onPlayerOpenInventory(event);
    }
    @EventHandler
    public void PlayerHeldItemEvent(PlayerItemHeldEvent event){
    	library.onPlayerItemHeld(event);
    }
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent event){
    	library.onInventoryClick(event);
    }
    @EventHandler
    public void EntityExplodeEvent(EntityExplodeEvent event){
    	library.onEntityExplode(event);
    }
    @EventHandler
    public void FoodLevelChangeEvent(org.bukkit.event.entity.FoodLevelChangeEvent event){
    	library.onFoodLevelChange(event);
    }
    @EventHandler
    public void PlayerDropItemEvent(PlayerDropItemEvent event){
    	library.onPlayerDrop(event);
    }
    @EventHandler
    public void PlayerToggleFlightEvent(PlayerToggleFlightEvent event){
    	library.onPlayerToggleFlight(event);
    }
    @EventHandler
    public void EntityDamageEvent(EntityDamageEvent event){
    	library.onEntityDamage(event);
    }
    @EventHandler
    public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event){
    	library.onPlayerInteractEntity(event);
    }
    @EventHandler
    public void WeatherChangeEvent(org.bukkit.event.weather.WeatherChangeEvent event){
    	library.onWeatherChange(event);
    }
    @EventHandler
    public void PlayerLoginEvent(PlayerLoginEvent event){
    	library.onPlayerLogin(event);
    }
    @Override
    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    	commands.Commands(sender, cmd, label, args);
        return true;
    }
}
