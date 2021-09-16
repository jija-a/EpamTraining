package by.alex.task06.dao.repository.storage;

import by.alex.task06.dao.InitializingException;
import by.alex.task06.domain.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TriangleStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(TriangleStorage.class);
    public static final TriangleStorage STORAGE = new TriangleStorage();
    private static Map<Long, Triangle> triangles;

    private TriangleStorage() {
        init();
    }

    private static void init() throws InitializingException {

    }

    public Map<Long, Triangle> getAll() {
        return triangles;
    }

    public void addTriangle(Triangle triangle) {
        triangles.put(triangle.getId(), triangle);
    }

    public void removeTriangle(Long id) {
        triangles.remove(id);
    }

}
