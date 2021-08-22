package by.alex.task04.context.impl;

import by.alex.task04.context.ApplicationContext;
import by.alex.task04.context.InitializingException;
import by.alex.task04.context.config.ApplicationConfig;
import by.alex.task04.dao.BaseEntityFileReader;
import by.alex.task04.dao.impl.AccountFileReaderImpl;
import by.alex.task04.domain.Account;
import by.alex.task04.domain.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextImpl.class);
    public static final ApplicationContext APPLICATION_CONTEXT = new ApplicationContextImpl();

    private Collection<Account> accountCollection = new ArrayList<>();

    private ApplicationContextImpl() {
    }

    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) {
        LOGGER.trace("Retrieving entity list from context");
        Collection<T> collection = new ArrayList<>();

        if (tClass.equals(Account.class)) {
            collection = (Collection<T>) accountCollection;
        }

        return collection;
    }

    @Override
    public void init() throws InitializingException {
        LOGGER.info("Initializing application context");

        String accountFilePath = ApplicationConfig.getInputDir() + ApplicationConfig.getAccountFileName();
        BaseEntityFileReader reader = new AccountFileReaderImpl();
        try {
            reader.read(accountFilePath);
        } catch (IOException e) {
            LOGGER.error("Bad files", e);
            throw new InitializingException("bad files", e);
        }
    }

}
