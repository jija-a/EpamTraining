package by.alex.task06.dao.repository;

import by.alex.task06.dao.repository.specification.FindSpecification;
import by.alex.task06.dao.repository.specification.SortSpecification;

import java.util.List;

public interface Repository<T> {

    void add(T entity);

    void remove(T entity);

    void update(T entity) throws RepositoryException;

    List<T> query(FindSpecification<T> specification)
            throws RepositoryException;

    List<T> sort(SortSpecification<T> specification)
            throws RepositoryException;
}
