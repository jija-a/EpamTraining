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

import java.math.BigDecimal;
import java.util.List;

public class FindAccountByBalanceCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindAccountByBalanceCommand.class);
    private final AccountService service;

    public FindAccountByBalanceCommand() {
        this.service = AccountServiceImpl.ACCOUNT_SERVICE;
    }

    @Override
    public void execute() {
        LOGGER.info("Searching for acc by balance command");

        List<Account> accounts = service.findAllAccounts();
        ConsoleWriter.writeln(MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_INPUT_FROM) + ": ");
        int from = InputReader.readInt();

        ConsoleWriter.writeln(MessageManager.INSTANCE.getMessage(MessageConstant.OUTPUT_INPUT_TO) + ": ");
        int to = InputReader.readInt();

        accounts = service.findAccountsByBalance(accounts, new BigDecimal(from), new BigDecimal(to));
        accounts.forEach(account -> ConsoleWriter.writeln(account.toString()));
    }

}
