package me.jurian.worldjoincommands.worldjoincommands.SubCommands;

import me.jurian.worldjoincommands.worldjoincommands.CommandHandlers.SubCommand;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig1;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig3;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class EnableBypass extends SubCommand {

    @Override
    public String getName() {
        return "enablebypass";
    }

    @Override
    public String getDescription() {
        return "Enables the bypassmode.";
    }

    @Override
    public String getSyntax() {
        return "/worldjoincommands enablebypass";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (player.hasPermission("worldjoincommands.bypass")) {
            CustomConfig3.get().set("players." + player.getUniqueId().toString(), "true");
            CustomConfig3.save();
            player.sendMessage(ChatColor.GREEN + CustomConfig1.get().getString("messages.bypassmode-enabled"));
                //CustomConfig3.get().set("data.bypassmode-enabled-for-admins", "true");
                //CustomConfig3.save();

        } else if (player.hasPermission("worldjoincommands.bypass") == false ) {
            player.sendMessage(ChatColor.RED + CustomConfig1.get().getString("messages.no-permission"));


        }
    }
}



