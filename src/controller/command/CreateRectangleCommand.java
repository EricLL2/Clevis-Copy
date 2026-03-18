package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.dto.RectangleParams;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Rectangle;

/**
 * Manage create rectangle commands.
 */
public class CreateRectangleCommand extends CreationCommand implements ICommand {
    /**
     * The default constructor for the CreateRectangleCommand class.
     *
     * @param params the params object carrying the parameters of the rectangle.
     */
    public CreateRectangleCommand(RectangleParams params) {
        super(new Rectangle(params.getN(), params.getX(), params.getY(), params.getW(), params.getH()));
    }
}
