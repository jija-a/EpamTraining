package by.alex.task08.dao.parser.xml;

import by.alex.task08.dao.DaoException;
import by.alex.task08.domain.Paper;
import by.alex.task08.service.specification.IdSpecification;

import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractPaperBuilder {

    /**
     * {@link Set} where will be stored parsed {@link Paper}.
     */
    private final Set<Paper> papers;

    protected AbstractPaperBuilder() {
        IdSpecification idSpecification = new IdSpecification();
        this.papers = new TreeSet<>(idSpecification);
    }

    /**
     * {@link Set} {@link Paper} getter.
     *
     * @return {@link Set} of {@link Paper}
     */
    public final Set<Paper> getPapers() {
        return this.papers;
    }

    /**
     * Abstract method to build set of papers.
     *
     * @param fileName - xml(or not necessary) file name
     */
    public abstract void buildSetPapers(String fileName) throws DaoException;

}
