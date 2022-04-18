package me.jurian.worldjoincommands.worldjoincommands.SubCommands;

import me.jurian.worldjoincommands.worldjoincommands.CommandHandlers.SubCommand;
import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig1;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help extends SubCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Shows you the help menu";
    }

    @Override
    public String getSyntax() {
        return "/worldjoincommands help";
    }

    @Override
    public void perform(Player player, String[] args) {
        player.sendMessage(ChatColor.BLUE + CustomConfig1.get().getString("helpmenu.line1"));
        player.sendMessage(ChatColor.YELLOW + CustomConfig1.get().getString("helpmenu.line2"));
        player.sendMessage(ChatColor.YELLOW + CustomConfig1.get().getString("helpmenu.line3"));
        player.sendMessage(ChatColor.YELLOW + CustomConfig1.get().getString("helpmenu.line4"));
    }
}

