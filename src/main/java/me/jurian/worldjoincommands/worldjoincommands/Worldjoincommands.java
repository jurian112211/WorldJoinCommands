package me.jurian.worldjoincommands.worldjoincommands;
import java.io.File;
import me.jurian.worldjoincommands.worldjoincommands.Events.JoinEvent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Worldjoincommands extends JavaPlugin {
    public FileConfiguration config;

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinEvent(this), (Plugin)this);
        loadConfig();
    }

    public void loadConfig() {
        this.config = getConfig();
        this.config.options().copyDefaults(false);
        if ((new File("plugins/Worldjoincommands/config.yml")).exists()) {
            System.out.println("[WJC] config.yml load.");
        } else {
            saveDefaultConfig();
            System.out.println("[WJC] config.yml created and loaded.");
        }
    }
}
