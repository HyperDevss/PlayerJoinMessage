package ninjacr.pjm.listener;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.clip.placeholderapi.PlaceholderAPI;
import ninjacr.pjm.Main;
import ninjacr.pjm.utils.UtilsRGB;

public class LeaveEvent implements Listener{
	Main plugin;
	public LeaveEvent(Main plugin) {
		this.plugin = plugin;
		
	}
	
	@EventHandler 
	public void onQuit(PlayerQuitEvent e) {
		FileConfiguration config = plugin.getConfig();
		
		Player p = e.getPlayer();
		
			
			String quitMsg = UtilsRGB.getRGBColors(config.getString("Config.quit_msg").replaceAll("%player%", p.getName()));
			quitMsg = PlaceholderAPI.setPlaceholders(p, quitMsg);
			
			e.setQuitMessage(quitMsg);
			
			
		}
		
	}


