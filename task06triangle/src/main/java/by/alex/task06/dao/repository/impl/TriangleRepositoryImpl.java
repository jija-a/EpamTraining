package by.alex.task06.dao.repository.impl;

import by.alex.task06.dao.repository.IdGenerator;
import by.alex.task06.dao.repository.Repository;
import by.alex.task06.dao.repository.RepositoryException;
import by.alex.task06.dao.repository.specification.FindSpecification;
import by.alex.task06.dao.repository.specification.SortSpecification;
import by.alex.task06.dao.repository.specification.find.TriangleFindSpecification;
import by.alex.task06.dao.repository.specification.sort.TriangleSortSpecification;
import by.alex.task06.domain.Triangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class TriangleRepositoryImpl implements Repository<Triangle> {

    public static final TriangleRepositoryImpl REPOSITORY
            = new TriangleRepositoryImpl();

    private final Map<Long, Triangle> triangles;

    private TriangleRepositoryImpl() {
        this.triangles = new HashMap<>();
    }

    @Override
    public void add(final Triangle triangle) {
        long id = IdGenerator.generate();
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
        if (!triangles.containsKey(id)) {
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
    public List<Triangle> query(final FindSpecification<Triangle> specification)
            throws RepositoryException {

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
