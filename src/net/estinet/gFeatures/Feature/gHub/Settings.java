package net.estinet.gFeatures.Feature.gHub;

import net.estinet.gFeatures.API.Inventory.InventoryAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

public class Settings {
	public void init(Player p){
		InventoryAPI open = makeInventory(p);
		open.open(p);
	}
	public InventoryAPI makeInventory(final Player p){
		try{
		InventoryAPI menu = new InventoryAPI(ChatColor.GRAY + "Settings", 9, new InventoryAPI.OptionClickEventHandler() {
	        @Override
	        public void onOptionClick(final InventoryAPI.OptionClickEvent event) {
	            if(event.getName().equals(ChatColor.GOLD+" ")){
	            	
	            }
	            else if(event.getName().equals(ChatColor.GOLD+" ")){
		            
		           event.getPlayer().closeInventory();
		      }
	            event.setWillClose(true);
	        }
	    }, Bukkit.getServer().getPluginManager().getPlugin("gFeatures"))
    .setOption(0, new ItemStack(Material.SULPHUR, 1), ChatColor.GOLD+"Show/Hide Players", ChatColor.WHITE+"Stand on an airfield!")
    .setOption(1, new ItemStack(Material.MINECART, 1), ChatColor.GOLD+"Summon Anti Aircraft Guns", ChatColor.WHITE+"Stand close to an Anti-Aircraft Station!")
    .setOption(2, new ItemStack(Material.BOAT, 1), ChatColor.GOLD+"Summon Boat", ChatColor.WHITE+"Stand on a docks!");
	return menu;
	}catch(Exception e){
		e.printStackTrace();
	}
		return null;
    }
}
