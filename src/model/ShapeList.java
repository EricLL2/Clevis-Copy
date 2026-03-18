package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;
import hk.edu.polyu.comp.comp2021.clevis.model.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * The main list of shapes in the application.
 */
public final class ShapeList {
    final private static List<Shape> shapes = new ArrayList<>();
    private static ShapeList shapeList;

    private ShapeList() {}

    /**
     * Get the list of shapes.
     *
     * @return the single list of shapes in the application.
     */
    public static ShapeList getInstance() {
        if (shapeList == null) shapeList = new ShapeList();

        return shapeList;
    }

    /**
     * Add a new shape to the list.
     *
     * @param shape the shape to be added to the list.
     */
    public void addShape (Shape shape) {
        this.addShape(shape, shapes.size());
    }

    /**
     * Add a new shape to the list.
     *
     * @param shape the shape to be added to the list.
     * @param index the index to place the shape at.
     */
    public void addShape (Shape shape, int index) {
        if (this.invalidName(shape.getName()))
            throw new IllegalArgumentException(Errors.REGISTERED_NAME.getMessage());

        shapes.add(index, shape);
    }

    private boolean invalidName(String name) {
        for (Shape shape: shapes)
            if (shape.hasName(name)) return true;

        return false;
    }

    /**
     * To insert the shapes of the application into the list.
     *
     * @param shapes the shapes to be inserted
     */
    public void insertAll(Shape[] shapes) {
        ShapeList.shapes.addAll(List.of(shapes));
    }

    /**
     * Remove a shape from the list.
     *
     * @param shape the shape to be removed from the list.
     *
     */
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    /**
     * Remove a shape from the list.
     *
     * @param shapes the name of the shape to be removed from the list.
     *
     */
    public void removeAll(Shape[] shapes) {
        ShapeList.shapes.removeAll(List.of(shapes));
    }

    /**
     * Get a shape from the list.
     *
     * @param name the name of the shape to be looked for.
     *
     * @return the shape required.
     */
    public Shape getShape(String name) {
        Shape shape = null;

        for (Shape s: shapes)
            if (name.equals(s.getName())) {
                shape = s;
                break;
            }

        return shape;
    }

    /**
     * Get the index of a shape in the list.
     *
     * @param shape the shape to inquire for its index.
     *
     * @return the index of the shape in the list.
     */
    public int getIndex(Shape shape) {
        return shapes.indexOf(shape);
    }

    /**
     * Get all shapes from the application.
     *
     * @return an array of all shapes in the application.
     */
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[0]);
    }

    /**
     * Get a list of shapes by their names.
     *
     * @param shapeNames the array of the names of the shapes inquired.
     *
     * @return the array of shapes required.
     */
    public Shape[] getShapes(String[] shapeNames) {
        List<Shape> shapes = new ArrayList<>();

        for (String name: shapeNames) {
            Shape shape = this.getShape(name);
            if (shape != null)
                shapes.add(shape);
        }

        return shapes.toArray(new Shape[0]);
    }

    /**
     * Restart the list of the application.
     */
    public void clear() {
        shapes.clear();
    }
}
