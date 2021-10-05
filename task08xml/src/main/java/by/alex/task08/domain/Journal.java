package by.alex.task08.domain;

import java.util.Objects;

public class Journal extends Paper {

    private String index;

    public Journal(Long id) {
        super(id);
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Journal journal = (Journal) o;
        return index.equals(journal.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), index);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "index='" + index + '\''
                + '}';
    }
}
