package hk.edu.polyu.comp.comp2021.clevis.dto.parents;

/// A parent for all classes that require name x, y coordinate to execute the corresponding command.
public abstract class NameAndCoordinateParams extends NameParams {
    private final double x, y;

    /**
     * The default constructor for the class {@code NameAndCoordinateParams}.
     *
     * @param n: the name given by the user.
     * @param x: the proposed x coordinate for the square to sit at.
     * @param y: the proposed y coordinate for the square to sit at.
     */
    protected NameAndCoordinateParams(String n, double x, double y) {
        super(n);
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate provided by the user.
     *
     * @return the proposed x coordinate.
     */
    public double getX () {
        return this.x;
    }

    /**
     * Get the y coordinate provided by the user.
     *
     * @return the proposed y coordinate.
     */
    public double getY () {
        return this.y;
    }
}
