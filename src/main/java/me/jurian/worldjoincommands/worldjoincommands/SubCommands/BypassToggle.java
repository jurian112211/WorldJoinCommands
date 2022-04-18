package me.jurian.worldjoincommands.worldjoincommands.SubCommands;

import me.jurian.worldjoincommands.worldjoincommands.CommandHandlers.SubCommand;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig1;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig3;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class BypassToggle extends SubCommand {

    @Override
    public String getName() {
        return "bypasstoggle";
    }

    @Override
    public String getDescription() {
        return "Toggles the bypassmode";
    }

    @Override
    public String getSyntax() {
        return "/worldjoincommands bypasstoggle";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (player.hasPermission("worldjoincommands.bypasstoggle")) {
            if (CustomConfig3.get().getBoolean("players." + player.getName())) {
                CustomConfig3.get().set("players." + player.getName(), false);
                CustomConfig3.save();
                player.sendMessage(ChatColor.RED + CustomConfig1.get().getString("messages.bypassmode-disabled"));
        }else if (!CustomConfig3.get().getBoolean("players." + player.getName())) {
                CustomConfig3.get().set("players." + player.getName(), true);
                CustomConfig3.save();
                player.sendMessage(ChatColor.GREEN + CustomConfig1.get().getString("messages.bypassmode-enabled"));
            }
        }
    }
}