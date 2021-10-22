package task08.service.builder.xml;

import task08.dao.DaoException;
import task08.domain.Paper;
import task08.service.specification.IdSpecification;

import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractPaperBuilder {

    /**
     * {@link Set} where will be stored parsed {@link Paper}.
     */
    protected Set<Paper> papers;

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
    public abstract void buildSetPapers(String fileName) throws DaoException, DaoException;

}
