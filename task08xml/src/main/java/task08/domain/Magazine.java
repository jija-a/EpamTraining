package task08.domain;

import java.util.Objects;

public class Magazine extends Paper {

    /**
     * Paper index.
     */
    private String index;

    /**
     * Public constructor.
     */
    public Magazine() {
    }

    /**
     * Public constructor which calls super.
     *
     * @param id         - entity id
     * @param title      - paper title
     * @param chars      - paper characteristics
     * @param indexValue - paper index
     */
    public Magazine(final Long id,
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
     * @param indexValue - {@link String} index
     */
    public void setIndex(final String indexValue) {
        this.index = indexValue;
    }

    /**
     * Method to compare if entities are equal.
     *
     * @see Object
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
        Magazine magazine = (Magazine) o;
        return index.equals(magazine.index);
    }

    /**
     * Method to get entity hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), index);
    }

    /**
     * Method to get entity representation as {@link String}.
     */
    @Override
    public String toString() {
        return super.toString()
                + "{index='" + index + '\''
                + '}';
    }
}
