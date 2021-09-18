package by.alex.task06.dao.repository;

import by.alex.task06.dao.InitializingException;
import by.alex.task06.dao.repository.specification.Specification;

import java.util.List;

public interface Repository<T> {

    void init() throws InitializingException;

    void add(T entity);
    void remove(T entity);
    void update(T entity) throws RepositoryException;

    List<T> query(Specification<T> specification) throws RepositoryException;
    List<T> sort(Specification<T> specification) throws RepositoryException;
}
