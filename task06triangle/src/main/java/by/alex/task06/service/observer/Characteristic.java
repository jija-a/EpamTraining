package by.alex.task06.service.observer;

public class Characteristic {

    /**
     * Helper number to create hash code.
     */
    private static final Integer HASH_PRIME = 31;

    /**
     * Area of figure.
     */
    private Double area;

    /**
     * Perimeter of figure.
     */
    private Double perimeter;

    /**
     * Area field getter.
     *
     * @return area field value
     */
    public double getArea() {
        return area;
    }

    /**
     * Area field setter.
     *
     * @param areaValue - value of area
     */
    public void setArea(final double areaValue) {
        this.area = areaValue;
    }

    /**
     * Perimeter field getter.
     *
     * @return perimeter field value
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * Perimeter field setter.
     *
     * @param perimeterValue - value of perimeter
     */
    public void setPerimeter(final double perimeterValue) {
        this.perimeter = perimeterValue;
    }

    /**
     * Equals method, overridden from {@link Object} class.
     */
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Characteristic)) {
            return false;
        }
        Characteristic c = (Characteristic) o;
        return Double.compare(c.getArea(), this.area) == 0
                && Double.compare(c.getPerimeter(), this.perimeter) == 0;
    }

    /**
     * Hashcode method, overridden from {@link Object} class.
     */
    @Override
    public int hashCode() {
        int prime = HASH_PRIME;
        int result = 1;
        result = prime * result
                + ((perimeter == null) ? 0 : perimeter.hashCode());
        result = prime * result + ((area == null) ? 0 : area.hashCode());
        return result;
    }

    /**
     * ToString method, overridden from {@link Object} class.
     */
    @Override
    public String toString() {
        return "Characteristic{"
                + "area=" + area
                + ", perimeter=" + perimeter
                + '}';
    }
}
