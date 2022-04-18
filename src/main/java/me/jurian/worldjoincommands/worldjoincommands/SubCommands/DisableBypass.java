package me.jurian.worldjoincommands.worldjoincommands.SubCommands;

import me.jurian.worldjoincommands.worldjoincommands.CommandHandlers.SubCommand;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig1;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig3;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DisableBypass extends SubCommand {

    @Override
    public String getName() {
        return "disablebypass";
    }

    @Override
    public String getDescription() {
        return "Enables the bypassmode.";
    }

    @Override
    public String getSyntax() {
        return "/worldjoincommands disablebypass";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (player.hasPermission("worldjoincommands.bypass")) {
            CustomConfig3.get().set("players." + player.getUniqueId().toString(), "false");
            CustomConfig3.save();
            player.sendMessage(ChatColor.RED + CustomConfig1.get().getString("messages.bypassmode-disabled"));
                //CustomConfig3.get().set("data.bypassmode-enabled-for-admins", "false");
                //CustomConfig3.save();

        } else if (player.hasPermission("worldjoincommands.bypass") == false ) {
            player.sendMessage(ChatColor.RED + CustomConfig1.get().getString("messages.no-permission"));


        }
    }
}



