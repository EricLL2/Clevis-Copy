package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.model.ShapeList;
import hk.edu.polyu.comp.comp2021.clevis.dto.DeleteParams;
import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Shape;

/**
 * Manage delete commands.
 */
public class DeleteCommand implements ICommand {
    final private Shape shape;
    final private int index;
    final private ShapeList shapeList = ShapeList.getInstance();

    /**
     * @param params the params object carrying the parameter of the delete command.
     */
    public DeleteCommand(DeleteParams params) {
        this.shape = this.shapeList.getShape(params.getN());
        if (this.shape == null)
            throw new IllegalArgumentException(Errors.INVALID_SHAPE.getMessage());

        this.index = this.shapeList.getIndex(this.shape);
    }

    @Override
    public void execute() {
        this.shapeList.removeShape(this.shape);
    }

    @Override
    public void reverse() {
        this.shapeList.addShape(this.shape, this.index);
    }
}
