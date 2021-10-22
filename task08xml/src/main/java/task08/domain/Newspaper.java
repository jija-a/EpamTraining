package task08.domain;

import java.util.Objects;

public class Newspaper extends Paper {

    /**
     * Paper index.
     */
    private String index;

    /**
     * Default constructor.
     */
    public Newspaper() {
    }

    /**
     * Constructor which calls super.
     *
     * @param id         - entity id
     * @param title      - entity title
     * @param chars      entity characteristic
     *                   {@link Paper.Chars}
     * @param indexValue - entity index
     */
    public Newspaper(final Long id,
                     final String title,
                     final Chars chars,
                     final String indexValue) {

        super(id, title, chars);
        this.index = indexValue;
    }

    /**
     * Index getter.
     *
     * @return {@link String} index
     */
    public String getIndex() {
        return index;
    }

    /**
     * Index setter.
     *
     * @param indexValue - entity index
     */
    public void setIndex(final String indexValue) {
        this.index = indexValue;
    }

    /**
     * Method to check if entities are equal.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Newspaper newspaper = (Newspaper) o;
        return index.equals(newspaper.index);
    }

    /**
     * Method to get entity hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), index);
    }

    /**
     * Method to get {@link String} representation of entity.
     */
    @Override
    public String toString() {
        return super.toString() + '\n'
                + "index='" + index + '\''
                + '}';
    }
}
