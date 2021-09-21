package by.alex.task06.service.observer.impl;

import by.alex.task06.domain.Circle;
import by.alex.task06.service.CircleService;
import by.alex.task06.service.ServiceFactory;
import by.alex.task06.service.observer.Characteristic;
import by.alex.task06.service.observer.FigureEvent;
import by.alex.task06.service.observer.FigureObserver;
import by.alex.task06.service.observer.FigureRegistrar;

public class CirclePerimeterObserver implements FigureObserver {

    /**
     * {@link CircleService} instance.
     */
    private final CircleService service;

    /**
     * Class constructor.
     */
    public CirclePerimeterObserver() {
        this.service = ServiceFactory.FACTORY.getCircleService();
    }

    /**
     * Method calculates area and creates or changes
     * it in {@link FigureRegistrar} map.
     *
     * @see FigureObserver
     */
    @Override
    public void update(final FigureEvent event) {

        Circle circle = (Circle) event.getSource();
        double area = service.calcArea(circle);

        long id = circle.getId();
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
