package ninjacr.pjm;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.clip.placeholderapi.metrics.bukkit.Metrics;
import ninjacr.pjm.commands.BaseCommand;
import ninjacr.pjm.listener.JoinEvent;
import ninjacr.pjm.listener.LeaveEvent;
import ninjacr.pjm.utils.Utils;

public class Main extends JavaPlugin{
	public String rutaConfig;
	PluginDescriptionFile pdfile = getDescription();
	public String version = pdfile.getVersion();
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6  &ePlayerJoinMessage"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&r"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6*  &aPlugin enabled!"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&r"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6*  &ePlugin version: " + ChatColor.RED + version));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6*  &eAuthor: &1NINJACR"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&r"));
		RegisterEvents();
		RegisterCommands();
		RegisterConfig();
		
		saveDefaultConfig();
		 int pluginId = 13535; // <-- Replace with the id of your plugin!
			@SuppressWarnings("unused")
			Metrics metrics = new Metrics(this, pluginId);
	        
		
			
	}
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6  &ePlayerJoinMessage"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&r"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6*  &cPlugin disabled!"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6*  &ePlugin version: " + ChatColor.RED + version));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6*  &eAuthor: &1NINJACR"));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&r"));
	}
	public void RegisterEvents() {
		PluginManager pm = getServer().getPluginManager(); 
		pm.registerEvents(new JoinEvent(this), this);
		pm.registerEvents(new LeaveEvent(this), this);
	}
	public void RegisterConfig() {
		File config = new File(this.getDataFolder(), "config.yml");
		rutaConfig = config.getPath();
		
		if(config.exists()) {
			this.getConfig().options().copyDefaults(true);
			saveConfig();
		}
			
	}
	public void RegisterCommands() {
		this.getCommand("pjm").setExecutor(new BaseCommand(this));
	}

}