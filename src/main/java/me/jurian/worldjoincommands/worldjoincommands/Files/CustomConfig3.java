package me.jurian.worldjoincommands.worldjoincommands.Files;

import me.jurian.worldjoincommands.worldjoincommands.Worldjoincommands;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig3 {

    private static File file;
    private static FileConfiguration customFile3;

    //Finds or generates the custom config file.
    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Worldjoincommands").getDataFolder(), "data.yml");

        if (!file.exists()) {
            file.getParentFile().mkdirs();
            Worldjoincommands.instance.saveResource("data.yml", false);
        }
        customFile3 = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration get(){
        return customFile3;
    }

    public static void save(){
        try {
            customFile3.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not save the configuration file");
        }
    }

    public static void reload(){
        customFile3 = YamlConfiguration.loadConfiguration(file);
    }

}
