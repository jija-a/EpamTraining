package by.alex.task04.controller.command.impl;

import by.alex.task04.controller.command.Command;
import by.alex.task04.domain.Account;
import by.alex.task04.service.AccountService;
import by.alex.task04.service.impl.AccountServiceImpl;
import by.alex.task04.view.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SortAccountByBalanceASC implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortAccountByBalanceASC.class);
    private final AccountService service;

    public SortAccountByBalanceASC() {
        this.service = AccountServiceImpl.ACCOUNT_SERVICE;
    }

    @Override
    public void execute() {
        LOGGER.info("Sorting acc by balance command");

        List<Account> accounts = service.findAllAccounts();
        accounts = service.sortAccountsByBalance(accounts, AccountService.SortingType.ASC);
        accounts.forEach(account -> ConsoleWriter.writeln(account.toString()));
    }

}
