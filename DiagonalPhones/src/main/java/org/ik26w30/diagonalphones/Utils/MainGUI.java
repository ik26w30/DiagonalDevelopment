package org.ik26w30.diagonalphones.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.ik26w30.diagonalphones.DiagonalPhones;

import java.util.Objects;

public class MainGUI {
    private final Player user;

    public MainGUI(Player user){
        this.user = user;
    }

    public ItemStack createInventory(Material id, int amount, String display){
        ItemStack item = new ItemStack(id, amount);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(display);
        item.setItemMeta(meta);

        return item;
    }

    public void openInv(){
        Inventory inventory = Bukkit.createInventory(null, DiagonalPhones.getInstance().getConfig().getInt("settings.phone-gui.size"), ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.phone-gui.title"))));
        inventory.setItem(DiagonalPhones.getInstance().getConfig().getInt("settings.phone-gui.index-item-one"), createInventory(Material.ORANGE_BANNER, 1, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.phone-gui.display-name-one")))));
        inventory.setItem(DiagonalPhones.getInstance().getConfig().getInt("settings.phone-gui.index-item-two"), createInventory(Material.BLUE_BANNER, 1, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.phone-gui.display-name-two")))));
        inventory.setItem(DiagonalPhones.getInstance().getConfig().getInt("settings.phone-gui.index-item-three"), createInventory(Material.GREEN_BANNER, 1, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.phone-gui.display-name-three")))));
        inventory.setItem(DiagonalPhones.getInstance().getConfig().getInt("settings.phone-gui.index-item-four"), createInventory(Material.GLOBE_BANNER_PATTERN, 1, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.phone-gui.display-name-four")))));
        inventory.setItem(DiagonalPhones.getInstance().getConfig().getInt("settings.phone-gui.index-item-five"), createInventory(Material.COMPASS, 1, ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.phone-gui.display-name-five")))));

        this.user.openInventory(inventory);
    }

}
