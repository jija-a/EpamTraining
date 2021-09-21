package by.alex.task06.domain;

import java.io.Serializable;

public abstract class Figure implements Serializable, Cloneable {

    /**
     * Helper number to create hash code.
     */
    protected static final Integer HASH_PRIME = 31;

    /**
     * Figure id.
     */
    private Long id;

    /**
     * Class constructor.
     */
    protected Figure() {
    }

    /**
     * id field setter.
     *
     * @param idValue - value of id
     */
    public void setId(final long idValue) {
        this.id = idValue;
    }

    /**
     * id field getter.
     *
     * @return {@link Long} id
     */
    public Long getId() {
        return id;
    }
}
