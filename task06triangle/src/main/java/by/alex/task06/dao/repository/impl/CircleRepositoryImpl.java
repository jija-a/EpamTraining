package by.alex.task06.dao.repository.impl;

import by.alex.task06.dao.ApplicationProperties;
import by.alex.task06.dao.InitializingError;
import by.alex.task06.dao.parser.FigureParserFactory;
import by.alex.task06.dao.reader.impl.BaseFileReaderImpl;
import by.alex.task06.dao.repository.IdGenerator;
import by.alex.task06.dao.repository.Repository;
import by.alex.task06.dao.repository.RepositoryException;
import by.alex.task06.dao.repository.specification.FindSpecification;
import by.alex.task06.dao.repository.specification.SortSpecification;
import by.alex.task06.dao.repository.specification.find.CircleFindSpecification;
import by.alex.task06.dao.repository.specification.sort.CircleSortSpecification;
import by.alex.task06.domain.Circle;
import by.alex.task06.service.observer.impl.CircleAreaObserver;
import by.alex.task06.service.observer.impl.CirclePerimeterObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CircleRepositoryImpl implements Repository<Circle> {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CircleRepositoryImpl.class);

    /**
     * Repository instance (Singleton pattern).
     */
    public static final CircleRepositoryImpl REPOSITORY
            = new CircleRepositoryImpl();

    /**
     * Map to store circles by id as key and circle as value.
     */
    private final Map<Long, Circle> circles;

    /**
     * Class constructor.
     */
    private CircleRepositoryImpl() {
        circles = new HashMap<>();
        init();
    }

    /**
     * Method initializes repository. And call add() method
     * to add {@link Circle} entites to repository.
     *
     * @throws InitializingError if can't read file
     */
    private void init() throws InitializingError {
        String filePath = ApplicationProperties.PROPERTIES
                .getCirclesFilePath();
        List<String> circleLines = BaseFileReaderImpl.READER.read(filePath);
        List<Circle> circleList = FigureParserFactory.FACTORY
                .getCirclesParser().parse(circleLines);
        for (Circle circle : circleList) {
            CircleRepositoryImpl.REPOSITORY.add(circle);
        }
    }

    @Override
    public void add(final Circle circle) {
        long id = IdGenerator.generate();
        LOGGER.info("Adding circle with id: {} to repository", id);
        circle.setId(id);
        circles.put(id, circle);

        circle.attach(new CircleAreaObserver(), new CirclePerimeterObserver());
        circle.notifyObservers();
    }

    @Override
    public void remove(final Circle circle) {
        long id = circle.getId();
        LOGGER.info("Removing circle with id: {} from repository", id);
        circles.remove(id);

        circle.detach(new CirclePerimeterObserver(), new CircleAreaObserver());
    }

    @Override
    public void update(final Circle circle) throws RepositoryException {

        long id = circle.getId();
        LOGGER.info("Updating circle with id: {} in repository", id);

        if (circles.containsKey(id)) {
            throw new RepositoryException("Unable to update figure,"
                    + " the incoming figure with id: "
                    + id + " did not exist in repository");
        }
        Circle originalCircle = circles.get(id);

        originalCircle.setCenterPoint(circle.getCenterPoint());
        originalCircle.setRadius(circle.getRadius());

        circle.notifyObservers();
    }

    @Override
    public List<Circle> query(final FindSpecification<Circle> specification)
            throws RepositoryException {

        LOGGER.info("Searching for circle in repository");
        if (!(specification instanceof CircleFindSpecification)) {
            throw new RepositoryException("Unable to complete query: "
                    + "Specification must be instance of find");
        }

        List<Circle> listToReturn = new ArrayList<>();
        this.circles.forEach((id, circle) -> {
            if (specification.isSpecified(circle)) {
                listToReturn.add(circle);
            }
        });

        return listToReturn;
    }

    @Override
    public List<Circle> sort(final SortSpecification<Circle> specification)
            throws RepositoryException {

        LOGGER.info("Sorting circles in repository");
        if (!(specification instanceof CircleSortSpecification)) {
            throw new RepositoryException("Unable to complete sorting: "
                    + "Specification must be instance of sort");
        }

        List<Circle> listToReturn = new ArrayList<>();
        for (Map.Entry<Long, Circle> circleEntry : this.circles.entrySet()) {
            listToReturn.add(circleEntry.getValue());
        }

        listToReturn.sort(specification);
        return listToReturn;
    }
}
