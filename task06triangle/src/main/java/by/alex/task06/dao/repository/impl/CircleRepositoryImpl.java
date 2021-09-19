package by.alex.task06.dao.repository.impl;

import by.alex.task06.dao.repository.IdGenerator;
import by.alex.task06.dao.repository.Repository;
import by.alex.task06.dao.repository.RepositoryException;
import by.alex.task06.dao.repository.specification.FindSpecification;
import by.alex.task06.dao.repository.specification.SortSpecification;
import by.alex.task06.dao.repository.specification.find.CircleFindSpecification;
import by.alex.task06.dao.repository.specification.sort.CircleSortSpecification;
import by.alex.task06.domain.Circle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CircleRepositoryImpl implements Repository<Circle> {

    public static final CircleRepositoryImpl REPOSITORY
            = new CircleRepositoryImpl();

    private final Map<Long, Circle> circles;

    private CircleRepositoryImpl() {
        circles = new HashMap<>();
    }

    @Override
    public void add(final Circle circle) {
        long id = IdGenerator.generate();
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
    public List<Circle> query(final FindSpecification<Circle> specification)
            throws RepositoryException {

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

        if (!(specification instanceof CircleSortSpecification)) {
            throw new RepositoryException("Unable to complete sorting: "
                    + "Specification must be instance of sort");
        }

        List<Circle> listToReturn = new ArrayList<>();
        for (Map.Entry<Long, Circle> circleEntry: this.circles.entrySet()) {
            listToReturn.add(circleEntry.getValue());
        }

        listToReturn.sort(specification);
        return listToReturn;
    }
}
