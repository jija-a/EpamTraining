package by.alex.task06.domain;

import by.alex.task06.service.observer.FigureEvent;
import by.alex.task06.service.observer.FigureObserver;
import by.alex.task06.service.observer.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Circle extends Figure implements Observable {

    /**
     * Center point of circle {@link CustomPoint}.
     */
    private CustomPoint centerPoint;

    /**
     * Circle radius value.
     */
    private Double radius;

    /**
     * Circle name value.
     */
    private String name;

    /**
     * @see FigureObserver
     */
    private final transient List<FigureObserver> observers;

    /**
     * Class constructor.
     *
     * @param centerPointValue - circle center point
     * @param radiusValue      - circle radius
     * @param nameValue        - circle name
     */
    public Circle(final CustomPoint centerPointValue,
                  final double radiusValue,
                  final String nameValue) {

        this.centerPoint = centerPointValue;
        this.radius = radiusValue;
        this.name = nameValue;
        this.observers = new ArrayList<>();
    }

    /**
     * Center point field getter.
     *
     * @return {@link CustomPoint}
     */
    public CustomPoint getCenterPoint() {
        return centerPoint;
    }

    /**
     * Center point field setter.
     *
     * @param centerPointValue - {@link CustomPoint}
     */
    public void setCenterPoint(final CustomPoint centerPointValue) {
        this.centerPoint = centerPointValue;
    }

    /**
     * Radius field getter.
     *
     * @return radius(double)
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Radius field setter.
     *
     * @param radiusValue - value of circle radius(double)
     */
    public void setRadius(final double radiusValue) {
        this.radius = radiusValue;
    }

    /**
     * Name field getter.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Name field setter.
     *
     * @param nameValue - name of circle(String)
     */
    public void setName(final String nameValue) {
        this.name = nameValue;
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
        if (!(o instanceof Circle)) {
            return false;
        }
        Circle c = (Circle) o;
        return c.getCenterPoint().equals(this.centerPoint)
                && Double.compare(c.getRadius(), this.radius) == 0
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
        result = prime * result + ((radius == null) ? 0 : radius.hashCode());
        result = prime * result
                + ((centerPoint == null) ? 0 : centerPoint.hashCode());
        return result;
    }

    /**
     * ToString method, overridden from {@link Object} class.
     */
    @Override
    public String toString() {
        return "Circle{"
                + "centerPoint=" + centerPoint
                + ", radius=" + radius
                + ", name='" + name + '\''
                + '}';
    }
}
