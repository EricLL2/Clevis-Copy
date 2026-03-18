package hk.edu.polyu.comp.comp2021.clevis.controller.command;

import hk.edu.polyu.comp.comp2021.clevis.model.ShapeList;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Shape;

/// The abstract behaviour for creation commands.
public abstract class CreationCommand implements ICommand {
    /// The shape the command specializes in crating.
    final protected Shape shape;

    /// The list of shapes in the application.
    final protected ShapeList shapeList = ShapeList.getInstance();

    /**
     * @param shape the shape the command is responsible for creating.
     */
    public CreationCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        this.shapeList.addShape(this.shape);
    }

    @Override
    public void reverse() {
        this.shapeList.removeShape(this.shape);
    }
}
