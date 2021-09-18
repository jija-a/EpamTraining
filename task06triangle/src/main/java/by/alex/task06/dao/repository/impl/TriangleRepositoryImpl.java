package by.alex.task06.dao.repository.impl;

import by.alex.task06.dao.ApplicationProperties;
import by.alex.task06.dao.InitializingException;
import by.alex.task06.dao.parser.FigureParserFactory;
import by.alex.task06.dao.reader.impl.BaseFileReaderImpl;
import by.alex.task06.dao.repository.Repository;
import by.alex.task06.dao.repository.RepositoryException;
import by.alex.task06.dao.repository.specification.Specification;
import by.alex.task06.dao.repository.specification.find.TriangleFindSpecification;
import by.alex.task06.dao.repository.specification.sort.TriangleSortSpecification;
import by.alex.task06.domain.Figure;
import by.alex.task06.domain.Triangle;
import by.alex.task06.service.observer.listener.EventListener;
import by.alex.task06.service.observer.listener.TriangleUpdateListener;
import by.alex.task06.service.observer.publisher.EventManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TriangleRepositoryImpl implements Repository<Triangle> {

    private static long staticId = 0L;

    public static final TriangleRepositoryImpl REPOSITORY
            = new TriangleRepositoryImpl();

    private final Map<Long, Triangle> triangles;

    @Override
    public void init() throws InitializingException {
        String path = ApplicationProperties.PROPERTIES.getTrianglesFilePath();
        List<String> strings = BaseFileReaderImpl.READER.read(path);
        FigureParserFactory.FACTORY.getTriangleParser().parse(strings);
    }

    private TriangleRepositoryImpl() {
        this.triangles = new HashMap<>();
    }

    @Override
    public void add(final Triangle triangle) {
        long id = ++staticId;
        triangle.setId(id);
        triangles.put(id, triangle);
    }

    @Override
    public void remove(final Triangle triangle) {
        long id = triangle.getId();
        triangles.remove(id);
    }

    @Override
    public void update(final Triangle triangle) throws RepositoryException {

        long id = triangle.getId();
        if (triangles.containsKey(id)) {
            throw new RepositoryException("Unable to update figure,"
                    + " the incoming figure with id: "
                    + id + " did not exist in repository");
        }
        Triangle originalTriangle = triangles.get(id);

        originalTriangle.setName(triangle.getName());
        originalTriangle.setPoints(triangle.getPoints());
        originalTriangle.setTypes(triangle.getTypes());
    }

    @Override
    public List<Triangle> query(final Specification<Triangle> specification)
            throws RepositoryException {

        if (!(specification instanceof TriangleFindSpecification)) {
            throw new RepositoryException("Unable to complete query: "
                    + "Specification must be instance of sort");
        }

        List<Triangle> listToReturn = new ArrayList<>();
        triangles.forEach((id, triangle) -> {
            if (specification.isSpecified(triangle)) {
                listToReturn.add(triangle);
            }
        });

        return listToReturn;
    }

    @Override
    public List<Triangle> sort(Specification<Triangle> specification)
            throws RepositoryException {

        if (!(specification instanceof TriangleSortSpecification)) {
            throw new RepositoryException("Unable to complete sorting: "
                    + "Specification must be instance of sort");
        }
        throw new UnsupportedOperationException();
    }

}
