package service.impl;

import java.util.HashSet;
import java.util.Set;

public class Storage {

    public static final Storage STORAGE = new Storage();
    private final Set<Integer> indexes;

    public Storage() {
        this.indexes = new HashSet<>();
    }

    public Set<Integer> getIndexes() {
        return indexes;
    }

}
