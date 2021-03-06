package net.genesishub.gFeatures.Feature.gWarsSuiteOld;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.xml.sax.SAXException;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;


/*
gFeatures
https://github.com/GenesisHub/gFeatures

   Copyright 2015 GenesisHub

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

public class Listeners{
	Summon summon = new Summon();
	HitManager hm = new HitManager();
	DeathManager dm = new DeathManager();
	Constants cons = new Constants();
	JoinManager jm = new JoinManager();
	LeaveManager lm = new LeaveManager();
	CommandHub ch = new CommandHub();
	CompassTracker ct = new CompassTracker();
	ListTeams lt = new ListTeams();
	TierSelectionMenu tsm = new TierSelectionMenu();
	GameMenu gm = new GameMenu();
	FileManager fm = new FileManager();
	LobbyTeleport ltp = new LobbyTeleport();
	CrackshotConfiguration cc = new CrackshotConfiguration();
	TotallyNotFlyingBoats tnfb = new TotallyNotFlyingBoats();

    public void onEnable() throws IOException{
    	//SETUP ALL PLUGINS ONENABLE AND FILEMANAGER
    	Bukkit.getServer().getLogger().info("gWarsSuite is enabled!");
    	fm.EnablerCheck();
    	cc.Initialize(true);
    }
    
    public void onDisable() throws IOException{
    	Bukkit.getServer().getLogger().info("gWarsSuite is disabled!");
    	cc.Initialize(false);
    }
    public void onPlayerJoin(PlayerJoinEvent event) throws InterruptedException, ParserConfigurationException, TransformerException, SAXException, IOException{
    	jm.JoinManage(event);
    }
    
    public void onPlayerQuit(PlayerQuitEvent event){
    	lm.ManageLeave(event);
    }
    
    public void onPlayerMove(PlayerMoveEvent event){
    	ltp.Initalize(event);
    }
    public void onPlayerRespawn(PlayerRespawnEvent event) throws InterruptedException{
    	Constants.arena.remove(event.getPlayer().getName());
    	lm.ManageRespawn(event);
    }
    public void onPlayerDeath(PlayerDeathEvent event){
    	Constants.arena.remove(event.getEntity().getName());
    	dm.ManageDeath(event.getEntity(), event);
    }
    public void onCommandPre(PlayerCommandPreprocessEvent event){
    	String[] args = event.getMessage().split(" ");
    	Lobby lobby = new Lobby();
    	Command cmd = null;
    	String label = "Hi.";
    	if(args[0].equalsIgnoreCase("/spawn")){
    		lobby.LobbyInitiate(event.getPlayer(), cmd, label, args, "spawn");
    		event.setMessage("");
    	}
    }
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        hm.EntityDamageByOther(event);
    }
        public void onWeaponDamageEntity(WeaponDamageEntityEvent event) {
            hm.WeaponDamage(event);
        }
        public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    		try {
				ch.CommandInitiate(sender, cmd, label, args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
        }
        public void onPlayerInteract(PlayerInteractEvent event){
        	tsm.Initialize(event);
        	tnfb.Initialize(event);
        	gm.Initialize(event.getPlayer());
        	ct.onCompassTracker(event);
       	 }
        public boolean getIsland(int X, int Z){
        	if((X == 551 || (X > 551 && !(X>(551-5)))||(X < 551 && !(X<551-5)))&&(Z == 421 || (Z > 421 && !(Z>(421-5)))||(Z < 421 && !(Z<421-5)))){
        		return true;
        	}
			return false;
        	
        }
        public boolean getTown(int X, int Z){
        	if((X == 496 || (X > 496 && !(X>(496-5)))||(X < 496 && !(X<486-5)))&&(Z == 177 || (Z > 177 && !(Z>(177-5)))||(Z < 177 && !(Z<177-5)))){
        		return true;
        	}
			return false;
        }

}
