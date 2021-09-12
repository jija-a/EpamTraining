package domain;

import java.io.Serializable;

public abstract class AbstractBaseEntity implements Serializable, Cloneable {

    private static long idCounter = 0L;

    private final long id;

    public AbstractBaseEntity() {
        this.id = ++idCounter;
    }

    public Long getId() {
        return id;
    }

}
