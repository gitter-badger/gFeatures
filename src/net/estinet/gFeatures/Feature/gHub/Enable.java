package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.Basic;
import net.estinet.gFeatures.Command.RegisterCommand;
import net.estinet.gFeatures.Feature.gHub.command.Spawn;
import net.estinet.gFeatures.Feature.gHub.config.gHubConfig;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;

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

public class Enable {
	public void onEnable(){
		Bukkit.getLogger().info("[gHub] gHub is enabled! Hi!");
		Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
		RegisterCommand rc = new RegisterCommand();
		rc.register(new Spawn(), "spawn");
		gHubConfig ghc = new gHubConfig();
		ghc.setup();
		
		Basic.addPlayerSection("Settings", "");
		Basic.addPlayerSection("Settings.showChat", "true");
		Basic.addPlayerSection("Settings.scoreBoard", "true");
		
		/*Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getServer().getPluginManager().getPlugin("gFeatures"), new Runnable() {
        	public void run(){
        		PreventFall pf = new PreventFall();
        		pf.check();
        	}
        }, 40L, 40L);*/
	}
}
