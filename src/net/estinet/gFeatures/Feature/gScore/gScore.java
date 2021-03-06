package net.estinet.gFeatures.Feature.gScore;

import net.estinet.gFeatures.Retrieval;
import net.estinet.gFeatures.gFeature;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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

public class gScore extends gFeature{
	
	Listeners listeners = new Listeners();
	
	public gScore(String featurename, String d) {
		super(featurename, d);
	}
	@Override
	public void enable(){
		listeners.onEnable();
	}
	@Override
	public void disable(){
		listeners.onDisable();
	}
	@Override
	public void eventTrigger(Event event) {
		if(event.getEventName().equalsIgnoreCase("playerjoinevent")){
			try {
				listeners.onPlayerJoin((PlayerJoinEvent)event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(event.getEventName().equalsIgnoreCase("playerquitevent")){
			try {
				listeners.onPlayerLeave((PlayerQuitEvent)event);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Retrieval
	public void onPlayerJoin(){}
	@Retrieval
	public void onPlayerLeave(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
		//When stuff actually happens
	}
}
