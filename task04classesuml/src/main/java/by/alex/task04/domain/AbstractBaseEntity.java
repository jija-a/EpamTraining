package by.alex.task04.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractBaseEntity implements Serializable, Cloneable {

    private final long id;
    private static Long idCounter = 0L;

    public AbstractBaseEntity() {
        this.id = ++idCounter;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AbstractBaseEntity{" +
                "id=" + id +
                '}';
    }

}
