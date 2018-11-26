package io.github.heinrichquirit.karmapoints.commands;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public abstract class BaseCommand {
	
	public abstract void execute(Player player, Command command, String[] args);

}
