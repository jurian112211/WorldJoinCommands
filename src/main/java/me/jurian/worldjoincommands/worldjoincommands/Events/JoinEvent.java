package me.jurian.worldjoincommands.worldjoincommands.Events;

import me.jurian.worldjoincommands.worldjoincommands.Worldjoincommands;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinEvent implements Listener {
    private Worldjoincommands plugin;

    public JoinEvent(Worldjoincommands instance) {
        this.plugin = instance;
    }

    public void Worldjoincommands() {}

    @EventHandler
    public void PlayerJoin(PlayerChangedWorldEvent e) {
        String pname = e.getPlayer().getName();
        String wname = e.getPlayer().getWorld().getName();
        String command = (String)this.plugin.config.get(String.valueOf(wname) + ".Command");
        CharSequence cs = "<player>";
        if (this.plugin.config.contains(wname))
            if (command.contains(cs)) {
                String newcmd = command.replaceAll("<player>", pname);
                Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), newcmd);
            } else {
                Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command);
            }
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        String pname = e.getPlayer().getName();
        String wname = e.getPlayer().getWorld().getName();
        String command = (String)this.plugin.config.get(String.valueOf(wname) + ".Command");
        CharSequence cs = "<player>";
        if (this.plugin.config.contains(wname))
            if (command.contains(cs)) {
                String newcmd = command.replaceAll("<player>", pname);
                Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), newcmd);
            } else {
                Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), command);
            }
    }
}
