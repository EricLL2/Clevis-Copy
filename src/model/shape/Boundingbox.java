package hk.edu.polyu.comp.comp2021.clevis.model.shape;

/// the boundingbox for any shape/ group in the application
public class Boundingbox {
    private final Coordinate coordinate;
    private final double width;
    private final double height;

    /**
     * Default constructor for {@code Boundingbox} instances
     * @param x: The {@code x} coordinate of the {@code Boundingbox}
     * @param y: The {@code y} coordinate of the {@code Boundingbox}
     * @param width: The horizontal width of the boundingbox
     * @param height: The vertical width of the boundingbox
     */
    public Boundingbox(double x, double y, double width, double height) {
        this.coordinate = new Coordinate(x, y);
        this.width = width;
        this.height = height;
    }

    /**
     * Checks whether this {@code Boundingbox} intersects with another {@code Boundingbox}.
     *
     * @param other: the other boundingbox to be compared with.
     *
     * @return true if they intersect, false if not.
     */
    public boolean intersects(Boundingbox other) {
        return this.getBottomLeftCorner().getX() < other.getTopRightCorner().getX() &&
                this.getTopRightCorner().getX() > other.getBottomLeftCorner().getX() &&
                this.getTopRightCorner().getY() > other.getBottomLeftCorner().getY() &&
                this.getBottomLeftCorner().getY() < other.getTopRightCorner().getY();
    }

    /**
     * Get the point of the bottom left corner of the boundingbox.
     *
     * @return the coordinate of the bottom left corner.
     */
    protected Coordinate getBottomLeftCorner() {
        return new Coordinate(this.getCoordinate().getX(), this.getCoordinate().getY());
    }

    /**
     * Get the point of the top right corner of the boundingbox.
     *
     * @return the coordinate of the top right corner.
     */
    protected Coordinate getTopRightCorner() {
        return new Coordinate(this.getCoordinate().getX() + this.getWidth(),
                this.getCoordinate().getY() + this.getHeight());
    }

    /**
     * Get the value of coordinates of boundingbox
     * @return {@code Coordinate}
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Get the value of the horizontal width of the boundingbox
     * @return {@code width}
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Get the value of the vertical height of the boundingbox
     * @return {@code height}
     */
    public double getHeight() {
        return this.height;
    }
}
