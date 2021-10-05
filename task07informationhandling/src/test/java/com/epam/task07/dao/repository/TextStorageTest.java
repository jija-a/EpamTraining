package com.epam.task07.dao.repository;

import com.epam.task07.domain.Composite;
import com.epam.task07.domain.TextComponent;
import com.epam.task07.domain.TextSymbol;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextStorageTest {

    @Test
    public void objectFromStorageIsNotTheSame() {
        TextComponent component = new Composite();
        component.add(new TextSymbol('a'));
        TextStorage.STORAGE.setText(component);
        TextComponent componentFromStorage = TextStorage.STORAGE.getText();
        Assert.assertNotSame(component, componentFromStorage);
    }
}