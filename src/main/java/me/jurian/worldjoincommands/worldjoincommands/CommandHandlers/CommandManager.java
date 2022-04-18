package me.jurian.worldjoincommands.worldjoincommands.CommandHandlers;

import me.jurian.worldjoincommands.worldjoincommands.Files.CustomConfig1;
import me.jurian.worldjoincommands.worldjoincommands.SubCommands.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> subcommands = new ArrayList<>();

    public ArrayList<SubCommand> getSubcommands() {
        return subcommands;
    }

    public CommandManager() {
        subcommands.add(new Reload());
        subcommands.add(new EnableBypass());
        subcommands.add(new DisableBypass());
        subcommands.add(new Help());
        subcommands.add(new BypassToggle());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length > 0) {
                for (int i = 0; i < getSubcommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getSubcommands().get(i).getName())) {
                        getSubcommands().get(i).perform(p, args);

                    }

                }
            } else if (args.length == 0) {
                p.sendMessage(ChatColor.RED + CustomConfig1.get().getString("messages.specify-arguments"));
                p.sendMessage(ChatColor.YELLOW + CustomConfig1.get().getString("messages.type-help"));

            }
        }
        return true;
    }
}