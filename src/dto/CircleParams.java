package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.dto.parents.NameAndCoordinateParams;

/** This class is created to hold the parameters of the circle command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class CircleParams extends NameAndCoordinateParams {
    private final double r;

    /**
     * The default constructor for the class {@code CircleParams}.
     *
     * @param n: the name of the circle given by the user.
     * @param x: the x coordinate of the center of the circle.
     * @param y: the y coordinate of the center of the circle.
     * @param r: the radius of the circle.
     */
    public CircleParams (String n, double x, double y , double r) {
        super(n, x, y);
        this.r = r;
    }

    /**
     * Get the radius of the circle inputted by the user.
     *
     * @return the proposed radius by the user.
     */
    public double getR() {
        return this.r;
    }
}
