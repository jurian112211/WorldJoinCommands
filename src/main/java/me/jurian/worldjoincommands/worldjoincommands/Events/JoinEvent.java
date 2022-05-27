package me.jurian.worldjoincommands.worldjoincommands.Events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig1;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig2;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig3;
import me.jurian.worldjoincommands.worldjoincommands.Worldjoincommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class JoinEvent implements Listener {
    private final Worldjoincommands plugin;

    @EventHandler
    public void PlayerJoin(@NotNull PlayerChangedWorldEvent e) {
        String wname = e.getPlayer().getWorld().getName();
        Player player = e.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                if (player.hasPermission(Objects.requireNonNull(CustomConfig2.get().getString(wname + ".permission")))) {
                    if (CustomConfig3.get().contains("players." + player.getUniqueId()) == true){
                        player.sendMessage(ChatColor.RED + Objects.requireNonNull(CustomConfig1.get().getString("messages.bypassed-message")));
                    }else{
                        for (String commands : CustomConfig2.get().getStringList(wname + ".Commands")) {
                            commands = PlaceholderAPI.setPlaceholders(e.getPlayer(), Objects.requireNonNull(commands));
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Objects.requireNonNull(commands));
                        }
                    }
                }
            }
        }.runTaskLater(plugin, Long.parseLong((Objects.requireNonNull(CustomConfig2.get().getString(wname + ".delay")))));

    }

    @EventHandler
    public void PlayerJoin(@NotNull PlayerJoinEvent e) {
        String wname = e.getPlayer().getWorld().getName();
        Player player = e.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                if (player.hasPermission(Objects.requireNonNull(CustomConfig2.get().getString(wname + ".permission")))) {
                    if (CustomConfig3.get().contains("players." + player.getName()) == true){
                        player.sendMessage(ChatColor.RED + Objects.requireNonNull(CustomConfig1.get().getString("messages.bypassed-message")));
                    }else{
                        for (String commands : CustomConfig2.get().getStringList(wname + ".Commands")) {
                            commands = PlaceholderAPI.setPlaceholders(e.getPlayer(), Objects.requireNonNull(commands));
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), Objects.requireNonNull(commands));
                        }
                    }
                }
            }
        }.runTaskLater(plugin, Long.parseLong((Objects.requireNonNull(CustomConfig2.get().getString(wname + ".delay")))));

    }
}
