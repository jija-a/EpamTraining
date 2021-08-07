package com.epam.task02.controller.command.impl;

import com.epam.task02.context.ViewResolver;
import com.epam.task02.controller.command.Command;
import com.epam.task02.util.MessageManager;

import java.util.Locale;

public class ChangeLocaleCommand implements Command {

    private final Locale en = new Locale("en", "US");
    private final Locale ru = new Locale("ru", "RU");

    @Override
    public ViewResolver execute() {

        ViewResolver resolver = new ViewResolver();

        if (MessageManager.INSTANCE.getLocale().equals(en)) {
            MessageManager.INSTANCE.changeLocale(ru);
        } else {
            MessageManager.INSTANCE.changeLocale(en);
        }

        resolver.setOutput("Locale changed");
        return resolver;
    }

}
