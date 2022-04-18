package me.jurian.worldjoincommands.worldjoincommands.CommandHandlers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BypassTabCompleter {



    public class MainTabCompleter implements TabCompleter {

        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
            if (args.length == 2){
                List<String> argumentlist = new ArrayList<>();
                argumentlist.add("on");
                argumentlist.add("off");
                return argumentlist;
            }
            return null;
        }
    }

}
