package hk.edu.polyu.comp.comp2021.clevis.controller;

import hk.edu.polyu.comp.comp2021.clevis.controller.command.*;
import hk.edu.polyu.comp.comp2021.clevis.dto.*;
import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;
import hk.edu.polyu.comp.comp2021.clevis.model.ShapeList;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.*;
import hk.edu.polyu.comp.comp2021.clevis.view.View;

/**
 * Controller of the shapes in the clevis application.
 */
public class ShapeController {
    final private ShapeList shapeList = ShapeList.getInstance();
    final private View view;
    final private CommandLogger commandLogger;
    final private CommandBus commandBus;


    /**
     * Constructor of the Shape controller.
     *
     * @param commandLogger: The class responsible for logging executed commands.
     * @param view The main view of the application.
     */
    public ShapeController(CommandLogger commandLogger, View view) {
        this.commandLogger = commandLogger;
        this.view = view;
        this.commandBus = new CommandBus();
    }

    /**
     * Create a new rectangle in the clevis application.
     *
     * @param params the object carrying the parameters of the new rectangle.
     * @param command the command executed.
     */
    public void createRectangle(RectangleParams params, String command){
        try{
            this.commandBus.execute(new CreateRectangleCommand(params));
            this.logCommand(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    /**
     * Create a new line in the clevis application.
     *
     * @param params the object carrying the parameters of the new line.
     * @param command the command executed.
     */
    public void createLine (LineParams params, String command){
        try{
            this.commandBus.execute(new CreateLineCommand(params));
            this.logCommand(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    /**
     * Create a new circle in the clevis application.
     *
     * @param params the object carrying the parameters of the new circle.
     * @param command the command executed.
     */
    public void createCircle(CircleParams params, String command) {
        try{
            this.commandBus.execute(new CreateCircleCommand(params));
            this.logCommand(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    /**
     * Create a new circle in the clevis application.
     *
     * @param params the object carrying the parameters of the new square.
     * @param command the command executed.
     */
    public void createSquare(SquareParams params, String command){
        try{
            this.commandBus.execute(new CreateSquareCommand(params));
            this.logCommand(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    /**
     * Create a group of shapes in the clevis application.
     *
     * @param params the object carrying the parameters of the new group.
     * @param command the command executed.
     */
    public void createGroup(GroupParams params, String command){
        try {
            this.commandBus.execute(new CreateGroupCommand(params));
            this.logCommand(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    /**
     * Ungroup the collection of shapes and separate them.
     *
     * @param params: the object carrying the name of the shape to be ungrouped.
     * @param command the command executed.
     */
    public void ungroup(UngroupParams params, String command){
        try {
            this.commandBus.execute(new UngroupCommand(params));
            this.logCommand(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    /**
     * Delete the shape from the application.
     *
     * @param params: the object carrying the name of the shape to be deleted.
     * @param command the command executed.
     */
    public void delete(DeleteParams params, String command) {
        try {
            this.commandBus.execute(new DeleteCommand(params));
            this.logCommand(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    /**
     * Display the boundingbox of the shape.
     *
     * @param params: the object carrying the params of boundingbox command.
     * @param command the command executed.
     */
    public void displayBoundingBox(BoundingBoxParams params, String command) {
        Shape shape = this.shapeList.getShape(params.getN());
        if (shape == null) {
            this.view.displayMessage(Errors.INVALID_SHAPE.getMessage());
            return;
        }
        Boundingbox boundingbox = shape.getBoundingbox();
        this.view.displayBoundingbox(boundingbox);
        this.logCommand(command);
    }

    /**
     * Move the shape to a new position.
     *
     * @param params the object carrying the parameters of the move command.
     * @param command the command executed.
     */
    public void move(MoveParams params, String command) {
        try {
            this.commandBus.execute(new MoveCommand(params));
            this.logCommand(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    /**
     * Displays the topmost shape that this point falls onto.
     *
     * @param params the object carrying the coordinate of the point being checked.
     * @param command the command executed.
     */
    public void displayShapeAt(ShapeAtParams params, String command) {
        Shape shape = this.findShapeAt(new Coordinate(params.getX(), params.getY()));
        if (shape == null) {
            this.view.displayMessage("No shape is drawn on this point.");
            return;
        }

        this.view.displayName(shape);
        this.logCommand(command);
    }

    /**
     * Verifies whether two shapes intersect or not and displays the result.
     *
     * @param params: the object carrying the names of the two shapes.
     * @param command the command executed.
     */
    public void checkIntersection(IntersectParams params, String command) {
        Shape firstShape = this.shapeList.getShape(params.getN1()),
                secondShape = this.shapeList.getShape(params.getN2());

        if (firstShape == null || secondShape == null) {
            this.view.displayMessage(Errors.INVALID_SHAPE.getMessage());
            return;
        }

        Boundingbox firstBoundingbox = firstShape.getBoundingbox(),
                secondBoundingbox = secondShape.getBoundingbox();

        if (firstBoundingbox.intersects(secondBoundingbox)) this.view.displayTrue();
        else this.view.displayFalse();
        this.logCommand(command);
    }

    /**
     * Displays the basic information of a specified {@code Shape}.
     *
     * @param params: the object carrying the name of the {@code Shape} to be displayed.
     * @param command the command executed.
     */
    public void listOne(ListParams params, String command) {
        Shape shape = this.shapeList.getShape(params.getN());
        if (shape == null) {
            this.view.displayMessage(Errors.INVALID_SHAPE.getMessage());
            return;
        }

        shape.printInfo(this.view);
        this.logCommand(command);
    }

    /**
     * Displays the basic information of all {@code Shape} objects created in the application.
     *
     * @param command the command executed.
     */
    public void listAll(String command) {
        Shape[] shapes = this.shapeList.getShapes();
        for (int i = shapes.length - 1; i >= 0; i--)
            shapes[i].printInfo(this.view, 0);
        if (command != null) this.logCommand(command);
    }

    /**
     * Undo the last executed command
     */
    public void undo() {
        this.commandBus.undo();
        this.logCommand("undo");
    }

    /**
     * Undo the last executed command
     */
    public void redo() {
        this.commandBus.redo();
        this.logCommand("redo");
    }

    /**
     * Terminate the application.
     */
    public void quit() {
        this.closeLog();
        System.exit(0);
    }

    // ================================================= private methods
    private void logCommand(String command) {
        if (this.commandLogger == null) return;

        this.commandLogger.logCommand(command);
    }

    private void closeLog() {
        if (this.commandLogger == null) return;

        this.logCommand("quit");
        this.commandLogger.closeLog();
    }

    private Shape findShapeAt(Coordinate coordinate) {
        Shape[] shapes = this.shapeList.getShapes();
        for (int i = shapes.length - 1; i >= 0; i--) {
            if (shapes[i].hasPoint(coordinate)) {
                return shapes[i];
            }
        }

        return null;
    }
}
