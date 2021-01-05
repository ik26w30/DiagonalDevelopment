package org.ik26w30.diagonalmalattiecure;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.diagonalmalattiecure.Commands.MainCommands;
import org.ik26w30.diagonalmalattiecure.Listener.Events;

public final class DiagonalMalattieCure extends JavaPlugin {
    private static DiagonalMalattieCure instance;

    @Override
    public void onLoad() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        registerEvents();
        startup();
        registerCommands();
    }

    private void registerCommands() {
        this.getCommand("seasonstart").setExecutor(new MainCommands());
    }

    private void startup() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "Plugin started with " + System.currentTimeMillis() + " ms");
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new Events(), this);
    }

    public static DiagonalMalattieCure getInstance(){
        return instance;
    }

}
