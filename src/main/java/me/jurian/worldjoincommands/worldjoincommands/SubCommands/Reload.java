package me.jurian.worldjoincommands.worldjoincommands.SubCommands;

import me.jurian.worldjoincommands.worldjoincommands.CommandHandlers.SubCommand;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig1;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig2;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig3;
import me.jurian.worldjoincommands.worldjoincommands.Worldjoincommands;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import java.io.IOException;

public class Reload extends SubCommand {

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reloads the WorldJoinCommands plugin.";
    }

    @Override
    public String getSyntax() {
        return "/worldjoincommands reload";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (player.hasPermission("worldjoincommands.reload")) {
                CustomConfig1.save();
                CustomConfig2.save();
                CustomConfig3.save();
            player.sendMessage(ChatColor.GREEN + CustomConfig1.get().getString("messages.reload-message"));
        } else if (player.hasPermission("worldjoincommands.reload") == false ) {
            player.sendMessage(ChatColor.RED + CustomConfig1.get().getString("messages.no-permission"));

        }
    }
}



