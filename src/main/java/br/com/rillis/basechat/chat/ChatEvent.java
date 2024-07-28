package br.com.rillis.basechat.chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        event.setCancelled(true);

        ChatColor color = player.isOp() ? ChatColor.LIGHT_PURPLE : ChatColor.YELLOW;
        String add = player.getGameMode().equals(GameMode.CREATIVE) ? ChatColor.ITALIC.toString() : "";
        Bukkit.broadcastMessage(color + add + player.getName() + ChatColor.WHITE + ": " + message + ChatColor.RESET);

        for(Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
        }
    }

}
