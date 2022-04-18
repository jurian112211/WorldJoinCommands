package me.jurian.worldjoincommands.worldjoincommands.Files;

import me.jurian.worldjoincommands.worldjoincommands.Worldjoincommands;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig2 {

    private static File file;
    private static FileConfiguration customFile2;

    //Finds or generates the custom config file.
    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Worldjoincommands").getDataFolder(), "worlds.yml");

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            Worldjoincommands.instance.saveResource("worlds.yml", false);
        }
        customFile2 = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration get(){
        return customFile2;
    }

    public static void save(){
        try {
            customFile2.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not save the configuration file");
        }
    }

    public static void reload(){
        customFile2 = YamlConfiguration.loadConfiguration(file);
    }

}
