package by.alex.task08.dao.parser.xml.stax;

import by.alex.task08.dao.DaoException;
import by.alex.task08.dao.parser.xml.AbstractPaperBuilder;
import by.alex.task08.domain.Booklet;
import by.alex.task08.domain.Magazine;
import by.alex.task08.domain.Newspaper;
import by.alex.task08.domain.Paper;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class PaperStAXBuilderTest {
    AbstractPaperBuilder builderStax;
    Set<Paper> expected;

    @BeforeTest
    public void beforeClass() {
        expected = new HashSet<>();
        Paper newspaper1 = new Newspaper();
        expected.add(new Newspaper());
        expected.add(new Magazine());
        expected.add(new Booklet());
        expected.add(new Newspaper());
        expected.add(new Magazine());
    }

    @Test
    public void testActualEqualsExpected() throws DaoException {
        builderStax = new PaperStAXBuilder();
        builderStax.buildSetPapers("papersTest.xml");
        Set<Paper> actual = builderStax.getPapers();
        Assert.assertEquals(actual, expected);
    }
}