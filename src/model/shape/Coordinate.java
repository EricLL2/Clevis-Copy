package hk.edu.polyu.comp.comp2021.clevis.model.shape;

/// A combination of x and y coordinates to represent a point on the plan.
public class Coordinate {
    private double x;
    private double y;

    /**
     * Default constructor for {@code Coordinate} instances
     * @param x: The x coordinate of the {@code Coordinate}
     * @param y: The y coordinate of the {@code Coordinate}
     */
    public Coordinate(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * Get the value of x coordinate
     * @return {@code x}
     */
    public double getX() { return x; }

    /**
     * Re-assign the x coordinate to a new value
     * @param x: the new x coordinate
     */
    public void setX(double x) { this.x = x; }

    /**
     * Get the value of y coordinate
     * @return {@code y}
     */
    public double getY() { return y; }

    /**
     * Re-assign the y coordinate to a new value
     * @param y: the new y coordinate
     */
    public void setY(double y) { this.y = y; }
}
