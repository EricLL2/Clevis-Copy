package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.dto.parents.NameParams;

/** This class is created to hold the parameters of the boundingbox command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class BoundingBoxParams extends NameParams {
    /**
     * The default constructor for the class {@code BoundingboxParams}.
     *
     * @param n: the name of the shape given by the user.
     */
    public BoundingBoxParams (String n) {
        super(n);
    }
}
