package hk.edu.polyu.comp.comp2021.clevis.enums;

/// An enum containing the messages for all errors.
public enum Errors {
    /// The error displayed if the command is invalid.
    INVALID_COMMAND("Error: Invalid command."),

    /// The error displayed if the command is in the wrong format.
    INVALID_FORMAT("Error: Invalid command format. Check the number and type of arguments."),

    /// The error displayed if the user triggers a shape that doesn't exist.
    INVALID_SHAPE("Error: Invalid shape name. This shape doesn't exist in the application."),

    /// The error displayed if the user enters a negative or zero value for the dimensions of a shape.
    INVALID_LENGTH("Error: Invalid length or dimension. Dimensions must be positive numbers."),

    /// The error displayed if the user adds a shppe with a name that already exiss.
    REGISTERED_NAME("Error: Name is already registered. Choose a different name."),

    /// The error displayed if the user performs a group specific operation on a primitive shape.
    SHAPE_IS_NOT_GROUP("Error: The specified shape is not a group.");

    private final String message;

    /**
     * Private constructor to associate a message with each enum constant.
     */
     Errors(String message) {
        this.message = message;
    }

    /**
     * Get error message.
     *
     * @return error message.
     */
    public String getMessage() {
        return message;
    }
}
