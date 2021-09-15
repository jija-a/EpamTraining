package by.alex.task06.dao.repository.storage;

import by.alex.task06.domain.Triangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TriangleStorage {

    public static final TriangleStorage STORAGE = new TriangleStorage();
    private List<Triangle> triangles;

    public TriangleStorage() {
        triangles = new ArrayList<>();
    }

    public List<Triangle> getAll() {
        return triangles;
    }

    public Optional<Triangle> findById(long id) {
        return triangles.stream().filter(triangle -> triangle.getId().equals(id)).findAny();
    }

}
