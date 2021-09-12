package domain;

import java.util.Objects;

public class Limit {

    private final int higherLimit;
    private final int lowerLimit;

    public Limit(int lowerLimit, int higherLimit) {
        this.higherLimit = higherLimit;
        this.lowerLimit = lowerLimit;
    }

    public int getHigherLimit() {
        return higherLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Limit limit = (Limit) o;
        return higherLimit == limit.higherLimit && lowerLimit == limit.lowerLimit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(higherLimit, lowerLimit);
    }

    @Override
    public String toString() {
        return "Limit{" +
                "higherLimit=" + higherLimit +
                ", lowerLimit=" + lowerLimit +
                '}';
    }

}
