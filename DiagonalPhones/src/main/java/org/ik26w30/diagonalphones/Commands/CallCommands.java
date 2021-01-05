package org.ik26w30.diagonalphones.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ik26w30.diagonalphones.DiagonalPhones;

import java.util.Objects;

public class CallCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("call")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("phone.use")) {
                    if (((Player) sender).getItemInHand().getType().equals(Material.PRISMARINE_CRYSTALS)) {
                        Player player = (Player) sender;
                        if (args.length == 2) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target != null) {
                                if (target != sender) {
                                    String message = args[1];
                                    target.sendMessage(ChatColor.RED + "[" + player.getName() + "]" + " " + ChatColor.WHITE + message);
                                    sender.sendMessage(ChatColor.RED + "You have succesfully called " + target.getName());
                                } else {
                                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.commands.call-yourself"))));
                                    return true;
                                }
                            } else {
                                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.commands.target-no-exist"))));
                                return true;
                            }
                        } else {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.commands.call-args-exception"))));
                            return true;
                        }
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.commands.main-in-hand"))));
                        return true;
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(DiagonalPhones.getInstance().getConfig().getString("settings.commands.no-perms-msg"))));
                    return true;
                }
            }else {
                return true;
            }

        }
        return false;
    }
}