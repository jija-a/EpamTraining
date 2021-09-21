package by.alex.task06.dao.repository;

import by.alex.task06.dao.repository.specification.FindSpecification;
import by.alex.task06.dao.repository.specification.SortSpecification;

import java.util.List;

public interface Repository<T> {

    /**
     * Method to add entity to repository.
     * Add and notify {@link by.alex.task06.service.observer.FigureObserver}
     * about it.
     *
     * @param entity - {@link by.alex.task06.domain.Figure} child.
     */
    void add(T entity);

    /**
     * Method to remove entity from repository.
     * Remove {@link by.alex.task06.service.observer.FigureObserver}
     * from it.
     *
     * @param entity - {@link by.alex.task06.domain.Figure} child.
     */
    void remove(T entity);

    /**
     * Method to update entity in repository.
     * Notify {@link by.alex.task06.service.observer.FigureObserver}
     * about it.
     *
     * @param entity - {@link by.alex.task06.domain.Figure} child.
     */
    void update(T entity) throws RepositoryException;

    /**
     * Method to search entity in repository by certain
     * {@link FindSpecification}.
     *
     * @param specification - {@link FindSpecification} implementation
     * @return list of {@link by.alex.task06.domain.Figure} child
     */
    List<T> query(FindSpecification<T> specification)
            throws RepositoryException;

    /**
     * Method to sort entity by {@link SortSpecification}
     * in repository and return it.
     *
     * @param specification - {@link SortSpecification} implementation
     * @return list of {@link by.alex.task06.domain.Figure} child
     */
    List<T> sort(SortSpecification<T> specification)
            throws RepositoryException;
}
