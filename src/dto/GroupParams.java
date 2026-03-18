package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.dto.parents.NameParams;

/** This class is created to hold the parameters of the group command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class GroupParams extends NameParams {
    private final String[] shapeNames;

    /**
     * The default constructor for the class {@code GroupParams}.
     *
     * @param n: the name of the group given by the user.
     * @param shapeNames: the list of names of the shapes given by the user.
     */
    public GroupParams(String n, String[] shapeNames) {
        super(n);
        this.shapeNames = shapeNames.clone();
    }

    /**
     * Get the list of names of the shapes provided by the user.
     *
     * @return the proposed list names of the shapes to be combined.
     */
    public String[] getShapeNames(){
        return shapeNames.clone();
    }
}
