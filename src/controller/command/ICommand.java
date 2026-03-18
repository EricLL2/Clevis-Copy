package hk.edu.polyu.comp.comp2021.clevis.controller.command;

/**
 * The interface for all commands executed in the application
 */
public interface ICommand {
    /**
     * Execute the command.
     */
    void execute();

    /**
     * Reverse the command.
     */
    void reverse();
}
