package by.alex.task06.dao.repository.impl;

import by.alex.task06.dao.repository.Repository;
import by.alex.task06.dao.repository.RepositoryException;
import by.alex.task06.dao.repository.specification.Specification;
import by.alex.task06.dao.repository.specification.find.TriangleFindSpecification;
import by.alex.task06.dao.repository.specification.sort.TriangleSortSpecification;
import by.alex.task06.dao.repository.storage.TriangleStorage;
import by.alex.task06.domain.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TriangleRepositoryImpl implements Repository<Triangle> {

    /**
     * @see Repository
     */
    @Override
    public void add(final Triangle triangle) {
        TriangleStorage.STORAGE.getAll().add(triangle);
    }

    /**
     * @see Repository
     */
    @Override
    public void remove(final Triangle triangle) {
        TriangleStorage.STORAGE.getAll().remove(triangle);
    }

    /**
     * @see Repository
     */
    @Override
    public void update(final Triangle triangle) throws RepositoryException {
        Optional<Triangle> originalTriangleOptional =
                TriangleStorage.STORAGE.findById(triangle.getId());

        if (originalTriangleOptional.isEmpty()) {
            throw new RepositoryException("Wrong triangle to update");
        }
        this.updateTriangleFields(originalTriangleOptional.get(), triangle);
    }

    /**
     * @see Repository
     */
    @Override
    public List<Triangle> query(final Specification<Triangle> specification)
            throws RepositoryException {

        List<Triangle> listToReturn;

        if (specification instanceof TriangleFindSpecification) {
            listToReturn = this.findTrianglesBySpecification(specification);
        } else if (specification instanceof TriangleSortSpecification) {
            listToReturn = this.sortTrianglesBySpecification(specification);
        } else {
            throw new RepositoryException("Wrong specification for query");
        }

        return listToReturn;
    }

    private void updateTriangleFields(final Triangle originalTriangle,
                                      final Triangle updatedTriangle) {
        originalTriangle.setName(updatedTriangle.getName());
        originalTriangle.setPoints(updatedTriangle.getPoints());
        originalTriangle.setType(updatedTriangle.getType());
    }

    private List<Triangle> sortTrianglesBySpecification(
            final Specification<Triangle> specification) {
        //todo
        return null;
    }

    private List<Triangle> findTrianglesBySpecification(
            final Specification<Triangle> specification) {

        List<Triangle> listToReturn = new ArrayList<>();
        for (Triangle triangle : TriangleStorage.STORAGE.getAll()) {
            if (specification.isSpecified(triangle)) {
                listToReturn.add(triangle);
            }
        }

        return listToReturn;
    }

}
