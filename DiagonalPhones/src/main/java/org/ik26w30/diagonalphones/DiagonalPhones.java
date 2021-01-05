package org.ik26w30.diagonalphones;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.diagonalphones.Commands.CallCommands;
import org.ik26w30.diagonalphones.Commands.MainCommands;
import org.ik26w30.diagonalphones.Events.MainListener;

public final class DiagonalPhones extends JavaPlugin {
    private static DiagonalPhones instance;

    @Override
    public void onLoad() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        startUp();
        registerCommands();
        registerEvents();
    }

    public void startUp() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Plugin started with " + System.currentTimeMillis() + " ms");
    }

    public void registerCommands(){
        this.getCommand("phone").setExecutor(new MainCommands());
        this.getCommand("call").setExecutor(new CallCommands());
    }

    public void registerEvents(){
        this.getServer().getPluginManager().registerEvents(new MainListener(), this);
    }

    public static DiagonalPhones getInstance(){
        return instance;
    }


}
