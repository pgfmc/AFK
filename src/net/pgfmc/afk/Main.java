package net.pgfmc.afk;

import org.bukkit.plugin.java.JavaPlugin;

import net.pgfmc.afk.events.PlayerEvents;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
	}
}