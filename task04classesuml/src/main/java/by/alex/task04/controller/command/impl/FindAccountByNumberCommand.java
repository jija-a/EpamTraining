package by.alex.task04.controller.command.impl;

import by.alex.task04.controller.command.Command;
import by.alex.task04.domain.Account;
import by.alex.task04.service.AccountService;
import by.alex.task04.service.impl.AccountServiceImpl;
import by.alex.task04.view.ConsoleWriter;
import by.alex.task04.view.InputReader;
import by.alex.task04.view.MessageConstant;
import by.alex.task04.view.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class FindAccountByNumberCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindAccountByNumberCommand.class);
    private final AccountService service;

    public FindAccountByNumberCommand() {
        this.service = AccountServiceImpl.ACCOUNT_SERVICE;
    }

    @Override
    public void execute() {
        LOGGER.info("Searching for acc by number command");

        List<Account> accounts = service.findAllAccounts();
        ConsoleWriter.writeln(MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_INPUT_ACC_NUMBER));
        String number = InputReader.readLine();

        Optional<Account> account = service.findAccountByNumber(accounts, number);
        account.ifPresent(a -> ConsoleWriter.writeln(a.toString()));
    }

}
