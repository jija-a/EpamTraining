package com.epam.task07.domain;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CompositeTest {

    TextComponent component;
    TextComponent symbol;

    @BeforeTest
    public void before() {
        this.component = new Composite();
        this.symbol = new TextSymbol('a');
    }

    @Test
    public void testAdd() {
        component.add(symbol);
        int count = component.count();
        Assert.assertEquals(count, 1);
    }

    @Test
    public void testCollect() {
        String collected = component.collect();
        Assert.assertEquals(collected, symbol.collect());
    }

    @Test
    public void testGetChild() {
        TextComponent symbol = component.getChild(0);
        Assert.assertNotNull(symbol);
    }

    @Test
    public void testCount() {
        int count = component.count();
        Assert.assertEquals(count, 1);
    }

    @Test
    public void testRemove() {
        component.remove(symbol);
        int count = component.count();
        Assert.assertEquals(count, 0);
    }
}