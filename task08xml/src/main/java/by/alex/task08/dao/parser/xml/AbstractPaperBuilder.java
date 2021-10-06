package by.alex.task08.dao.parser.xml;

import by.alex.task08.dao.DaoException;
import by.alex.task08.domain.Paper;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractPaperBuilder {

    private final Set<Paper> papers;

    protected AbstractPaperBuilder() {
        this.papers = new HashSet<>();
    }

    public Set<Paper> getPapers() {
        return this.papers;
    }

    public abstract void buildSetPapers(String fileName) throws DaoException;

}
