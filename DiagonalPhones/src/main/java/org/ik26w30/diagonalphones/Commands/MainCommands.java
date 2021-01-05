package org.ik26w30.diagonalphones.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ik26w30.diagonalphones.DiagonalPhones;
import org.ik26w30.diagonalphones.Utils.MainGUI;

import java.util.Objects;

public class MainCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(command.getName().equalsIgnoreCase("phone")){
                if(sender instanceof Player){
                    Player player = (Player) sender;
                    if(sender.hasPermission("phone.use")){
                        MainGUI gui = new MainGUI(player);
                        gui.openInv();
                    }else {
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
