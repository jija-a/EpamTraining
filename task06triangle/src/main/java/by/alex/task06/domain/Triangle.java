package by.alex.task06.domain;

import by.alex.task06.service.observer.FigureEvent;
import by.alex.task06.service.observer.FigureObserver;
import by.alex.task06.service.observer.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle extends Figure implements Observable {
    public enum TriangleType {
        /**
         * Triangle is Rectangular.
         */
        RECTANGULAR,
        /**
         * Triangle is Isosceles.
         */
        ISOSCELES,
        /**
         * Triangle is sharp angled.
         */
        SHARP_ANGLED,
        /**
         * Triangle is obtuse.
         */
        OBTUSE,
        /**
         * Triangle is equilateral.
         */
        EQUILATERAL;
    }

    /**
     * {@link CustomPoint} list.
     */
    private List<CustomPoint> points;

    /**
     * Triangle name.
     */
    private String name;

    /**
     * List of triangle {@link TriangleType}.
     */
    private List<TriangleType> types;

    /**
     * List of {@link FigureObserver}.
     */
    private final transient List<FigureObserver> observers;

    /**
     * Class constructor.
     *
     * @param pointsValue - triangle points
     * @param nameValue   - triangle name
     */
    public Triangle(final List<CustomPoint> pointsValue,
                    final String nameValue) {

        this.points = pointsValue;
        this.name = nameValue;
        this.observers = new ArrayList<>();
    }

    /**
     * Point list getter.
     *
     * @return {@link List} of {@link CustomPoint}
     */
    public List<CustomPoint> getPoints() {
        return points;
    }

    /**
     * Triangle points setter.
     *
     * @param pointsValue {@link CustomPoint} list
     */
    public void setPoints(final List<CustomPoint> pointsValue) {
        this.points = pointsValue;
    }

    /**
     * Triangle name getter.
     *
     * @return {@link String} name
     */
    public String getName() {
        return name;
    }

    /**
     * Triangle name setter.
     *
     * @param nameValue - {@link String} name of triangle
     */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }

    /**
     * Point type getter.
     *
     * @return {@link List} of {@link TriangleType}
     */
    public List<TriangleType> getTypes() {
        return types;
    }

    /**
     * Triangle types setter.
     *
     * @param typesValue - {@link TriangleType}
     */
    public void setTypes(final List<TriangleType> typesValue) {
        this.types = typesValue;
    }

    /**
     * @see Observable
     */
    @Override
    public void attach(final FigureObserver observer,
                       final FigureObserver... list) {
        observers.add(observer);
        observers.addAll(Arrays.asList(list));
    }

    /**
     * @see Observable
     */
    @Override
    public void detach(final FigureObserver observer,
                       final FigureObserver... list) {
        observers.remove(observer);
        observers.removeAll(Arrays.asList(list));
    }

    /**
     * @see Observable
     */
    @Override
    public void notifyObservers() {
        for (FigureObserver current : observers) {
            if (current != null) {
                current.update(new FigureEvent(this));
            }
        }
    }

    /**
     * Equals method, overridden from {@link Object} class.
     */
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Triangle)) {
            return false;
        }
        Triangle c = (Triangle) o;
        return c.getPoints().equals(this.points)
                && c.getTypes().equals(this.types)
                && c.getName().equals(this.name);
    }

    /**
     * HashCode method, overridden from {@link Object} class.
     */
    @Override
    public int hashCode() {
        int prime = HASH_PRIME;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((points == null) ? 0 : points.hashCode());
        result = prime * result + ((types == null) ? 0 : types.hashCode());
        return result;
    }

    /**
     * ToString method, overridden from {@link Object} class.
     */
    @Override
    public String toString() {
        return "Triangle{"
                + "points=" + points
                + ", name='" + name + '\''
                + ", types=" + types
                + '}';
    }
}
