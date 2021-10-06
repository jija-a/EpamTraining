package by.alex.task08.domain;

import java.util.Objects;

public class Magazine extends Paper {

    private String index;

    public Magazine() {
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(final String indexValue) {
        this.index = indexValue;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return index.equals(magazine.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), index);
    }

    @Override
    public String toString() {
        return super.toString() +
                "{index='" + index + '\'' +
                '}';
    }
}
