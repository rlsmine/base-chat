package br.com.rillis.basechat;

import br.com.rillis.basechat.chat.ChatEvent;
import br.com.rillis.basechat.command.CommandHolder;
import br.com.rillis.basechat.command.CommandSay;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BaseChat extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        System.out.println("[BaseChat] Starting");
        plugin = this;

        registerCommands(new CommandHolder("say", new CommandSay()));
        registerEvents(new ChatEvent());
    }

    @Override
    public void onDisable() {
        System.out.println("[BaseChat] Shutdown");
    }

    private void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    private void registerCommands(CommandHolder... commands) {
        for (CommandHolder command : commands) {
            getCommand(command.getCmd()).setExecutor(command.getExecutor());
        }
    }
}
