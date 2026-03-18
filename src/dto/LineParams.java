package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.dto.parents.NameAndCoordinateParams;

/** This class is created to hold the parameters of the line command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class LineParams extends NameAndCoordinateParams {
    private final double x2, y2;

    /**
     * The default constructor for the class {@code RectangleParams}.
     *
     * @param n: the name of the group given by the user.
     * @param x1: the proposed x coordinate for the line to start at.
     * @param y1: the proposed y coordinate for the line to start at.
     * @param x2: the proposed x coordinate for the line to end at.
     * @param y2: the proposed y coordinate for the line to start at.
     */
    public LineParams (String n, double x1, double y1, double x2, double y2) {
        super(n, x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Get the destination x coordinate of the line provided by the user.
     *
     * @return the proposed destination x coordinate of the line.
     */
    public double getX2() {
        return this.x2;
    }

    /**
     * Get the destination y coordinate of the line provided by the user.
     *
     * @return the proposed destination y coordinate of the line.
     */
    public double getY2() {
        return this.y2;
    }
}
