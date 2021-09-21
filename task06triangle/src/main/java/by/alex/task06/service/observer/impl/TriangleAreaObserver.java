package by.alex.task06.service.observer.impl;

import by.alex.task06.domain.Triangle;
import by.alex.task06.service.ServiceFactory;
import by.alex.task06.service.TriangleService;
import by.alex.task06.service.observer.Characteristic;
import by.alex.task06.service.observer.FigureEvent;
import by.alex.task06.service.observer.FigureObserver;
import by.alex.task06.service.observer.FigureRegistrar;

public class TriangleAreaObserver implements FigureObserver {

    /**
     * {@link TriangleService} instance.
     */
    private final TriangleService service;

    /**
     * Class constructor.
     */
    public TriangleAreaObserver() {
        this.service = ServiceFactory.FACTORY.getTriangleService();
    }

    /**
     * @see FigureObserver
     */
    @Override
    public void update(final FigureEvent event) {

        Triangle triangle = (Triangle) event.getSource();
        double area = service.calcArea(triangle);

        long id = triangle.getId();
        Characteristic characteristic;
        if (FigureRegistrar.REGISTRAR.contains(id)) {
            characteristic = FigureRegistrar.REGISTRAR.getCharacteristic(id);
        } else {
            characteristic = new Characteristic();
            FigureRegistrar.REGISTRAR.putCharacteristic(id, characteristic);
        }
        characteristic.setArea(area);
    }
}
