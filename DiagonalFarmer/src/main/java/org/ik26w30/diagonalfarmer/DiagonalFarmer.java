package org.ik26w30.diagonalfarmer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.ik26w30.diagonalfarmer.Listener.Events;

public final class DiagonalFarmer extends JavaPlugin {
    private static DiagonalFarmer instance;

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
    }

    private void startup() {
        Bukkit.getConsoleSender().sendMessage("Plugin started with " + System.currentTimeMillis() + " ms");
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new Events(), this);
    }

    public static DiagonalFarmer getInstance(){
        return instance;
    }

}
