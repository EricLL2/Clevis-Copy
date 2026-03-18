package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.dto.parents.NameAndCoordinateParams;

/** This class is created to hold the parameters of the move command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class MoveParams extends NameAndCoordinateParams {
    /**
     * The default constructor for the class {@code MoveParams}.
     *
     * @param n: the name of the group given by the user.
     * @param dx: the proposed change in the x coordinate of the shape.
     * @param dy: the proposed change in the y coordinate of the shape.
     */
    public MoveParams (String n, double dx, double dy) {
        super(n, dx, dy);
    }
}
