package by.alex.task04.service.impl;

import by.alex.task04.domain.Account;
import by.alex.task04.domain.AccountStatus;
import by.alex.task04.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AccountServiceImplTest {

    private AccountService service = AccountServiceImpl.ACCOUNT_SERVICE;

    private static Account account1;
    private static Account account2;
    private static Account account3;
    private static Account account4;
    private static Account account5;
    private static Account account6;
    private static Account account7;
    private static Account account8;
    private static Account account9;
    private static Account account10;

    @BeforeAll
    private static void initAccounts() {
        account1 = new Account("1", AccountStatus.ACTIVE, new BigDecimal(123));
        account2 = new Account("2", AccountStatus.BLOCKED, new BigDecimal(0));
        account3 = new Account("3", AccountStatus.ACTIVE, new BigDecimal(-123));
        account4 = new Account("4", AccountStatus.BLOCKED, new BigDecimal(123123123));
        account5 = new Account("5", AccountStatus.ACTIVE, new BigDecimal(-123123123));
        account6 = new Account("6", AccountStatus.BLOCKED, new BigDecimal(123));
        account7 = new Account("7", AccountStatus.ACTIVE, new BigDecimal(0));
        account8 = new Account("8", AccountStatus.BLOCKED, new BigDecimal(-123));
        account9 = new Account("9", AccountStatus.ACTIVE, new BigDecimal(123123123));
        account10 = new Account("10", AccountStatus.BLOCKED, new BigDecimal(-123123123));
    }

    static List<Account> accountProvider() {

        return new ArrayList<>() {{
            add(account1);
            add(account2);
            add(account3);
            add(account4);
            add(account5);
            add(account6);
            add(account7);
            add(account8);
            add(account9);
            add(account10);
        }};
    }

    static Stream<Arguments> accountAndExistingIdProvider() {
        List<Account> accounts = accountProvider();
        return Stream.of(
                arguments(accounts, 1L),
                arguments(accounts, 2L),
                arguments(accounts, 3L),
                arguments(accounts, 4L),
                arguments(accounts, 5L),
                arguments(accounts, 6L),
                arguments(accounts, 7L),
                arguments(accounts, 8L)
        );
    }

    static Stream<Arguments> accountAndNotExistingIdProvider() {
        List<Account> accounts = accountProvider();
        return Stream.of(
                arguments(accounts, 100L),
                arguments(accounts, -2L),
                arguments(accounts, 1233L),
                arguments(accounts, -24L),
                arguments(accounts, 0L),
                arguments(accounts, -123L),
                arguments(accounts, 123L),
                arguments(accounts, 11L)
        );
    }

    static Stream<Arguments> accountAndNotExistingNumberProvider() {
        List<Account> accounts = accountProvider();
        return Stream.of(
                arguments(accounts, "123"),
                arguments(accounts, "-123"),
                arguments(accounts, "0"),
                arguments(accounts, "-1"),
                arguments(accounts, "-123123123")
        );
    }

    static Stream<Arguments> accountAndExistingNumberProvider() {
        List<Account> accounts = accountProvider();
        return Stream.of(
                arguments(accounts, "1"),
                arguments(accounts, "2"),
                arguments(accounts, "3"),
                arguments(accounts, "4"),
                arguments(accounts, "5")
        );
    }

    @MethodSource("accountsProvider")
    static Stream<Arguments> listAndBigDecimalProvider() {
        List<Account> accounts = accountProvider();
        return Stream.of(
                arguments(accounts, new BigDecimal(0), new BigDecimal(100)),
                arguments(accounts, new BigDecimal(-1), new BigDecimal(0)),
                arguments(accounts, new BigDecimal(-1), new BigDecimal(-1)),
                arguments(accounts, new BigDecimal(0), new BigDecimal(0)),
                arguments(accounts, new BigDecimal(-123123), new BigDecimal(123123)),
                arguments(accounts, new BigDecimal(-123123123), new BigDecimal(123123123))
        );
    }

    @Test
    public void testWhenChangeStatusIsSuccess() {
        Account account = new Account("1");
        AccountStatus status = account.getStatus();
        service.changeAccountStatus(account);
        assertNotEquals(status, account.getStatus());
    }

    @ParameterizedTest
    @MethodSource("listAndBigDecimalProvider")
    public void testAccountBalanceIsBetweenGivenValues(List<Account> list, BigDecimal from, BigDecimal to) {
        List<Account> accounts = service.findAccountsByBalance(list, from, to);
        for (Account account : accounts) {
            assertTrue(account.getBalance().compareTo(from) >= 0 &&
                    account.getBalance().compareTo(to) <= 0);
        }
    }

    @ParameterizedTest
    @MethodSource("accountAndExistingIdProvider")
    public void testAccountWithGiverIdParameterExist(List<Account> accounts, Long id) {
        Optional<Account> account = service.findAccountById(accounts, id);
        assertTrue(account.isPresent());
    }

    @ParameterizedTest
    @MethodSource("accountAndNotExistingIdProvider")
    public void testAccountWithGivenIdParameterNotExist(List<Account> accounts, Long id) {
        Optional<Account> account = service.findAccountById(accounts, id);
        assertTrue(account.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("accountAndExistingNumberProvider")
    public void testAccountWithGivenNumberParameterExist(List<Account> accounts, String number) {
        Optional<Account> account = service.findAccountByNumber(accounts, number);
        assertTrue(account.isPresent());
    }

    @ParameterizedTest
    @MethodSource("accountAndNotExistingNumberProvider")
    public void testAccountWithGivenNumberParameterNotExist(List<Account> accounts, String number) {
        Optional<Account> account = service.findAccountByNumber(accounts, number);
        assertTrue(account.isEmpty());
    }

    @Test
    public void testCalculatingAccountBalance() {
        Account account1 = new Account("1", AccountStatus.ACTIVE, new BigDecimal(1));
        Account account2 = new Account("1", AccountStatus.ACTIVE, new BigDecimal(1));

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        BigDecimal expected = new BigDecimal(2);
        BigDecimal actual = service.calculateAccountsBalance(accounts);
        assertEquals(expected, actual);
    }

}