package by.alex.task06.dao.repository;

import by.alex.task06.dao.repository.specification.Specification;

import java.util.List;

public interface Repository<T> {

    void add(T entity);
    void remove(T entity);
    void update(T entity) throws RepositoryException;

    List<T> query(Specification<T> specification) throws RepositoryException;
}
