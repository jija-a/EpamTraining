package com.epam.task07.service.interpreter;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrecedenceTest {

    @Test
    public void testThatShiftHasTenPrecedence(){
        String shift = ">>";
        int expected = 10;
        int actual = Precedence.precedence(shift);
        assertEquals(actual, expected);
    }

    @Test
    public void testThatIfThereIsNoSuchSymbolPrecedenceIsZero(){
        String parentheses = "(";
        int expected = 0;
        int actual = Precedence.precedence(parentheses);
        assertEquals(actual, expected);
    }
}
