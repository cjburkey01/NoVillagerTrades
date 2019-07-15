package com.cjburkey.novillagertrades;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class NoVillagerTrades extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new VillagerEvent(), this);
    }

    private static class VillagerEvent implements Listener {

        @EventHandler
        @SuppressWarnings("unused")
        public void onPlayerRightClickEntity(PlayerInteractEntityEvent e) {
            if (!e.getPlayer().hasPermission("novillagertrades.bypass") && e.getRightClicked().getType().equals(EntityType.VILLAGER)) {
                e.setCancelled(true);
            }
        }

    }

}
