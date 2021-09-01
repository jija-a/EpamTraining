package by.alex.task04.dao.impl;

import by.alex.task04.context.InitializingException;
import by.alex.task04.dao.BaseEntityFileReader;
import by.alex.task04.domain.Account;
import by.alex.task04.service.factory.BaseEntityFactory;
import by.alex.task04.service.factory.WrongArgumentsException;
import by.alex.task04.service.factory.impl.AccountFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountFileReaderImpl implements BaseEntityFileReader<Account> {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountFileReaderImpl.class);
    public static final AccountFileReaderImpl FILE_READER = new AccountFileReaderImpl();

    @Override
    public List<Account> read(String filePath) throws IOException, InitializingException {

        LOGGER.info("Reading account file");

        Scanner scanner = new Scanner(new File(filePath));
        if (!scanner.hasNextLine()) {
            LOGGER.error("Non readable account file");
            throw new InitializingException("Non readable file");
        }
        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();

        List<Account> accounts = new ArrayList<>();
        while (scanner.hasNext()) {
            String fileLine = scanner.next();
            String[] fileLineSplit = fileLine.split(";", 3);
            String number = fileLineSplit[0];
            String status = fileLineSplit[1];
            String balance = fileLineSplit[2];

            BaseEntityFactory<Account> factory = new AccountFactory();
            try {
                Account account = factory.create(number, status, balance);
                accounts.add(account);
            } catch (WrongArgumentsException e) {
                LOGGER.error("Bad files");
                throw new InitializingException("Bad files");
            }

        }
        scanner.close();

        return accounts;
    }

}