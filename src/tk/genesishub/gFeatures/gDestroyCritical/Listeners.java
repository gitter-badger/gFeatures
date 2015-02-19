package tk.genesishub.gFeatures.gDestroyCritical;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/*gDestroyCritical by the GenesisTeam
 * 
 * 
 * */

public class Listeners{
	Constants cons = new Constants();
	List<String> Acceptance = cons.Acceptance;
	CommandManager cm = new CommandManager();
	GameEndure ge = new GameEndure();
	EntryExitHandler as = new EntryExitHandler();
    
    
	 @Override
     public void onEnable() { //What to do on server load/reload
         getLogger().info("gDestroyCritical is enabled. All clear for take off!");
         PluginManager pm = getServer().getPluginManager();
         pm.registerEvents(this, this);
         FileManager fm = new FileManager();
         fm.checkDirectories();
         if(!cons.f.exists()){
	       fm.AssembleFile(cons.f);
	}
         }
  
     @Override
     public void onDisable() { //What to do on server unload/reload
        getLogger().info("gDestroyCritical is disabled. Bye!");
     }
     @EventHandler
     public void playerJoinEvent(PlayerJoinEvent e){
    	as.onJoin(e.getPlayer());
     }
     @EventHandler
     public void playerLeaveEvent(PlayerQuitEvent e){
    	 as.onLeave(e.getPlayer());
     }
     @Override
     public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
    	cm.onCommands(sender, cmd, label, args);
    	 return true;
     }
     @EventHandler
     public void blockbreakevent(BlockBreakEvent e){
    	ge.onBlockBreak(e.getPlayer());
     }
     //MAKE SURE U RESTRICT BLOCK PLACING TO ONLY CRAFTING TABLES FURNACES AND DIRT AND COBBLE.
}
