package by.alex.task06.dao.repository.impl;

import by.alex.task06.dao.ApplicationProperties;
import by.alex.task06.dao.InitializingException;
import by.alex.task06.dao.parser.FigureParserFactory;
import by.alex.task06.dao.reader.impl.BaseFileReaderImpl;
import by.alex.task06.dao.repository.Repository;
import by.alex.task06.dao.repository.RepositoryException;
import by.alex.task06.dao.repository.specification.Specification;
import by.alex.task06.domain.Circle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CircleRepositoryImpl implements Repository<Circle> {

    private static long staticId = 0L;
    public static final CircleRepositoryImpl REPOSITORY
            = new CircleRepositoryImpl();

    private final Map<Long, Circle> circles;

    @Override
    public void init() throws InitializingException {
        String path = ApplicationProperties.PROPERTIES.getCirclesFilePath();
        List<String> strings = BaseFileReaderImpl.READER.read(path);
        FigureParserFactory.FACTORY.getCirclesParser().parse(strings);
    }

    private CircleRepositoryImpl() {
        circles = new HashMap<>();
    }

    @Override
    public void add(final Circle circle) {
        long id = ++staticId;
        circle.setId(id);
        circles.put(id, circle);
    }

    @Override
    public void remove(final Circle circle) {
        long id = circle.getId();
        circles.remove(id);
    }

    @Override
    public void update(final Circle circle) throws RepositoryException {

        long id = circle.getId();
        if (circles.containsKey(id)) {
            throw new RepositoryException("Unable to update figure,"
                    + " the incoming figure with id: "
                    + id + " did not exist in repository");
        }
        Circle originalCircle = circles.get(id);

        originalCircle.setCenterPoint(circle.getCenterPoint());
        originalCircle.setRadius(circle.getRadius());
    }

    @Override
    public List<Circle> query(final Specification<Circle> specification)
            throws RepositoryException {

        throw new UnsupportedOperationException();
    }

    @Override
    public List<Circle> sort(Specification<Circle> specification)
            throws RepositoryException {

        throw new UnsupportedOperationException();
    }
}
