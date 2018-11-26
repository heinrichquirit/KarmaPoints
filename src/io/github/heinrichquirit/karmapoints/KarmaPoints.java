package io.github.heinrichquirit.karmapoints;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.heinrichquirit.karmapoints.commands.CommandManager;
import io.github.heinrichquirit.karmapoints.listeners.RegisterListener;

public class KarmaPoints extends JavaPlugin {

	private HashMap<UUID, Integer> playerKarma;
	private FileConfiguration config;
	private int cooldownAdd;
	private int cooldownRemove;
	
	@Override
	public void onEnable() {
		playerKarma = new HashMap<UUID, Integer>();
		loadFiles();
		config = getConfig();
		loadConfigOptions();
		
		// Register Listener
		getServer().getPluginManager().registerEvents(new RegisterListener(), this);
			
		// Register Command
		getCommand("karma").setExecutor(new CommandManager());
	}
	
	private void loadFiles() {
		// Load config.yml
		saveDefaultConfig();
		
	}
	
	private void loadConfigOptions() {
		cooldownAdd = config.getInt("cooldown-minutes.add");
		cooldownRemove = config.getInt("cooldown-minutes.remove");
	}
	
}
