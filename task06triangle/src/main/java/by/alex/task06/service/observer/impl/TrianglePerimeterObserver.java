package by.alex.task06.service.observer.impl;

import by.alex.task06.domain.Triangle;
import by.alex.task06.service.ServiceFactory;
import by.alex.task06.service.TriangleService;
import by.alex.task06.service.observer.Characteristic;
import by.alex.task06.service.observer.FigureEvent;
import by.alex.task06.service.observer.FigureObserver;
import by.alex.task06.service.observer.FigureRegistrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrianglePerimeterObserver implements FigureObserver {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TrianglePerimeterObserver.class);

    /**
     * {@link TriangleService} instance.
     */
    private final TriangleService service;

    /**
     * Class constructor.
     */
    public TrianglePerimeterObserver() {
        this.service = ServiceFactory.FACTORY.getTriangleService();
    }

    /**
     * @see FigureObserver
     */
    @Override
    public void update(final FigureEvent event) {
        Triangle triangle = (Triangle) event.getSource();
        double perimeter = service.calcPerimeter(triangle);

        long id = triangle.getId();
        LOGGER.info("Updating figure characteristic with id - {}", id);
        Characteristic characteristic;
        if (FigureRegistrar.REGISTRAR.contains(id)) {
            characteristic = FigureRegistrar.REGISTRAR.getCharacteristic(id);
        } else {
            characteristic = new Characteristic();
            FigureRegistrar.REGISTRAR.putCharacteristic(id, characteristic);
        }
        characteristic.setPerimeter(perimeter);
    }
}
