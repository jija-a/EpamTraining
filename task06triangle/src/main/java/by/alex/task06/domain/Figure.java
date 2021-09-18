package by.alex.task06.domain;

import java.io.Serializable;
import java.util.Objects;

public abstract class Figure implements Serializable, Cloneable {

    private long id;

    public Figure() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return id == figure.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "id=" + id +
                '}';
    }

}
