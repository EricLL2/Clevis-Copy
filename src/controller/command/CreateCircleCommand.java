package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.dto.CircleParams;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Circle;

/**
 * Manage create circle commands.
 */
public class CreateCircleCommand extends CreationCommand implements ICommand {
    /**
     * The default constructor for the CreateCircleCommand class.
     *
     * @param params the params object carrying the parameters of the circle.
     */
    public CreateCircleCommand(CircleParams params) {
        super(new Circle(params.getN(), params.getX(), params.getY(), params.getR()));
    }
}
