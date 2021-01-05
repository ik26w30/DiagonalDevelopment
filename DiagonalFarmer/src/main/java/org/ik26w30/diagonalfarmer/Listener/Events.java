package org.ik26w30.diagonalfarmer.Listener;

import javafx.print.PageLayout;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.ik26w30.diagonalfarmer.DiagonalFarmer;

import java.util.Objects;

public class Events implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        ItemStack itemStack = new ItemStack(Material.WHITE_DYE);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "Cocaina");
        itemStack.setItemMeta(meta);
        //---
        ItemStack itemStack1 = new ItemStack(Material.CYAN_DYE);
        ItemMeta meta1 = itemStack1.getItemMeta();
        meta1.setDisplayName(ChatColor.AQUA + "Metanfetamina");
        itemStack1.setItemMeta(meta1);
        Player player = (Player) e.getPlayer();
        if(e.getBlockAgainst().getType().equals(Material.BLUE_ORCHID) || e.getBlockPlaced().getType().equals(Material.BLUE_ORCHID)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalFarmer.getInstance().getConfig().getString("settings.drug-info.drug-planted-msg"))));

            new BukkitRunnable(){

                @Override
                public void run() {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalFarmer.getInstance().getConfig().getString("settings.drug-info.drug-done"))));
                    player.getInventory().setItem(DiagonalFarmer.getInstance().getConfig().getInt("settings.drug-info.index-drug"), itemStack1);
                    e.setCancelled(true);
                }
            }.runTaskLater(DiagonalFarmer.getInstance(), 24000);
        }

        if(e.getBlockAgainst().getType().equals(Material.LILY_OF_THE_VALLEY) || e.getBlockPlaced().getType().equals(Material.LILY_OF_THE_VALLEY)){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalFarmer.getInstance().getConfig().getString("settings.drug-info.drug-planted-msg"))));

            new BukkitRunnable(){

                @Override
                public void run() {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalFarmer.getInstance().getConfig().getString("settings.drug-info.drug-done"))));
                    player.getInventory().setItem(DiagonalFarmer.getInstance().getConfig().getInt("settings.drug-info.index-drug"), itemStack);
                    e.setCancelled(true);
                }
            }.runTaskLater(DiagonalFarmer.getInstance(), 24000);
        }

    }
}

