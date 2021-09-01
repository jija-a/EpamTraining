package by.alex.task04.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private static Account account;
    private static final String number = "1";
    private static final AccountStatus status = AccountStatus.ACTIVE;
    private static final BigDecimal balance = new BigDecimal(1);

    @BeforeAll
    static void createAccount() {
        account = new Account(number, status, balance);
    }

    @Test
    public void testGetter() {
        assertEquals(account.getNumber(), number);
        assertEquals(account.getBalance(), balance);
        assertEquals(account.getStatus(), status);
    }

    @Test
    public void testSetter() {
        BigDecimal changedBalance = new BigDecimal(0);
        AccountStatus changedStatus = AccountStatus.BLOCKED;
        account.setBalance(changedBalance);
        account.setStatus(changedStatus);
        assertEquals(account.getBalance(), changedBalance);
        assertEquals(account.getStatus(), changedStatus);
    }

}