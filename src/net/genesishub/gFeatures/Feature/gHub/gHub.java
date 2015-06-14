package net.genesishub.gFeatures.Feature.gHub;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.genesishub.gFeatures.Retrieval;
import net.genesishub.gFeatures.gFeature;

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

public class gHub extends gFeature{
	Listeners listeners = new Listeners();
	EventHub eh = new EventHub();
	public gHub(String featurename, String d) {
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
			eh.onPlayerJoin((PlayerJoinEvent)event);
		}
		else if(event.getEventName().equalsIgnoreCase("playerdropitemevent")){
			eh.onPlayerDrop((PlayerDropItemEvent)event);
		}
	}
	@Override
	@Retrieval
	public void onPlayerJoin(){}
	@Override
	@Retrieval
	public void onPlayerDrop(){}
	@Override
	public void commandTrigger(CommandSender sender, Command cmd, String label, String[] args) { 
			//When there's stuff
	}
}
