package by.alex.task04.service.factory.impl;

import by.alex.task04.context.impl.ApplicationContextImpl;
import by.alex.task04.domain.Account;
import by.alex.task04.domain.AccountStatus;
import by.alex.task04.domain.UnknownEntityException;
import by.alex.task04.service.factory.BaseEntityFactory;
import by.alex.task04.service.factory.WrongArgumentsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class AccountFactory implements BaseEntityFactory<Account> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountFactory.class);

    @Override
    public Account create(Object... args) throws WrongArgumentsException {
        LOGGER.info("Creating account");
        Account account;

        try {
            if (args.length == 3) {
                account = this.createFromFile(args);
            } else if (args.length == 1) {
                account = new Account((String) args[0]);
            } else {
                throw new WrongArgumentsException("Wrong arguments for creating account");
            }
        } catch (UnknownEntityException e) {
            LOGGER.error("Failed to create, wrong status argument");
            throw new WrongArgumentsException();
        }

        ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Account.class).add(account);
        return account;
    }

    private Account createFromFile(Object[] args) throws UnknownEntityException {

        try {
            String number = (String) args[0];
            AccountStatus status = AccountStatus.resolveStatusById(Long.parseLong(String.valueOf(args[1])));
            BigDecimal balance = new BigDecimal(String.valueOf(args[2]));
            return new Account(number, status, balance);
        } catch (ClassCastException e) {
            throw new UnknownEntityException(e);
        }
    }

}
