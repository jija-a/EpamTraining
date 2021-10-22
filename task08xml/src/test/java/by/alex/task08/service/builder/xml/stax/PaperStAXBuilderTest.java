package by.alex.task08.service.builder.xml.stax;

import by.alex.task08.dao.DaoException;
import by.alex.task08.service.builder.xml.AbstractPaperBuilder;
import by.alex.task08.domain.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PaperStAXBuilderTest {
    AbstractPaperBuilder builderStax;
    Set<Paper> expected;
    String path;

    @BeforeTest
    public void before() {
        expected = new HashSet<>();
        path = "src/test/resources/papersTest.xml";

        Paper.Chars chars1 = new Paper.Chars(20, PaperGenre.NEWS, true, false, false,
                LocalDate.parse("2021-08-27"));
        Paper newspaper1 = new Newspaper(1L, "Guardian", chars1, "123456");

        Paper.Chars chars2 = new Paper.Chars(60, PaperGenre.SPORT, true, true, true,
                LocalDate.parse("2020-01-03"));
        Paper magazine1 = new Magazine(2L, "Football 2021", chars2, "234567");

        Paper.Chars chars3 = new Paper.Chars(10, PaperGenre.EDUCATION, false, true, false,
                LocalDate.parse("2015-04-10"));
        Paper booklet1 = new Booklet(3L, "Base physics", chars3);

        Paper.Chars chars4 = new Paper.Chars(24, PaperGenre.NEWS, true, false, false,
                LocalDate.parse("1987-02-13"));
        Paper newspaper2 = new Newspaper(4L, "Sun", chars4, "345678");

        Paper.Chars chars5 = new Paper.Chars(45, PaperGenre.LIFE, true, true, true,
                LocalDate.parse("1999-08-27"));
        Paper magazine2 = new Magazine(5L, "Living creatures", chars5, "456789");

        expected.add(newspaper1);
        expected.add(magazine1);
        expected.add(booklet1);
        expected.add(newspaper2);
        expected.add(magazine2);
    }

    @Test
    public void testActualEqualsExpected() throws DaoException {
        builderStax = new PaperStAXBuilder();
        builderStax.buildSetPapers(path);
        Set<Paper> actual = builderStax.getPapers();
        Assert.assertEquals(actual, expected);
    }
}