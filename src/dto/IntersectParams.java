package hk.edu.polyu.comp.comp2021.clevis.dto;

/** This class is created to hold the parameters of the intersect command.
 * If any changes are later decided on the format of the command, updates to this class would be
 * enough to enhance maintainability.
 */
public class IntersectParams {
    private final String n1, n2;

    /**
     * The default constructor for the class {@code IntersectParams}.
     *
     * @param n1: the name of the first shape given by the user.
     * @param n2: the name of the second shape given by the user.
     */
    public IntersectParams(String n1, String n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    /**
     * Get the name of the first shape provided by the user.
     *
     * @return the proposed name of the first shape.
     */
    public String getN1() {
        return this.n1;
    }

    /**
     * Get the name of the second shape provided by the user.
     *
     * @return the proposed name of the second shape.
     */
    public String getN2() {
        return this.n2;
    }
}
