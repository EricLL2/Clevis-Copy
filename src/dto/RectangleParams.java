package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.dto.parents.NameAndCoordinateParams;

/** This class is created to hold the parameters of the rectangle command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class RectangleParams extends NameAndCoordinateParams {
    private final double w, h;

    /**
     * The default constructor for the class {@code RectangleParams}.
     *
     * @param n: the name of the group given by the user.
     * @param x: the proposed x coordinate for the rectangle to sit at.
     * @param y: the proposed y coordinate for the rectangle to sit at.
     * @param w: the proposed width of the rectangle.
     * @param h: the proposed height of the rectangle.
     */
    RectangleParams (String n, double x, double y, double w, double h) {
        super(n, x, y);
        this.w = w;
        this.h = h;
    }

    /**
     * Get the width of the rectangle provided by the user.
     *
     * @return the proposed width of the rectangle.
     */
    public double getW() {
        return this.w;
    }

    /**
     * Get the height of the rectangle provided by the user.
     *
     * @return the proposed height of the rectangle.
     */
    public double getH() {
        return this.h;
    }
}
