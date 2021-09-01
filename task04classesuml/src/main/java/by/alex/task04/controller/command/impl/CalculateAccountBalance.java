package by.alex.task04.controller.command.impl;

import by.alex.task04.controller.command.Command;
import by.alex.task04.domain.Account;
import by.alex.task04.service.AccountService;
import by.alex.task04.service.impl.AccountServiceImpl;
import by.alex.task04.view.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

public class CalculateAccountBalance implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculateAccountBalance.class);
    private final AccountService service;

    public CalculateAccountBalance() {
        this.service = AccountServiceImpl.ACCOUNT_SERVICE;
    }

    @Override
    public void execute() {
        LOGGER.info("Executing calculating balance command");

        List<Account> accounts = service.findAllAccounts();
        BigDecimal balance = service.calculateAccountsBalance(accounts);
        ConsoleWriter.writeln(String.valueOf(balance));
    }

}
