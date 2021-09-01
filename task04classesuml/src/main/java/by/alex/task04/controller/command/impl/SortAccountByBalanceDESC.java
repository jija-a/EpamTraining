package by.alex.task04.controller.command.impl;

import by.alex.task04.controller.command.Command;
import by.alex.task04.domain.Account;
import by.alex.task04.service.AccountService;
import by.alex.task04.service.impl.AccountServiceImpl;
import by.alex.task04.view.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SortAccountByBalanceDESC implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortAccountByBalanceDESC.class);
    private final AccountService service;

    public SortAccountByBalanceDESC() {
        this.service = AccountServiceImpl.ACCOUNT_SERVICE;
    }

    @Override
    public void execute() {
        LOGGER.info("Sorting acc by balance command");

        List<Account> accounts = service.findAllAccounts();
        accounts = service.sortAccountsByBalance(accounts, AccountService.SortingType.DESC);
        accounts.forEach(account -> ConsoleWriter.writeln(account.toString()));

    }

}
