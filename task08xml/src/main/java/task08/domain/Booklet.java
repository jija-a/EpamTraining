package task08.domain;

public class Booklet extends Paper {

    /**
     * Constructor without parameters.
     */
    public Booklet() {
    }

    /**
     * Constructor with parameters of {@link Paper} class.
     * <p>
     * Calls super class constructor
     * </p>
     *
     * @param id    - entity id
     * @param title {@link Paper} title
     * @param chars - {@link Paper.Chars} of paper
     */
    public Booklet(final Long id, final String title, final Chars chars) {
        super(id, title, chars);
    }

    /**
     * Method to compare entities if they equals.
     *
     * @see Object
     */
    @Override
    public boolean equals(final Object o) {
        return super.equals(o);
    }

    /**
     * Method to get hashcode.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Method to get {@link String} presentation of entity.
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
