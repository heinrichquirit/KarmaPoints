package io.github.heinrichquirit.karmapoints.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.heinrichquirit.karmapoints.KarmaPermission;
import net.md_5.bungee.api.ChatColor;

public class CommandManager implements CommandExecutor {

	private final ChatColor AQ = ChatColor.AQUA;
	private final ChatColor DAQ = ChatColor.DARK_AQUA;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be in-game to use this command");
			return true;
		}
		Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("karma")) {
			if (args.length == 0) {
				sendHelpInfo(player);
				return true;
			}
		}
		return false;
	}
	
	private void sendHelpInfo(Player player) {
		List<KarmaPermission> perms = Arrays.asList(KarmaPermission.values());
		player.sendMessage(DAQ + "===============" + AQ + "(KarmaPoints)" + DAQ + "===============");
		for (KarmaPermission p : perms) {
			if (player.hasPermission(p.toString())) {
				player.sendMessage(AQ + p.getSyntax() + DAQ + " - " + p.getDescription());
			}
		}
	}

}
