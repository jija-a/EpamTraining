package by.alex.task06.dao.repository.impl;

import by.alex.task06.dao.repository.Repository;
import by.alex.task06.dao.repository.RepositoryException;
import by.alex.task06.dao.repository.specification.Specification;
import by.alex.task06.dao.repository.specification.find.TriangleFindSpecification;
import by.alex.task06.dao.repository.specification.sort.TriangleSortSpecification;
import by.alex.task06.dao.repository.storage.TriangleStorage;
import by.alex.task06.domain.Triangle;

import java.util.*;

public class TriangleRepositoryImpl implements Repository<Triangle> {

    private final Map<Long, Triangle> triangles = new HashMap<>();

    @Override
    public void add(final Triangle triangle) {
        TriangleStorage.STORAGE.addTriangle(triangle);
    }

    @Override
    public void remove(final Triangle triangle) {
        TriangleStorage.STORAGE.removeTriangle(triangle.getId());
    }

    @Override
    public void update(final Triangle triangle) throws RepositoryException {

        long id = triangle.getId();
        if (triangles.containsKey(id)) {
            throw new RepositoryException("Unable to update figure, the incoming figure with id: " + id +
                    "did not exist in repository");
        }
        Triangle originalTriangle = triangles.get(id);

        originalTriangle.setName(triangle.getName());
        originalTriangle.setPoints(triangle.getPoints());
        originalTriangle.setType(triangle.getType());
    }

    @Override
    public List<Triangle> query(final Specification<Triangle> specification)
            throws RepositoryException {

        List<Triangle> listToReturn;

        if (specification instanceof TriangleFindSpecification) {
            listToReturn = this.findTrianglesBySpecification(specification);
        } else if (specification instanceof TriangleSortSpecification) {
            listToReturn = this.sortTrianglesBySpecification(specification);
        } else {
            throw new RepositoryException("Unable to complete query: wrong specification. " +
                    "It must be instance of sort or find specification");
        }

        return listToReturn;
    }

    private List<Triangle> sortTrianglesBySpecification(
            final Specification<Triangle> specification) {
        //todo
        return null;
    }

    private List<Triangle> findTrianglesBySpecification(
            final Specification<Triangle> specification) {

        List<Triangle> listToReturn = new ArrayList<>();

        TriangleStorage.STORAGE.getAll().forEach((id, triangle) -> {
            if (specification.isSpecified(triangle)) {
                listToReturn.add(triangle);
            }
        });

        return listToReturn;
    }

}
