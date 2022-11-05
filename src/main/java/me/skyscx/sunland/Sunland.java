package me.skyscx.sunland;

import me.skyscx.sunland.System.EventInventory.CommonInventoryEvent;
import me.skyscx.sunland.System.EventInventory.MenuInventoryEvent;
import me.skyscx.sunland.System.EventInventory.MyInventoryEvent;
import me.skyscx.sunland.System.commands.santa;
import me.skyscx.sunland.System.commands.sback;
import me.skyscx.sunland.System.commands.scheck;
import me.skyscx.sunland.System.commands.ssend;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sunland extends JavaPlugin {
    private static FileConfiguration configuration;
    private static Sunland plugin;
    @Override
    public void onEnable() {

        plugin = this;
        configuration = getConfig();
        Sunland.getPlugin().saveConfig();
        saveDefaultConfig();
        //COMMANDS
        getCommand("santa").setExecutor(new santa());
        getCommand("ssend").setExecutor(new ssend());
        getCommand("scheck").setExecutor(new scheck());
        getCommand("sback").setExecutor(new sback());
        //EVENTS
        Bukkit.getPluginManager().registerEvents(new MenuInventoryEvent(), this);
        Bukkit.getPluginManager().registerEvents(new MyInventoryEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CommonInventoryEvent(), this);


    }
    @Override
    public void onDisable() {
        saveConfig();
    }
    public static FileConfiguration getConfiguration() {return configuration;}
    public static Sunland getPlugin(){return plugin;}
}
