package br.com.rillis.basechat.command;

import org.bukkit.command.CommandExecutor;

public class CommandHolder {
    String cmd;
    CommandExecutor executor;

    public CommandHolder(String cmd, CommandExecutor executor) {
        this.cmd = cmd;
        this.executor = executor;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(CommandExecutor executor) {
        this.executor = executor;
    }
}
