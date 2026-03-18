package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import java.util.Stack;

/// The main command bus for the application.
public class CommandBus {
    final private Stack<ICommand> executed;
    private Stack<ICommand> undoList;

    /**
     * The default constructor for the CommandBus class.
     */
    public CommandBus() {
        this.executed = new Stack<>();
        this.undoList = new Stack<>();
    }

    /**
     * Execute the command and add it to the execution bus.
     *
     * @param command the command to be executed.
     */
    public void execute(ICommand command) {
        command.execute();
        this.executed.push(command);
        if (!undoList.empty()) this.undoList = new Stack<>();
    }

    /**
     * Undo the last executed command.
     */
    public void undo() {
        if (this.executed.empty()) return;

        ICommand command = this.executed.pop();
        command.reverse();
        this.undoList.push(command);
    }

    /**
     * Redo the last undone command.
     */
    public void redo() {
        if (this.undoList.empty()) return;

        ICommand command = this.undoList.pop();
        command.execute();
        this.executed.push(command);
    }
}
