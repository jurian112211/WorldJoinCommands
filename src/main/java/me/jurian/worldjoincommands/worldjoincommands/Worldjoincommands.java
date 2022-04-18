package me.jurian.worldjoincommands.worldjoincommands;

import me.jurian.worldjoincommands.worldjoincommands.CommandHandlers.BypassTabCompleter;
import me.jurian.worldjoincommands.worldjoincommands.CommandHandlers.CommandManager;
import me.jurian.worldjoincommands.worldjoincommands.CommandHandlers.MainTabCompleter;
import me.jurian.worldjoincommands.worldjoincommands.Events.JoinEvent;

import java.util.Objects;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig1;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig2;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig3;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

//There is some documentation out of here, that's for learning purposes.
public class Worldjoincommands extends JavaPlugin {
    public FileConfiguration config;
    public static Worldjoincommands instance;

    public static Worldjoincommands getInstance() {
        return instance;
    }


    public void onEnable() {
        instance = this;
        Configs();
        getCommand("worldjoincommands").setTabCompleter(new MainTabCompleter());
        Objects.requireNonNull(getCommand("worldjoincommands")).setExecutor(new CommandManager());
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        this.enablemessage();
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            System.out.println(CustomConfig1.get().getString("console-messages.activating-papi-hook"));
            System.out.println(CustomConfig1.get().getString("console-messages.papi-hook-activated"));
        } else {
            System.out.println(CustomConfig1.get().getString("console-messages.placeholderapi-not-found"));
        }
    }

    private void Configs() {
        CustomConfig1.setup();
        //CustomConfig1.get().addDefault("test", "true"); -- for new config options.
        CustomConfig1.get().options().copyDefaults(true);
        CustomConfig1.save();
        CustomConfig2.setup();
        //CustomConfig2.get().addDefault("test", "true"); -- for new config options.
        CustomConfig2.get().options().copyDefaults(true);
        CustomConfig2.save();
        CustomConfig3.setup();
        //CustomConfig3.get().addDefault("test", "true"); -- for new config options.
        CustomConfig3.get().options().copyDefaults(true);
        CustomConfig3.save();
    }

    public void onDisable() {
        instance = null;
        this.disablemessage();
    }

    private void enablemessage() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[]=====[Enabling WorldJoinCommands]=====[]");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Information:");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Name: WorldJoinCommands");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Developer: Jurian32e");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Version: 2.0");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Support:");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    SpigotMC: https://spigotmc.org/resources/worldjoincommands.99230/");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Discord: https://discord.gg/FUjvJsacUA");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "All rights reserved by Jurian32e");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[]================================[]");
    }

    private void disablemessage() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[]=====[Disabling WorldJoinCommands]=====[]");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Information:");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Name: WorldJoinCommands");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Developer: Jurian32e");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Version: 2.0");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Support:");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    SpigotMC: https://spigotmc.org/resources/worldjoincommands.99230/");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    Discord: https://discord.gg/FUjvJsacUA");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "All rights reserved by Jurian32e");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[]================================[]");
    }
}