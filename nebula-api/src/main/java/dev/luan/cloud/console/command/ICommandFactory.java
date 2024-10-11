package dev.luan.cloud.console.command;

public interface ICommandFactory {

    /**
     * Register a command.
     *
     * @param command
     */
    void registerCommand(Command command);
}