package net.pgfmc.afk.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import net.ess3.api.IEssentials;

public class PlayerEvents implements Listener {
	
	IEssentials ess = (IEssentials) Bukkit.getPluginManager().getPlugin("Essentials"); // loads the essentials plugin

	@EventHandler
	public void hitProtect(EntityDamageEvent e) { // cancels damage event if the player is AFK
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if (ess.getUser(player).isAfk()) {
				
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void deAggro(EntityTargetLivingEntityEvent e) { // -------------- disables aggro if a mob targets an AFK player
	
		if (e.getTarget() instanceof Player && e.getEntity() instanceof Monster) {
			
			Player player = (Player) e.getTarget();
			if (ess.getUser(player).isAfk()) {
				
				e.setCancelled(true);
			}
		}
	}
}