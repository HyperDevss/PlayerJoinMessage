package ninjacr.pjm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import ninjacr.pjm.Main;
import ninjacr.pjm.utils.Utils;
import ninjacr.pjm.utils.UtilsRGB;

public class BaseCommand implements CommandExecutor{
	private Main plugin;
	
	public BaseCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if (!(sender instanceof Player)) {
			Bukkit.getConsoleSender().sendMessage(Utils.chat("&6PJM &f> &cdont execute commands with console"));
			return false;
		}else {
			Player player = (Player) sender;
			
			if(args.length > 0) {

				if(args[0].equalsIgnoreCase("version")) {
					player.sendMessage(Utils.chat("&aVersion of plugin &6PlayerJoinMessage " +ChatColor.RED+plugin.version));
					player.sendMessage(Utils.chat("&aAuthor: &9NINJACR"));
					player.sendMessage(Utils.chat("&aMore features coming soon!"));
				}
				
				else if(args[0].equalsIgnoreCase("reload")) {
					if(player.hasPermission("pjm.reload") && player.hasPermission("*")) {
						plugin.reloadConfig();
					FileConfiguration config = plugin.getConfig();
					String msg2 = config.getString("Messages.reload_message");	
					player.sendMessage(UtilsRGB.getRGBColors(msg2));
					
					}else {
						FileConfiguration config = plugin.getConfig();
						String msg1 = config.getString("Messages.no_permissions");
						player.sendMessage(UtilsRGB.getRGBColors(msg1));
						}
					
				}
				
				if(args[0].equalsIgnoreCase("help")) {
					
					player.sendMessage(Utils.chat("&f&m-----------------------------------"));
			        player.sendMessage(Utils.chat("&f&l Help Page"));
			        player.sendMessage(Utils.chat("&6/pjm help &e> &fHelp Page"));
			        player.sendMessage(Utils.chat("&6/pjm reload &e> &fReload Config Files"));
			        player.sendMessage(Utils.chat("&6/pjm version &e> Version of plugin"));
			        player.sendMessage(Utils.chat("&6/pjm permissions &e> Permissions Page"));
					player.sendMessage(Utils.chat("&f&m-----------------------------------"));
					return true;
				}
					else if(args[0].equalsIgnoreCase("permissions")) {
						if(player.hasPermission("pjm.permissions") && player.hasPermission("*")) {
							player.sendMessage(Utils.chat("&f&m-----------------------------------"));
							player.sendMessage(Utils.chat("&f&l Permission Page>"));
							player.sendMessage(Utils.chat("&f&6 pjm.reload &e> &fReload Permission."));
							player.sendMessage(Utils.chat("&f&6 pjm.permspage &e> &fPermission page &7(This page)"));
							player.sendMessage(Utils.chat("&f&m-----------------------------------"));
					
				
						}else {
							FileConfiguration config = plugin.getConfig();
							String msg1 = config.getString("Messages.no_permissions");
							player.sendMessage(Utils.chat(msg1));
						}
					
				
					
					
				}
					
			}else {
				FileConfiguration config = plugin.getConfig();
				String msg11 = config.getString("Messages.help_cmd");
				player.sendMessage(UtilsRGB.getRGBColors(msg11));
				
				
			}

			
		}
		
		return false;

		
	}

}
