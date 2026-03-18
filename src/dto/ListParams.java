package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.dto.parents.NameParams;

/** This class is created to hold the parameters of the list command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class ListParams extends NameParams {
    /**
     * The default constructor for the class {@code ListParams}.
     *
     * @param n : the name given by the user.
     */
    public ListParams(String n){
        super(n);
    }
}
