package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Circle;
import by.alex.task06.service.CircleService;
import by.alex.task06.service.ServiceFactory;
import by.alex.task06.service.observer.FigureRegistrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FindCircleByArea extends AbstractSpecification<Circle>
        implements CircleFindSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindCircleByArea.class);

    /**
     * Lower value of area.
     */
    private final double from;

    /**
     * Highest value of area.
     */
    private final double to;

    /**
     * {@link CircleService} instance.
     */
    private final CircleService service;

    /**
     * Class constructor.
     *
     * @param fromValue - lowest value(double)
     * @param toValue   - highest value(double)
     */
    public FindCircleByArea(final double fromValue, final double toValue) {
        this.from = fromValue;
        this.to = toValue;
        this.service = ServiceFactory.FACTORY.getCircleService();
    }

    @Override
    public boolean isSpecified(final Circle circle) {

        LOGGER.info("Searching for circle specified by area");
        long id = circle.getId();
        double area;
        if (FigureRegistrar.REGISTRAR.contains(id)) {
            area = FigureRegistrar.REGISTRAR.getCharacteristic(id).getArea();
        } else {
            area = service.calcArea(circle);
        }
        return area >= from && area <= to;
    }
}
