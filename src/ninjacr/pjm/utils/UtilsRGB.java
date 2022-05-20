package ninjacr.pjm.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UtilsRGB {
	public static String getRGBColors(String text) {
		if(Bukkit.getVersion().contains("1.16")) {
			Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}"); 
			Matcher match =  pattern.matcher(text);
			
			while(match.find()) {
				String color = text.substring(match.start(), match.end());
				text = text.replace(color, ChatColor.of(color)+"");
				
				match = pattern.matcher(text);
				
			}
			
		}
		return ChatColor.translateAlternateColorCodes('&', text);
		
	}
}
