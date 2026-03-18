package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.model.ShapeList;
import hk.edu.polyu.comp.comp2021.clevis.dto.UngroupParams;
import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.*;

/**
 * Manage ungroup commands.
 */
public class UngroupCommand implements ICommand {
    final private Group group;
    final private ShapeList shapeList = ShapeList.getInstance();

    /**
     * @param params the object carrying the parameters for the Ungroup class
     */
    public UngroupCommand (UngroupParams params) {
        Shape shape = this.shapeList.getShape(params.getN());

        if (shape == null)
            throw new IllegalArgumentException(Errors.INVALID_SHAPE.getMessage());
        if (!(shape instanceof Group))
            throw new IllegalArgumentException(Errors.SHAPE_IS_NOT_GROUP.getMessage());

        this.group = (Group) shape;
    }

    @Override
    public void execute() {
        shapeList.insertAll(this.group.getChildren());
        shapeList.removeShape(this.group);
    }

    @Override
    public void reverse() {
        shapeList.removeAll(this.group.getChildren());
        shapeList.addShape(this.group);
    }
}
