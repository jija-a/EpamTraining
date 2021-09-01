package by.alex.task04.service.impl;

import by.alex.task04.context.impl.ApplicationContextImpl;
import by.alex.task04.domain.Account;
import by.alex.task04.domain.AccountStatus;
import by.alex.task04.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    public static final AccountService ACCOUNT_SERVICE = new AccountServiceImpl();

    @Override
    public void changeAccountStatus(Account account) {
        LOGGER.info("Changing account status");

        if (account.getStatus().equals(AccountStatus.ACTIVE)) {
            account.setStatus(AccountStatus.BLOCKED);
        } else {
            account.setStatus(AccountStatus.ACTIVE);
        }
    }

    @Override
    public List<Account> findAllAccounts() {
        LOGGER.info("Searching for all accounts");

        return (List<Account>) ApplicationContextImpl.APPLICATION_CONTEXT.retrieveBaseEntityList(Account.class);
    }

    @Override
    public List<Account> findAccountsByBalance(List<Account> accounts, BigDecimal from, BigDecimal to) {
        LOGGER.info("Searching for account by balance");

        return accounts.stream()
                .filter(account -> account.getBalance().compareTo(from) >= 0 &&
                        account.getBalance().compareTo(to) <= 0)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Account> findAccountById(List<Account> accounts, Long id) {
        LOGGER.info("Searching for account by id");

        return accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findAny();
    }

    @Override
    public Optional<Account> findAccountByNumber(List<Account> accounts, String number) {
        LOGGER.info("Searching for account by number");

        return accounts.stream()
                .filter(account -> account.getNumber().equals(number))
                .findAny();
    }

    @Override
    public List<Account> sortAccountsByBalance(List<Account> accounts, SortingType type) {
        LOGGER.info("Sorting by balance");

        if (type.equals(SortingType.ASC)) {
            accounts.sort(Comparator.comparing(Account::getBalance));
        } else {
            accounts.sort(Comparator.comparing(Account::getBalance).reversed());
        }

        return accounts;
    }

    @Override
    public BigDecimal calculateAccountsBalance(List<Account> accounts) {
        LOGGER.info("Calculating balance");

        BigDecimal balance = new BigDecimal(0);
        for (Account account : accounts) {
            balance = balance.add(account.getBalance());
        }

        return balance;
    }

    @Override
    public BigDecimal calculateAccountsBalance(List<Account> accounts, AccountStatus status) {
        LOGGER.info("Calculating balance");

        List<Account> list = accounts.stream()
                .filter(account -> account.getStatus().equals(status))
                .collect(Collectors.toList());

        return this.calculateAccountsBalance(list);
    }

}
