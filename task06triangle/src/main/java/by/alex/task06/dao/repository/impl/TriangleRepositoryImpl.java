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
import by.alex.task06.dao.repository.specification.find.TriangleFindSpecification;
import by.alex.task06.dao.repository.specification.sort.TriangleSortSpecification;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.observer.impl.TriangleAreaObserver;
import by.alex.task06.service.observer.impl.TrianglePerimeterObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TriangleRepositoryImpl implements Repository<Triangle> {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TriangleRepositoryImpl.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final TriangleRepositoryImpl REPOSITORY
            = new TriangleRepositoryImpl();

    /**
     * Triangle storage. {@link Long} Id as a key,
     * {@link Triangle} as a value
     */
    private final Map<Long, Triangle> triangles;

    /**
     * Private class constructor.
     */
    private TriangleRepositoryImpl() {
        this.triangles = new HashMap<>();
        init();
    }

    /**
     * Method initializes repository. And call add() method
     * to add {@link Triangle} entites to repository.
     *
     * @throws InitializingError if can't read file
     */
    private void init() throws InitializingError {
        String filePath = ApplicationProperties.PROPERTIES
                .getTrianglesFilePath();
        List<String> fileLines = BaseFileReaderImpl.READER.read(filePath);
        List<Triangle> triangleList = FigureParserFactory.FACTORY
                .getTriangleParser().parse(fileLines);
        for (Triangle triangle : triangleList) {
            this.add(triangle);
        }
    }

    @Override
    public void add(final Triangle triangle) {
        long id = IdGenerator.generate();
        LOGGER.info("Adding triangle with id: {} to repository", id);
        triangle.setId(id);
        triangles.put(id, triangle);

        triangle.attach(new TriangleAreaObserver(),
                new TrianglePerimeterObserver());
        triangle.notifyObservers();
    }

    @Override
    public void remove(final Triangle triangle) {
        long id = triangle.getId();
        LOGGER.info("Removing triangle with id: {} from repository", id);
        triangles.remove(id);

        triangle.detach(new TriangleAreaObserver());
    }

    @Override
    public void update(final Triangle triangle) throws RepositoryException {

        long id = triangle.getId();
        LOGGER.info("Updating triangle with id: {} in repository", id);

        if (!triangles.containsKey(id)) {
            throw new RepositoryException("Unable to update figure,"
                    + " the incoming figure with id: "
                    + id + " did not exist in repository");
        }
        Triangle originalTriangle = triangles.get(id);

        originalTriangle.setName(triangle.getName());
        originalTriangle.setPoints(triangle.getPoints());
        originalTriangle.setTypes(triangle.getTypes());

        triangle.notifyObservers();
    }

    @Override
    public List<Triangle> query(final FindSpecification<Triangle> specification)
            throws RepositoryException {

        LOGGER.info("Searching for triangle in repository");
        if (!(specification instanceof TriangleFindSpecification)) {
            throw new RepositoryException("Unable to complete query: "
                    + "Specification must be instance of find");
        }

        List<Triangle> listToReturn = new ArrayList<>();
        this.triangles.forEach((id, triangle) -> {
            if (specification.isSpecified(triangle)) {
                listToReturn.add(triangle);
            }
        });

        return listToReturn;
    }

    @Override
    public List<Triangle> sort(final SortSpecification<Triangle> specification)
            throws RepositoryException {

        LOGGER.info("Sorting triangles in repository");
        if (!(specification instanceof TriangleSortSpecification)) {
            throw new RepositoryException("Unable to complete sorting: "
                    + "Specification must be instance of sort");
        }

        List<Triangle> listToReturn = new ArrayList<>();
        for (Map.Entry<Long, Triangle> triangle : this.triangles.entrySet()) {
            listToReturn.add(triangle.getValue());
        }

        listToReturn.sort(specification);
        return listToReturn;
    }

}
