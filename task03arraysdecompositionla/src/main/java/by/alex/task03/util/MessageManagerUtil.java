package by.alex.task03.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageManagerUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageManagerUtil.class);
    public static final MessageManagerUtil INSTANCE = new MessageManagerUtil();

    private final String resources = "ui_language";
    private ResourceBundle resourceBundle;


    private MessageManagerUtil() {
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

    public Locale getLocale() {
        return resourceBundle.getLocale();
    }

}
