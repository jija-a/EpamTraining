package by.alex.task04.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Account extends AbstractBaseEntity {

    private final AccountStatus status;

    private final BigDecimal balance;

    public Account(AccountStatus status, BigDecimal balance) {
        this.status = status;
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public BigDecimal getBalance() {
        return balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Account account = (Account) o;
        return status == account.status && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), status, balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "status=" + status +
                ", balance=" + balance +
                '}';
    }

}
