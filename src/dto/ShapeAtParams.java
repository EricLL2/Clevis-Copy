package hk.edu.polyu.comp.comp2021.clevis.dto;

/** This class is created to hold the parameters of the shapeAt command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class ShapeAtParams {
    private final double x, y;

    /**
     * The default constructor for the class {@code ShapeAtParams}.
     *
     * @param x: the proposed x coordinate for the square to sit at.
     * @param y: the proposed y coordinate for the square to sit at.
     */
    public ShapeAtParams(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate provided by the user.
     *
     * @return the proposed x coordinate.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Get the y coordinate provided by the user.
     *
     * @return the proposed y coordinate.
     */
    public double getY() {
        return this.y;
    }
}
