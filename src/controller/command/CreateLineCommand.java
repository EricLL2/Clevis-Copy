package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.dto.LineParams;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Line;

/**
 * Manage create line commands.
 */
public class CreateLineCommand extends CreationCommand implements ICommand{
    /**
     * The default constructor for the CreateLineCommand class.
     *
     * @param params the params object carrying the parameters of the line.
     */
    public CreateLineCommand(LineParams params) {
        super(new Line(params.getN(), params.getX(), params.getY(), params.getX2(), params.getY2()));
    }
}
