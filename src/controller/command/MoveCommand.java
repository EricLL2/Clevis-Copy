package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.model.ShapeList;
import hk.edu.polyu.comp.comp2021.clevis.dto.MoveParams;
import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.*;

/**
 * Manage move commands.
 */
public class MoveCommand implements ICommand{
    final private Shape shape;
    final private double dx, dy;

    /**
     * @param params the params object carrying the parameter of the move command.
     */
    public MoveCommand(MoveParams params) {
        ShapeList shapeList = ShapeList.getInstance();
        this.shape = shapeList.getShape(params.getN());
        if (shape == null)
            throw new IllegalArgumentException(Errors.INVALID_SHAPE.getMessage());

        this.dx = params.getX();
        this.dy = params.getY();
    }
    @Override
    public void execute() {
        this.shape.setPosition(new Coordinate(this.dx, this.dy));
    }

    @Override
    public void reverse() {
        this.shape.setPosition(new Coordinate(this.dx*-1, this.dy*-1));
    }
}
