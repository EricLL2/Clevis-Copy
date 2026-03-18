package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.model.ShapeList;
import hk.edu.polyu.comp.comp2021.clevis.dto.GroupParams;
import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.*;

/**
 * Manage create group commands.
 */
public class CreateGroupCommand extends CreationCommand implements ICommand {
    final private int[] indices;
    final private Shape[] children;

    /**
     * The default constructor for the CreateRectangleCommand class.
     *
     * @param params the params object carrying the parameters of the rectangle.
     */
    public CreateGroupCommand(GroupParams params) {
        super(new Group(params.getN(), ShapeList.getInstance().getShapes(params.getShapeNames())));
        Group shape = (Group) this.shape;
        this.children = shape.getChildren();
        if (this.children.length != params.getShapeNames().length)
            throw new IllegalArgumentException(Errors.INVALID_SHAPE.getMessage());

        this.indices = this.storeIndices();
    }

    @Override
    public void execute() {
        super.execute();
        this.shapeList.removeAll(this.children);
    }

    @Override
    public void reverse() {
        super.reverse();
        for (int i = 0; i<this.children.length; i++)
            this.shapeList.addShape(this.children[i], indices[i]);
    }

    private int[] storeIndices() {
        int[] indices = new int[this.children.length];
        for (int i = 0; i < this.children.length; i++)
            indices[i] = this.shapeList.getIndex(this.children[i]);

        return indices;
    }
}
