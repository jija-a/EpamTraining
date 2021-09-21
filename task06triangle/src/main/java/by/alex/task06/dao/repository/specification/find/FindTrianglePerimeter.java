package by.alex.task06.dao.repository.specification.find;

import by.alex.task06.dao.repository.specification.AbstractSpecification;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.ServiceFactory;
import by.alex.task06.service.TriangleService;
import by.alex.task06.service.observer.FigureRegistrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FindTrianglePerimeter extends AbstractSpecification<Triangle>
        implements TriangleFindSpecification {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FindTrianglePerimeter.class);

    /**
     * Lowest value of perimeter.
     */
    private final double from;

    /**
     * Highest value of perimeter.
     */
    private final double to;

    /**
     * {@link TriangleService} instance.
     */
    private final TriangleService service;

    /**
     * Class constructor.
     *
     * @param fromValue - lowest value
     * @param toValue   - highest value
     */
    public FindTrianglePerimeter(final double fromValue, final double toValue) {
        this.from = fromValue;
        this.to = toValue;
        this.service = ServiceFactory.FACTORY.getTriangleService();
    }

    @Override
    public boolean isSpecified(final Triangle triangle) {
        LOGGER.info("Searching for triangle specified by perimeter");
        long id = triangle.getId();
        double perimeter = FigureRegistrar.REGISTRAR
                .getCharacteristic(id).getArea();
        return perimeter >= from && perimeter <= to;
    }
}
