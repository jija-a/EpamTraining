package by.alex.task06.domain;

public final class CustomPoint extends Figure {

    /**
     * x coordinate.
     */
    private Double x;

    /**
     * y coordinate.
     */
    private Double y;

    /**
     * Class constructor.
     *
     * @param xValue - value of x coordinate
     * @param yValue - value of y coordinate
     */
    public CustomPoint(final double xValue, final double yValue) {
        super();
        this.x = xValue;
        this.y = yValue;
    }

    /**
     * x coordinate getter.
     *
     * @return {@link Double} x
     */
    public Double getX() {
        return x;
    }

    /**
     * y coordinate getter.
     *
     * @return {@link Double} y
     */
    public Double getY() {
        return y;
    }

    /**
     * Equals method, overridden from {@link Object} class.
     */
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CustomPoint)) {
            return false;
        }
        CustomPoint c = (CustomPoint) o;
        return Double.compare(c.getX(), this.x) == 0
                && Double.compare(c.getY(), this.y) == 0;
    }

    /**
     * HashCode method, overridden from {@link Object} class.
     */
    @Override
    public int hashCode() {
        int prime = HASH_PRIME;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }

    /**
     * ToString method, overridden from {@link Object} class.
     */
    @Override
    public String toString() {
        return "Point{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }
}
