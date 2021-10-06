package by.alex.task08.domain;

import java.util.Objects;

public class Newspaper extends Paper {

    private String index;

    public Newspaper() {
        super();
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
        Newspaper newspaper = (Newspaper) o;
        return index.equals(newspaper.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), index);
    }

    @Override
    public String toString() {
        return super.toString() + '\n'
                + "index='" + index + '\''
                + '}';
    }
}
