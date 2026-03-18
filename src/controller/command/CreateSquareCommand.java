package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.dto.SquareParams;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Square;

/**
 * Manage create square commands.
 */
public class CreateSquareCommand extends CreationCommand implements ICommand {
    /**
     * The default constructor for the CreateSquareCommand class.
     *
     * @param params the params object carrying the parameters of the square.
     */
    public CreateSquareCommand(SquareParams params) {
        super(new Square(params.getN(), params.getX(), params.getY(), params.getL()));
    }
}
