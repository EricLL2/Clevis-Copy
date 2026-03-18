package hk.edu.polyu.comp.comp2021.clevis.model.shape;

import hk.edu.polyu.comp.comp2021.clevis.view.View;

import java.awt.*;

/// the superclass for all valid shapes used in the clevis application
public abstract class Shape {
    final private String name;
    /// The x, y coordinate the shape is sitting at.
    final protected Coordinate coordinate;

    /**
     * Default constructor for {@code Shape} instances
     * @param name: The name of the {@code Shape}
     * @param start_x: The initial x coordinate of the {@code Shape}
     * @param start_y: The initial y coordinate of the {@code Shape}
     */
    public Shape(String name, double start_x, double start_y) {
        this.name = name;
        this.coordinate = new Coordinate(start_x, start_y);
    }

    /**
     * Move the {@code Shape} to a new position.
     *
     * @param newCoordinate: the new coordinates the {@code Shape} will move to.
     */
    public void setPosition(Coordinate newCoordinate) {
        this.coordinate.setX(this.getX() + newCoordinate.getX());
        this.coordinate.setY(this.getY() + newCoordinate.getY());
    }

    /**
     * Get the name of the Shape.
     * @return {@code name}
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the x coordinate of the Shape.
     *
     * @return {@code x}
     */
    public double getX() {
        return this.coordinate.getX();
    }

    /**
     * Get the y coordinate of the Shape.
     *
     * @return {@code y}
     */
    public double getY() {
        return this.coordinate.getY();
    }

    /**
     * Get the boundingbox of the Shape.
     *
     * @return {@code Boundingbox}
     */
    public abstract Boundingbox getBoundingbox();

    /**
     * Verify if the given point falls within the boundaries of the shape.
     *
     * @param point: the coordinates of the point being checked.
     *
     * @return {@code true} if the point is in the shape and {@code false} if the point doesn't fall within shape.
     */
    public boolean hasPoint(Coordinate point) {
        return this.calculateMinDistanceTo(point) < COVERED_DISTANCE;
    }

    /**
     * Displays the basic information of the {@code Shape}.
     *
     * @param view the main view of the application.
     */
    public abstract void printInfo(View view);

    /**
     * Displays the basic information of the {@code Shape}.
     *
     * @param view the main view of the application.
     * @param level: the level indentation in printing.
     */
    public void printInfo(View view, int level) {
        view.displayPartialLine("  ".repeat(level));
        this.printInfo(view);
    }

    /**
     * Validates if the name is registered within this {@code Shape}
     *
     * @param name: the proposed name to check.
     *
     * @return true if the name is registered, false if the name isn't registered.
     */
    public boolean hasName(String name) {
        return this.getName().equals(name);
    }

    /**
     * Calculates the minimum distance between a point and the outline of the {@code Shape}.
     *
     * @param point: the point to be compared to the outline.
     *
     * @return the minimum distance between the given point and the outline of the {@code Shape}.
     */
    protected abstract double calculateMinDistanceTo(Coordinate point);

    /// The maximum distance covered by the outline of the {@code Shape}.
    protected static final double COVERED_DISTANCE = 0.05;

    /**
     * Draws the shape on the given Graphics2D context.
     * Used by the GUI to render shapes visually.
     *
     * @param g the Graphics2D context to draw on
     */
    public void draw(Graphics2D g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.drawShape(g2d);
        g2d.dispose();
    }

    /**
     * Draws the sahep itself.
     *
     * @param g the Graphics2D context to draw on.
     */
    protected abstract void drawShape(Graphics2D g);
}
