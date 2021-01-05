package org.ik26w30.diagonalphones.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.ik26w30.diagonalphones.DiagonalPhones;
import org.ik26w30.diagonalphones.Utils.MainGUI;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainListener implements Listener {

    @EventHandler
    public void onJojn(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.getInventory().setItem(DiagonalPhones.getInstance().getConfig().getInt("settings.p-inventory.index-item-phone"), new ItemStack(Material.PRISMARINE_CRYSTALS));
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Material material4 = Material.GLOBE_BANNER_PATTERN;
        Material material = Material.COMPASS;
        Material material1 = Material.ORANGE_BANNER;
        Material material2 = Material.BLUE_BANNER;
        Material material3 = Material.GREEN_BANNER;
        int number = 10;
        List<String> pList = new ArrayList<String>();
        List<Player> player2 = new ArrayList<Player>(Bukkit.getOnlinePlayers());
        ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
        bookMeta.setTitle("§3Sim's Documents");
        bookMeta.setAuthor("§3Ik26w30");
        bookMeta.setPages("\n\n\n\n" + generateRandomNumber(number));
        writtenBook.setItemMeta(bookMeta);
        List<String> pages = new ArrayList<String>();
        pages.add("");
        pages.add("");
        pages.add("");

        /*
        if(event.getView().getTitle() == DiagonalPhones.getInstance().getConfig().getString("settings.phone-gui.title")){
            event.setCancelled(true);
        }
*/
        if(event.getCurrentItem() == null){
            return;
        }


        if(event.getClickedInventory().contains(Material.COMPASS) && event.getCurrentItem().getType().equals(material)){
            Location location = event.getWhoClicked().getLocation();
            player.closeInventory();
            player.sendMessage("x: " + location.getX() + " y: " + location.getY() + " z: " + location.getZ());
        }

        if(event.getClickedInventory().contains(Material.ORANGE_BANNER) && event.getCurrentItem().getType().equals(material1)){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.commands.use-msg-command"))));
            event.setCancelled(true);
        }

        if(event.getClickedInventory().contains(Material.BLUE_BANNER) && event.getCurrentItem().getType().equals(material2)){
            List<String> pList1 = new ArrayList<>();
            for(Player players1 : Bukkit.getOnlinePlayers()){
                pList1.add(players1.getName());
            }
            player.sendMessage("" + pList1);
            event.setCancelled(true);
        }

        if(event.getClickedInventory().contains(Material.GREEN_BANNER) && event.getCurrentItem().getType().equals(material3)){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.commands.use-call-command"))));
            event.setCancelled(true);
        }

        if(event.getClickedInventory().contains(Material.GLOBE_BANNER_PATTERN) && event.getCurrentItem().getType().equals(material4)){
            player.closeInventory();
            player.openBook(writtenBook);
            event.setCancelled(true);
        }


    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getMaterial() == Material.PRISMARINE_CRYSTALS){
            if(player.hasPermission("phone.use")) {
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                    MainGUI gui = new MainGUI(player);
                    gui.openInv();
                }
            }else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.commands.no-perms-msg"))));
                return;
            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

    }
    
    private long generateRandomNumber(int n) {
        long min = (long) Math.pow(10, n - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }
}
