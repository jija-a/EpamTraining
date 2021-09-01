package by.alex.task04.controller.command.impl;

import by.alex.task04.controller.command.Command;
import by.alex.task04.domain.Account;
import by.alex.task04.domain.AccountStatus;
import by.alex.task04.service.AccountService;
import by.alex.task04.service.impl.AccountServiceImpl;
import by.alex.task04.view.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

public class CalculateActiveAccountBalance implements Command {


    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateActiveAccountBalance.class);
    private final AccountService service;

    public CalculateActiveAccountBalance() {
        this.service = AccountServiceImpl.ACCOUNT_SERVICE;
    }

    @Override
    public void execute() {
        LOGGER.info("Calculating active acc balance command");

        List<Account> accounts = service.findAllAccounts();
        BigDecimal balance = service.calculateAccountsBalance(accounts, AccountStatus.ACTIVE);
        ConsoleWriter.writeln(String.valueOf(balance));
    }

}
