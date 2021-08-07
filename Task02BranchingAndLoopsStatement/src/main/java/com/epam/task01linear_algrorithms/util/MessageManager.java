package com.epam.task01linear_algrorithms.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManager.class);
    public static final MessageManager INSTANCE = new MessageManager();

    private final String resources = "uilanguage";
    private ResourceBundle resourceBundle;


    private MessageManager() {
        LOGGER.debug("Initializing Message Manager");
        resourceBundle = ResourceBundle.getBundle(resources, Locale.getDefault());
    }

    public String getMessage(String key) {
        LOGGER.trace("Getting message from resource file");

        return resourceBundle.getString(key);
    }

    public void changeLocale(Locale locale) {
        LOGGER.debug("Changing locale");

        resourceBundle = ResourceBundle.getBundle(resources, locale);
    }

}
