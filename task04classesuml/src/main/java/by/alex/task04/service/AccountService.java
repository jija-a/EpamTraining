package by.alex.task04.service;

import by.alex.task04.domain.Account;
import by.alex.task04.domain.AccountStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    enum SortingType {
        ASC, DESC;
    }

    void changeAccountStatus(Account account);

    List<Account> findAllAccounts();

    List<Account> findAccountsByBalance(List<Account> accounts, BigDecimal from, BigDecimal to);

    Optional<Account> findAccountById(List<Account> accounts, Long id);

    Optional<Account> findAccountByNumber(List<Account> accounts, String number);

    List<Account> sortAccountsByBalance(List<Account> accounts, SortingType type);

    BigDecimal calculateAccountsBalance(List<Account> accounts);

    BigDecimal calculateAccountsBalance(List<Account> accounts, AccountStatus status);

}
