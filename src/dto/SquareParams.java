package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.dto.parents.NameAndCoordinateParams;

/** This class is created to hold the parameters of the square command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class SquareParams extends NameAndCoordinateParams {
    private final double l;

    /**
     * The default constructor for the class {@code SquareParams}.
     *
     * @param n: the name of the group given by the user.
     * @param x: the proposed x coordinate for the square to sit at.
     * @param y: the proposed y coordinate for the square to sit at.
     * @param l: the proposed length of the sides of the square.
     */
    SquareParams(String n, double x, double y, double l) {
        super(n, x, y);
        this.l = l;
    }

    /**
     * Get the length of the sides of the square provided by the user.
     *
     * @return the proposed length of the sizes of the square.
     */
    public double getL () {
            return this.l;
        }
    }

