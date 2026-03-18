package hk.edu.polyu.comp.comp2021.clevis.dto.parents;

/// A parent for all classes that require a name parameter to execute the corresponding command.
public abstract class NameParams {
    private final String n;

    /**
     * The default constructor for the class {@code NameParams}.
     *
     * @param n: the name given by the user.
     */
    protected NameParams(String n){
        if(n == null || n.isEmpty())
            throw new IllegalArgumentException("Group name invalid");

        this.n = n;
    }

    /**
     * Get the name provided by the user.
     *
     * @return the proposed name.
     */
    public String getN(){
        return n;
    }
}
