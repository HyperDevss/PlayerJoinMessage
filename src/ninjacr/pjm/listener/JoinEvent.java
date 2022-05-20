package ninjacr.pjm.listener;


import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.clip.placeholderapi.PlaceholderAPI;
import ninjacr.pjm.Main;
import ninjacr.pjm.utils.Utils;
import ninjacr.pjm.utils.UtilsRGB;

public class JoinEvent implements Listener{
	Main plugin;
	public JoinEvent(Main plugin) {
		this.plugin = plugin;
		
	}
	@EventHandler
    public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		
		
		if(e.getPlayer().hasPlayedBefore()) {
			FileConfiguration config = plugin.getConfig();
        String joinMsg = Utils.chat(config.getString("Config.join_msg")).replaceAll("%player%", p.getName());
        joinMsg = PlaceholderAPI.setPlaceholders(p, joinMsg);
        e.setJoinMessage(UtilsRGB.getRGBColors(joinMsg));
        	
			
		}else {
			FileConfiguration config = plugin.getConfig();
			String joinMsg = Utils.chat(config.getString("Config.first_join_msg")).replaceAll("%player%", p.getName());
	        joinMsg = PlaceholderAPI.setPlaceholders(p, joinMsg);
	        e.setJoinMessage(UtilsRGB.getRGBColors(joinMsg));
		}
		
		FileConfiguration config = plugin.getConfig();
        // Welcome Message
        
        String path = "WelcomeMOTD.enable";
        if(config.getString(path).equals("true")) {
            List<String> welMsg = config.getStringList("WelcomeMOTD.MOTD");
            welMsg = PlaceholderAPI.setPlaceholders(p, welMsg);
            for(String string : welMsg) {
                p.sendMessage(UtilsRGB.getRGBColors(string).replace("%player%", p.getName()));
               
          }
            }else {
            	p.sendMessage("");
            }
        

        }
            
			  
        }
		
    