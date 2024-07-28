package br.com.rillis.basechat.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandSay implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player && sender.isOp()) || sender instanceof ConsoleCommandSender || sender.hasPermission("basechat.say")){
            for (Player p : sender.getServer().getOnlinePlayers()) {
                p.sendMessage(ChatColor.LIGHT_PURPLE + ""+ ChatColor.BOLD + "[CONSOLE] "+ChatColor.LIGHT_PURPLE+ String.join(" ", args)+ ChatColor.RESET);
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 1, 1);
            }
        }else {
            sender.sendMessage(ChatColor.DARK_RED+"You don't have permission to use /say."+ChatColor.RESET);
        }
        return true;
    }
}
