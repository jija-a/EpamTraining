package by.alex.task08.service.specification;

import by.alex.task08.domain.Magazine;
import by.alex.task08.domain.Newspaper;
import by.alex.task08.domain.Paper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.testng.Assert.*;

public class IdSpecificationTest {

    Paper expected;
    Paper paper;

    @BeforeTest
    public void before() {
        expected = new Magazine();
        paper = new Newspaper();
    }

    @Test
    public void testSortById() {
        expected.setId(1L);
        paper.setId(2L);

        Set<Paper> papers = new TreeSet<>(new IdSpecification());

        papers.add(paper);
        papers.add(expected);
        Paper actual = papers.iterator().next();

        assertEquals(actual, expected);
    }
}