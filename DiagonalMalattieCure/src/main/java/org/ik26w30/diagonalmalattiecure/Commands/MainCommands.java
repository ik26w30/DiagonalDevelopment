package org.ik26w30.diagonalmalattiecure.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.ik26w30.diagonalmalattiecure.DiagonalMalattieCure;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class MainCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("seasonstart")){
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(sender.hasPermission("seasonstart.use")){
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            ArrayList<Player> players = new ArrayList<>();
                            for(Player players1 : Bukkit.getOnlinePlayers()){
                                players.add(players1);
                                Random random = new Random();//
                                players.get(random.nextInt(Bukkit.getServer().getOnlinePlayers().size())).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999,9));
                                players.get(random.nextInt(Bukkit.getServer().getOnlinePlayers().size())).sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalMalattieCure.getInstance().getConfig().getString("settings.commands.infected-msg"))));
                            }
                        }
                    }.runTaskLater(DiagonalMalattieCure.getInstance(), 20);
                }else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalMalattieCure.getInstance().getConfig().getString("settings.commands.no-perms-msg"))));
                    return true;
                }
            }else {
                return true;
            }
        }
        return false;
    }
}
